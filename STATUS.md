# Porting Status

This page covers the current status of porting the [charmbracelet](https://github.com/charmbracelet) ecosystem to TUI4J.

## Upstream Repositories

TUI4J ports from these charmbracelet repositories:

| Repository | Description | Java Package |
|------------|-------------|--------------|
| [bubbletea](https://github.com/charmbracelet/bubbletea) | Core TUI framework | `com.williamcallahan.tui4j.compat.bubbletea.*` |
| [bubbles](https://github.com/charmbracelet/bubbles) | Reusable UI components | `com.williamcallahan.tui4j.compat.bubbles.*` |
| [lipgloss](https://github.com/charmbracelet/lipgloss) | Styling and layout | `com.williamcallahan.tui4j.compat.lipgloss.*` |
| [x](https://github.com/charmbracelet/x) | Experimental packages | `com.williamcallahan.tui4j.compat.x.*` |
| [harmonica](https://github.com/charmbracelet/harmonica) | Spring physics animation | `com.williamcallahan.tui4j.compat.harmonica.*` |

## Examples

Table presents an overall status of porting code available under **examples** directory of Bubble Tea codebase. The idea
is to rewrite all the code samples and enhance TUI4J logic with missing parts found during implementation.

Each entry below represents a single example code fragment and the status of its migration into Java equivalent which is
represented by one of the labels:

`⚪ TODO` No effort have been put into this one yet

`🟡 In Progress` It's currently under development, and it might be some notable changes will be applied to TUI4J logic to
conform it

`🟢 Done` It's done like DONE, the example works 100% the same as original code does.

`🔴 Won't do` It won't be done because of some technical limitations or was done some other way with explanation in **Notes**.

| Example           | Status        | Notes                                                              |
|-------------------|---------------|--------------------------------------------------------------------|
| altscreen-toggle  | `🟢 Done`     |                                                                    |
| autocomplete      | `🟢 Done`     | Uses **help**, **key** and **textinput** bubbles.                  |
| cellbuffer        | `🟢 Done`     | Uses **harmonica** spring physics.                                 |
| chat              | `🟢 Done`     | Uses **textarea** and **viewport** bubbles.                        |
| composable-views  | `🟢 Done`     | Uses **timer** bubble.                                             |
| credit-card-form  | `🟢 Done`     | Uses **textinput** with validation.                                |
| debounce          | `🟢 Done`     | Demonstrates rate limiting pattern.                                |
| exec              | `🟢 Done`     | Uses terminal suspend/resume for external commands.                |
| file-picker       | `🟢 Done`     | Uses **filepicker** bubble.                                        |
| focus-blur        | `🟢 Done`     |                                                                    |
| fullscreen        | `🟢 Done`     |                                                                    |
| glamour           | `⚪ TODO`     | Needs any reasonable port of **glamour**.                          |
| help              | `🟢 Done`     | Uses **help** and **key** bubbles.                                 |
| http              | `🟢 Done`     |                                                                    |
| list-default      | `🟢 Done`     |                                                                    |
| list-fancy        | `🟢 Done`     |                                                                    |
| list-simple       | `🟢 Done`     |                                                                    |
| mouse             | `🟢 Done`     |                                                                    |
| package-manager   | `🟢 Done`     | Uses **progress** bubble.                                          |
| pager             | `🟢 Done`     | Uses **viewport** bubble.                                          |
| paginator         | `🟢 Done`     |                                                                    |
| pipe              | `🟢 Done`     | Demonstrates piped input handling.                                 |
| prevent-quit      | `🟢 Done`     | Uses **help**, **key** and **textarea** bubbles.                   |
| progress-animated | `🟢 Done`     | Uses **progress** bubble with tick-based animation.                |
| progress-download | `🟢 Done`     | Uses **progress** bubble.                                          |
| progress-static   | `🟢 Done`     | Uses **progress** bubble.                                          |
| realtime          | `🟢 Done`     | Uses background thread and Program.send() for message injection.   |
| result            | `🔴 Won't do` | Rewritten as **demo** example.                                     |
| send-msg          | `🟢 Done`     | Demonstrates Program.send() for external message injection.        |
| sequence          | `🟢 Done`     | Nested sequences and batches not yet supported, needs revisiting.  |
| set-window-title  | `🟢 Done`     |                                                                    |
| simple            | `🟢 Done`     | Basic counter example.                                             |
| spinner           | `🟢 Done`     |                                                                    |
| spinners          | `🟢 Done`     | Multiple spinner styles demo.                                      |
| split-editors     | `🟢 Done`     | Uses **textarea** bubble.                                          |
| stopwatch         | `🟢 Done`     | Uses **help**, **key** and **stopwatch** bubbles.                  |
| suspend           | `🟢 Done`     | Uses JLine pause/resume for terminal state management.             |
| table             | `🟢 Done`     | Uses **table** bubble.                                             |
| table-resize      | `🟢 Done`     | Uses **table** bubble with dynamic sizing.                         |
| tabs              | `🟢 Done`     | Tab navigation with lipgloss styling.                              |
| textarea          | `⚪ TODO`     | Standalone textarea demo (bubble exists, example not ported).      |
| textinput         | `🟢 Done`     |                                                                    |
| textinputs        | `🟢 Done`     |                                                                    |
| timer             | `🟢 Done`     | Uses **timer** bubble.                                             |
| tui-daemon-combo  | `🟢 Done`     | CLI mode switching demo.                                           |
| views             | `🟢 Done`     | Multi-view navigation demo.                                        |
| window-size       | `🟢 Done`     |                                                                    |

## Bubbles

This table covers all the Bubble's ported so far. The same status labels apply.

| Bubble     | Status    | Notes                                                     |
|------------|-----------|-----------------------------------------------------------|
| cursor     | `🟢 Done` |                                                           |
| filepicker | `🟢 Done` | Directory browser with filtering and symlink support.     |
| help       | `🟢 Done` |                                                           |
| key        | `🟢 Done` |                                                           |
| list       | `🟢 Done` |                                                           |
| paginator  | `🟢 Done` |                                                           |
| progress   | `🟢 Done` | Spring animation, gradient colors, percentage display.    |
| runeutil   | `🟢 Done` |                                                           |
| spinner    | `🟢 Done` |                                                           |
| stopwatch  | `🟢 Done` | Go-style duration formatting, Elm Architecture compliant. |
| table      | `🟢 Done` | Columns, rows, keyboard navigation.                       |
| textarea   | `🟢 Done` | Multi-line editor with cursor movement and word ops.      |
| textinput  | `🟢 Done` |                                                           |
| timer      | `🟢 Done` | Countdown timer with start/stop/reset.                    |
| viewport   | `🟢 Done` | Scrollable content with keyboard nav and line wrapping.   |

## Lipgloss

This table represents porting status of each part of Lipgloss that can be anyway measured.

| What                         | Status    | Notes                                                     |
|------------------------------|-----------|-----------------------------------------------------------|
| Colors and color profiles    | `🟢 Done` | ANSI, ANSI256, RGB, HSL, adaptive colors.                 |
| Borders                      | `🟢 Done` | Normal, rounded, thick, double, hidden, etc.              |
| Margins and paddings         | `🟢 Done` |                                                           |
| Width and wrapping           | `🟢 Done` | Uses x/ansi for proper grapheme width calculation.        |
| Alignment                    | `🟢 Done` |                                                           |
| Max width and max height     | `🟢 Done` | Text truncation with ellipsis support.                    |
| Horizontal and vertical join | `🟢 Done` |                                                           |
| Whitespace                   | `🟢 Done` | Background fill with pattern support.                     |
| List component               | `🟢 Done` |                                                           |
| Tree component               | `🟢 Done` |                                                           |
| Table component              | `🟢 Done` |                                                           |

## x (Experimental Packages)

The charmbracelet/x repository contains experimental packages. TUI4J ports selected components.

### x/ansi (Ported)

| What                         | Status    | Notes                                                     |
|------------------------------|-----------|-----------------------------------------------------------|
| StringWidth                  | `🟢 Done` | Grapheme-aware string width using ICU4J.                  |
| Truncate                     | `🟢 Done` | ANSI-aware truncation with left/right variants.           |
| Cut                          | `🟢 Done` | Extracts visible portion of ANSI-styled text.             |
| Strip                        | `🟢 Done` | Removes all ANSI escape sequences.                        |
| GraphemeCluster              | `🟢 Done` | Proper Unicode grapheme cluster handling.                 |
| Parser (State machine)       | `🟢 Done` | State, Action, TransitionTable for ANSI parsing.          |
| Wrap                         | `⚪ TODO` | Word wrapping with ANSI awareness.                        |
| Style (SGR)                  | `⚪ TODO` | SGR (Select Graphic Rendition) utilities.                 |
| Hyperlink                    | `⚪ TODO` | OSC 8 hyperlink support.                                  |
| Cursor                       | `⚪ TODO` | Cursor movement sequences.                                |
| Mouse                        | `⚪ TODO` | Mouse input parsing and sequences.                        |
| Clipboard                    | `⚪ TODO` | OSC 52 clipboard access.                                  |
| Notification                 | `⚪ TODO` | Terminal notifications.                                   |
| Graphics (Sixel)             | `⚪ TODO` | Sixel graphics support.                                   |
| Kitty extensions             | `⚪ TODO` | Kitty terminal protocol extensions.                       |
| iTerm2 extensions            | `⚪ TODO` | iTerm2 protocol extensions.                               |

### x/cellbuf (Not Ported)

| What                         | Status    | Notes                                                     |
|------------------------------|-----------|-----------------------------------------------------------|
| Buffer                       | `⚪ TODO` | Cell buffer for efficient terminal rendering.             |
| Screen                       | `⚪ TODO` | Screen abstraction over cell buffer.                      |
| Writer                       | `⚪ TODO` | Buffered writer with diff-based updates.                  |

### x/colors (Not Ported)

| What                         | Status    | Notes                                                     |
|------------------------------|-----------|-----------------------------------------------------------|
| Colors                       | `⚪ TODO` | Color conversion and manipulation utilities.              |

### x/editor (Not Ported)

| What                         | Status    | Notes                                                     |
|------------------------------|-----------|-----------------------------------------------------------|
| Editor                       | `⚪ TODO` | Launch external text editor.                              |

## Harmonica

This table represents porting status of charmbracelet/harmonica spring physics.

| What                         | Status    | Notes                                                     |
|------------------------------|-----------|-----------------------------------------------------------|
| Spring                       | `🟢 Done` | Spring-based physics animation for smooth UI transitions. |
