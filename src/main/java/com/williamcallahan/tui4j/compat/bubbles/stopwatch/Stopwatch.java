package com.williamcallahan.tui4j.compat.bubbles.stopwatch;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;

import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Stopwatch bubble component.
 * Port of charmbracelet/bubbles/stopwatch.
 */
public class Stopwatch implements Model {

    private static final Duration DEFAULT_INTERVAL = Duration.ofSeconds(1);

    private static final AtomicInteger LAST_ID = new AtomicInteger(0);

    // Duration constants in nanoseconds for formatDuration()
    private static final long NANOS_PER_HOUR = 3_600_000_000_000L;
    private static final long NANOS_PER_MINUTE = 60_000_000_000L;
    private static final long NANOS_PER_SECOND = 1_000_000_000L;
    private static final long NANOS_PER_MILLI = 1_000_000L;
    private static final long NANOS_PER_MICRO = 1_000L;

    private Duration elapsed;
    private Duration interval;
    private int id;
    private int tag;
    private boolean running;

    public Stopwatch() {
        this(DEFAULT_INTERVAL);
    }

    public Stopwatch(Duration interval) {
        this.elapsed = Duration.ZERO;
        this.interval = interval;
        this.running = false;
        this.id = nextId();
    }

    public int id() {
        return id;
    }

    public Duration elapsed() {
        return elapsed;
    }

    /**
     * Sets the elapsed duration (for testing purposes).
     *
     * @param elapsed the elapsed duration
     */
    public void setElapsed(Duration elapsed) {
        this.elapsed = elapsed;
    }

    public Duration interval() {
        return interval;
    }

    public void setInterval(Duration interval) {
        this.interval = interval;
    }

    public boolean running() {
        return running;
    }

    @Override
    public Command init() {
        return start();
    }

    @Override
    public UpdateResult<Stopwatch> update(Message msg) {
        if (msg instanceof StartStopMsg startStopMsg) {
            return handleStartStop(startStopMsg.id(), startStopMsg.running());
        }
        if (msg instanceof StartStopMessage startStopMessage) {
            return handleStartStop(startStopMessage.id(), startStopMessage.running());
        }
        if (msg instanceof ResetMsg resetMsg) {
            return handleReset(resetMsg.id());
        }
        if (msg instanceof ResetMessage resetMessage) {
            return handleReset(resetMessage.id());
        }
        if (msg instanceof TickMsg tickMsg) {
            return handleTick(tickMsg.id(), tickMsg.tag());
        }
        if (msg instanceof TickMessage tickMessage) {
            return handleTick(tickMessage.id(), tickMessage.tag());
        }

        return UpdateResult.from(this);
    }

    /**
     * Renders the elapsed time.
     * <p>
     * Formats the duration similar to Go's time.Duration string representation (e.g., "1h2m3s").
     */
    @Override
    public String view() {
        return formatDuration(elapsed);
    }

    /**
     * Returns a command to resume the stopwatch tick loop.
     *
     * @return start command
     */
    public Command start() {
        return () -> new StartStopMsg(id, true);
    }

    /**
     * Returns a command to halt the tick loop.
     *
     * @return stop command
     */
    public Command stop() {
        return () -> new StartStopMsg(id, false);
    }

    /**
     * Returns a command to reset the elapsed time to zero.
     *
     * @return reset command
     */
    public Command reset() {
        return () -> new ResetMsg(id);
    }

    /**
     * Returns a command to switch between running and stopped states.
     *
     * @return toggle command
     */
    public Command toggle() {
        return () -> new StartStopMsg(id, !running);
    }

    private static int nextId() {
        return LAST_ID.incrementAndGet();
    }

    private Command tick() {
        return Command.tick(interval, __ -> new TickMsg(id, tag));
    }

    private UpdateResult<Stopwatch> handleStartStop(int messageId, boolean shouldRun) {
        if (messageId != 0 && messageId != id) {
            return UpdateResult.from(this);
        }
        running = shouldRun;
        if (running) {
            return UpdateResult.from(this, tick());
        }
        return UpdateResult.from(this);
    }

    private UpdateResult<Stopwatch> handleReset(int messageId) {
        if (messageId != 0 && messageId != id) {
            return UpdateResult.from(this);
        }
        elapsed = Duration.ZERO;
        return UpdateResult.from(this);
    }

    private UpdateResult<Stopwatch> handleTick(int messageId, int messageTag) {
        if (!running || (messageId != 0 && messageId != id)) {
            return UpdateResult.from(this);
        }
        if (messageTag > 0 && messageTag != tag) {
            return UpdateResult.from(this);
        }

        elapsed = elapsed.plus(interval);
        tag++;
        return UpdateResult.from(this, tick());
    }

    /** Formats duration in Go's time.Duration.String() style: "1h30m45s", "500ms", "1µs" */
    private static String formatDuration(Duration duration) {
        if (duration.isZero()) {
            return "0s";
        }

        long nanos = duration.toNanos();
        StringBuilder sb = new StringBuilder();

        if (nanos < 0) {
            sb.append("-");
            nanos = -nanos;
        }

        long hours = nanos / NANOS_PER_HOUR;
        if (hours > 0) {
            sb.append(hours).append("h");
            nanos %= NANOS_PER_HOUR;
        }

        long minutes = nanos / NANOS_PER_MINUTE;
        if (minutes > 0) {
            sb.append(minutes).append("m");
            nanos %= NANOS_PER_MINUTE;
        }

        if (hours == 0 && minutes == 0 && nanos < NANOS_PER_SECOND && nanos > 0) {
            if (nanos >= NANOS_PER_MILLI) {
                double ms = nanos / (double) NANOS_PER_MILLI;
                if (ms == (long) ms) {
                    sb.append((long) ms).append("ms");
                } else {
                    sb.append(String.format(Locale.ROOT, "%.3gms", ms).replaceAll("\\.?0+ms$", "ms"));
                }
            } else if (nanos >= NANOS_PER_MICRO) {
                double us = nanos / (double) NANOS_PER_MICRO;
                if (us == (long) us) {
                    sb.append((long) us).append("µs");
                } else {
                    sb.append(String.format(Locale.ROOT, "%.3gµs", us).replaceAll("\\.?0+µs$", "µs"));
                }
            } else {
                sb.append(nanos).append("ns");
            }
            return sb.toString();
        }

        double seconds = nanos / (double) NANOS_PER_SECOND;
        if (seconds > 0 || sb.isEmpty()) {
            if (seconds == (long) seconds) {
                sb.append((long) seconds).append("s");
            } else {
                String formatted = String.format(Locale.ROOT, "%.9f", seconds).replaceAll("0+$", "").replaceAll("\\.$", "");
                sb.append(formatted).append("s");
            }
        }

        return sb.toString();
    }
}
