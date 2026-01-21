# Tracking Charmbracelet Regressions

Analysis performed on 2026-01-21.

## Summary
This document tracks uncommitted files that correct a lack of 1:1 parity with the upstream Go repository.
- **New Regressions:** Issues introduced in the current branch (file didn't exist in `main` or was broken by branch changes).
- **Old Regressions:** Issues that already existed in `origin/main` (file existed but had parity issues, or file was missing).

## 1. New Regressions (Issues introduced in this branch)
These files correct parity issues that were introduced in the current branch (e.g., new files added in the wrong place, or files modified in a way that broke parity).

[ ] task: Ensure 1:1 with tea.Cmd src/main/java/com/williamcallahan/tui4j/compat/bubbletea/Command.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/Command.java
[ ] task: Ensure 1:1 with tea.Program src/main/java/com/williamcallahan/tui4j/compat/bubbletea/Program.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/Program.java
[x] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbles/cursor/Cursor.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbles/cursor/Cursor.java
[x] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbles/filepicker/FilePicker.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbles/filepicker/FilePicker.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbles/filepicker/Styles.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbles/filepicker/Styles.java
[x] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbles/key/Binding.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbles/key/Binding.java
[x] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbles/paginator/Paginator.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbles/paginator/Paginator.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbles/progress/Progress.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbles/progress/Progress.java
[x] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbles/table/Table.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbles/table/Table.java
[x] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbles/textarea/Textarea.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbles/textarea/Textarea.java
[x] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbles/viewport/Viewport.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbles/viewport/Viewport.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/harmonica/Spring.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/harmonica/Spring.java
[x] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/lipgloss/Style.java -> src/main/java/com/williamcallahan/tui4j/compat/lipgloss/Style.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/lipgloss/Whitespace.java -> src/main/java/com/williamcallahan/tui4j/compat/lipgloss/Whitespace.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/lipgloss/Border.java -> src/main/java/com/williamcallahan/tui4j/compat/lipgloss/Border.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/render/StandardRenderer.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/render/StandardRenderer.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/x/ansi/Strip.java -> src/main/java/com/williamcallahan/tui4j/compat/x/ansi/Strip.java
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbletea/ProgramTest.java -> src/test/java/com/williamcallahan/tui4j/compat/bubbletea/ProgramTest.java
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbles/filepicker/FilePickerTest.java -> src/test/java/com/williamcallahan/tui4j/compat/bubbles/filepicker/FilePickerTest.java
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbles/progress/ProgressTest.java -> src/test/java/com/williamcallahan/tui4j/compat/bubbles/progress/ProgressTest.java
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbles/textarea/TextareaTest.java -> src/test/java/com/williamcallahan/tui4j/compat/bubbles/textarea/TextareaTest.java
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbles/viewport/ViewportTest.java -> src/test/java/com/williamcallahan/tui4j/compat/bubbles/viewport/ViewportTest.java
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/lipgloss/StyleTest.java -> src/test/java/com/williamcallahan/tui4j/compat/lipgloss/StyleTest.java
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbletea/message/ExecCompletedMessageTest.java -> src/test/java/com/williamcallahan/tui4j/compat/bubbletea/message/ExecCompletedMessageTest.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/ExecCompletedMessage.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/ExecCompletedMessage.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/ExecProcessMessage.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/ExecProcessMessage.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/ResumeMessage.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/ResumeMessage.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/SuspendMessage.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/SuspendMessage.java

## 2. Old Regressions: Files Created in the Last 45 Days
These files existed in `origin/main` (or the issue did) and were created recently (after Dec 6, 2025).

*Note: Timestamps are approximate based on git history.*

[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/timer/TimerTest.java -> src/test/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/timer/TimerTest.java (Created Dec 2025)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/BatchMessage.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/BatchMessage.java (Moved from `.../message/BatchMessage.java` created Dec 2025)
[ ] task: Remove (superseded by BlurMsg) src/main/java/com/williamcallahan/tui4j/compat/bubbletea/BlurMessage.java -> DELETE (Moved from `.../message/BlurMessage.java` created Dec 2025)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/ClearScreenMessage.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/ClearScreenMessage.java (Moved from `.../message/ClearScreenMessage.java` created Dec 2025)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/DisableMouseMessage.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/DisableMouseMessage.java (Moved from `.../message/DisableMouseMessage.java` created Dec 2025)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/EnableMouseAllMotionMessage.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/EnableMouseAllMotionMessage.java (Moved from `.../message/EnableMouseAllMotionMessage.java` created Dec 2025)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/EnableMouseCellMotionMessage.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/EnableMouseCellMotionMessage.java (Moved from `.../message/EnableMouseCellMotionMessage.java` created Dec 2025)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/EnterAltScreen.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/EnterAltScreen.java (Moved from `.../message/EnterAltScreen.java` created Dec 2025)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/ExitAltScreen.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/ExitAltScreen.java (Moved from `.../message/ExitAltScreen.java` created Dec 2025)
[ ] task: Remove (superseded by FocusMsg) src/main/java/com/williamcallahan/tui4j/compat/bubbletea/FocusMessage.java -> DELETE (Moved from `.../message/FocusMessage.java` created Dec 2025)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/PrintLineMessage.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/PrintLineMessage.java (Moved from `.../message/PrintLineMessage.java` created Dec 2025)
[ ] task: Remove (superseded by QuitMsg) src/main/java/com/williamcallahan/tui4j/compat/bubbletea/QuitMessage.java -> DELETE (Moved from `.../message/QuitMessage.java` created Dec 2025)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/SequenceMessage.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/SequenceMessage.java (Moved from `.../message/SequenceMessage.java` created Dec 2025)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/SetWindowTitleMessage.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/SetWindowTitleMessage.java (Moved from `.../message/SetWindowTitleMessage.java` created Dec 2025)
[ ] task: Remove (superseded by WindowSizeMsg) src/main/java/com/williamcallahan/tui4j/compat/bubbletea/WindowSizeMessage.java -> DELETE (Moved from `.../message/WindowSizeMessage.java` created Dec 2025)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/RGBSupplier.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/RGBSupplier.java (Moved from `.../color/RGBSupplier.java` created Dec 2025)

## 3. Old Regressions: Files Created > 45 Days Ago
These files existed in `origin/main` (or were missing entirely) and the underlying issue is older than 45 days.

**Modified Files (Older than Dec 6, 2025):**
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/help/Styles.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/help/Styles.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/list/DefaultItemStyles.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/list/DefaultItemStyles.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/list/List.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/list/List.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/list/Styles.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/list/Styles.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/textinput/TextInput.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/textinput/TextInput.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/input/NewInputHandler.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/input/NewInputHandler.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/input/OldLaggyInputHandler.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/input/OldLaggyInputHandler.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/Renderer.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/Renderer.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/term/Output.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/term/Output.java
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/help/HelpTest.java -> src/test/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/help/HelpTest.java
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/key/BindingTest.java -> src/test/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/key/BindingTest.java
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/textinput/TextInputTest.java -> src/test/java/com/williamcallahan/tui4j/compat/bubbletea/bubbles/textinput/TextInputTest.java
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/RendererTest.java -> src/test/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/RendererTest.java
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/list/ListTest.java -> src/test/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/list/ListTest.java
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/tree/TreeTest.java -> src/test/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/tree/TreeTest.java

**Moved/Renamed Files (Original file older than Dec 6, 2025):**
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/ExtendedSequences.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/ExtendedSequences.java (Moved from `.../input/key/ExtendedSequences.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/Key.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/Key.java (Moved from `.../input/key/Key.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/KeyAliases.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/KeyAliases.java (Moved from `.../input/key/KeyAliases.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/KeyNames.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/KeyNames.java (Moved from `.../input/key/KeyNames.java`)
[ ] task: Remove (superseded by KeyMsg) src/main/java/com/williamcallahan/tui4j/compat/bubbletea/KeyPressMessage.java -> DELETE (Moved from `.../message/KeyPressMessage.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/KeyType.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/KeyType.java (Moved from `.../input/key/KeyType.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/Sequences.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/Sequences.java (Moved from `.../input/key/Sequences.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/ANSI256Color.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/ANSI256Color.java (Moved from `.../color/ANSI256Color.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/ANSIColor.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/ANSIColor.java (Moved from `.../color/ANSIColor.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/ANSIColors.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/ANSIColors.java (Moved from `.../color/ANSIColors.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/AdaptiveColor.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/AdaptiveColor.java (Moved from `.../color/AdaptiveColor.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/Color.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/Color.java (Moved from `.../color/Color.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/ColorApplyStrategy.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/ColorApplyStrategy.java (Moved from `.../color/ColorApplyStrategy.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/ColorProfile.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/ColorProfile.java (Moved from `.../color/ColorProfile.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/HSL.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/HSL.java (Moved from `.../color/HSL.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/NoColor.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/NoColor.java (Moved from `.../color/NoColor.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/RGB.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/RGB.java (Moved from `.../color/RGB.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/RGBColor.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/RGBColor.java (Moved from `.../color/RGBColor.java`)
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/TerminalColor.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/TerminalColor.java (Moved from `.../color/TerminalColor.java`)
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/HSLTest.java -> src/test/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/HSLTest.java (Moved from `.../color/HSLTest.java`)
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/RGBTest.java -> src/test/java/com/williamcallahan/tui4j/compat/bubbletea/lipgloss/RGBTest.java (Moved from `.../color/RGBTest.java`)

**Missing Functionality (New files for missing upstream concepts):**
[ ] task: Verify 1:1 with tea.BlurMsg src/main/java/com/williamcallahan/tui4j/compat/bubbletea/BlurMsg.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/BlurMsg.java
[ ] task: Verify 1:1 with tea.FocusMsg src/main/java/com/williamcallahan/tui4j/compat/bubbletea/FocusMsg.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/FocusMsg.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/InputHandler.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/InputHandler.java
[ ] task: Verify 1:1 with tea.KeyMsg src/main/java/com/williamcallahan/tui4j/compat/bubbletea/KeyMsg.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/KeyMsg.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/MouseAction.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/MouseAction.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/MouseButton.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/MouseButton.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/MouseMsg.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/MouseMsg.java
[ ] task: Verify 1:1 with tea.QuitMsg src/main/java/com/williamcallahan/tui4j/compat/bubbletea/QuitMsg.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/QuitMsg.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/UnknownInputByteMessage.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/UnknownInputByteMessage.java
[ ] task: Verify 1:1 with tea.WindowSizeMsg src/main/java/com/williamcallahan/tui4j/compat/bubbletea/WindowSizeMsg.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/WindowSizeMsg.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/harmonica/Point.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/harmonica/Point.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/harmonica/Projectile.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/harmonica/Projectile.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/harmonica/Vector.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/harmonica/Vector.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/bubbletea/harmonica/package-info.java -> src/main/java/com/williamcallahan/tui4j/compat/bubbletea/harmonica/package-info.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/x/ansi/Mode.java -> src/main/java/com/williamcallahan/tui4j/compat/x/ansi/Mode.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/x/ansi/Paste.java -> src/main/java/com/williamcallahan/tui4j/compat/x/ansi/Paste.java
[ ] task: Verify parity with upstream src/main/java/com/williamcallahan/tui4j/compat/x/ansi/Width.java -> src/main/java/com/williamcallahan/tui4j/compat/x/ansi/Width.java
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/bubbletea/input/ -> src/test/java/com/williamcallahan/tui4j/compat/bubbletea/input/
[ ] task: Verify parity with upstream src/test/java/com/williamcallahan/tui4j/compat/x/ansi/StripTest.java -> src/test/java/com/williamcallahan/tui4j/compat/x/ansi/StripTest.java
