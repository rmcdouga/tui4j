package com.williamcallahan.tui4j.compat.bubbletea.message;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExecCompletedMessageTest {

    @Test
    void testSuccessRequiresZeroExitCodeAndNoError() {
        com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage success =
            new com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage(0, null);
        com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage nonZeroExit =
            new com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage(1, null);
        com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage error =
            new com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage(0, new IllegalStateException("boom"));

        assertThat(success.success()).isTrue();
        assertThat(nonZeroExit.success()).isFalse();
        assertThat(error.success()).isFalse();
    }

    @Test
    void testErrorMessagePrefersThrowable() {
        com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage withError =
            new com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage(0, new IllegalStateException("boom"));
        com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage withExitCode =
            new com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage(2, null);
        com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage ok =
            new com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMessage(0, null);

        assertThat(withError.errorMessage()).isEqualTo("boom");
        assertThat(withExitCode.errorMessage()).isEqualTo("Process exited with code 2");
        assertThat(ok.errorMessage()).isNull();
    }
}
