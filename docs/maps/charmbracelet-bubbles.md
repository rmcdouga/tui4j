# Bubbles Compatibility Map

- **Source Repo**: [https://github.com/charmbracelet/bubbles](https://github.com/charmbracelet/bubbles)
- **Copyright**: Copyright (c) 2020-2025 Charmbracelet, Inc
- **Canonical Map Path**: `src/main/java/com/williamcallahan/tui4j/compat/bubbles`
- **Examples Source Set (Gradle)**: `examplesBubbles` (currently empty)
- **Where to find runnable component demos**: Bubble Tea examples are compiled under `examplesBubbletea` (many examples use Bubbles components).

## Message Naming Policy (tui4j)
- Use `*Message` names in docs and examples.
- Legacy aliases exist for upstream naming; prefer `*Message` in user code.

### Message Mapping (Bubbles → tui4j, `*Message` only)
- `cursor/initialBlinkMsg` → `Cursor.InitialBlinkMessage`
- `cursor/BlinkMsg` → `Cursor.BlinkMessage`
- `cursor/blinkCanceled` → `Cursor.BlinkCanceled`
- `progress/FrameMsg` → `FrameMessage`
- `progress/setPercentMsg` → `SetPercentMessage`
- `spinner/TickMsg` → `TickMessage`
- `stopwatch/StartStopMsg` → `StartStopMessage`
- `stopwatch/TickMsg` → `TickMessage`
- `stopwatch/ResetMsg` → `ResetMessage`
- `timer/StartStopMsg` → `StartStopMessage`
- `timer/TickMsg` → `TickMessage`
- `timer/TimeoutMsg` → `TimeoutMessage`
- `list/statusMessageTimeoutMsg` → `StatusMessageTimeoutMessage`
- `list/FilterMatchesMsg` → `<unmapped>`
- `filepicker/errorMsg` → `<unmapped>`
- `filepicker/readDirMsg` → `<unmapped>`

## Source Files Mapping
- [ ] <bubbles.go> -> <unmapped>
- [ ] <cursor/cursor.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/cursor/Cursor.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/cursor/CursorMode.java>
- [ ] <cursor/cursor_test.go> -> <unmapped>
- [ ] <filepicker/filepicker.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/filepicker/FilePicker.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/filepicker/KeyMap.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/filepicker/Styles.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/filepicker/DidSelectFileMsg.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/filepicker/DidSelectFileMessage.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/filepicker/DidSelectDirectoryMsg.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/filepicker/DidSelectDirectoryMessage.java>
- [ ] <filepicker/hidden_unix.go> -> <unmapped>
- [ ] <filepicker/hidden_windows.go> -> <unmapped>
- [ ] <help/help.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/help/Help.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/help/KeyMap.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/help/Styles.java>
- [ ] <help/help_test.go> -> <src/test/java/com/williamcallahan/tui4j/compat/bubbles/help/HelpTest.java>
- [ ] <key/key.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/key/Binding.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/key/Help.java>
- [ ] <key/key_test.go> -> <src/test/java/com/williamcallahan/tui4j/compat/bubbles/key/BindingTest.java>
- [ ] <list/defaultitem.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/DefaultItem.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/DefaultItemStyles.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/DefaultDelegate.java>
- [ ] <list/keys.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/KeyMap.java>
- [ ] <list/list.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/List.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/Item.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/ItemDelegate.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/FilterState.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/FilterFunction.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/FilteredItem.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/FetchedItems.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/FetchedCurrentPageItems.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/ListDataSource.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/DefaultDataSource.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/Rank.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/StatusMessageTimeoutMessage.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/fuzzy/FuzzyFilter.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/fuzzy/Match.java>
- [ ] <list/list_test.go> -> <unmapped>
- [ ] <list/style.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/Styles.java>
- [ ] <paginator/paginator.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/paginator/Paginator.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/paginator/KeyMap.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/paginator/Bounds.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/paginator/Type.java>
- [ ] <paginator/paginator_test.go> -> <src/test/java/com/williamcallahan/tui4j/compat/bubbles/paginator/PaginatorTest.java>
- [ ] <progress/progress.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/progress/Progress.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/progress/FrameMessage.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/progress/FrameMsg.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/progress/SetPercentMessage.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/progress/SetPercentMsg.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/progress/Spring.java>
- [ ] <progress/progress_test.go> -> <src/test/java/com/williamcallahan/tui4j/compat/bubbles/progress/ProgressTest.java>
- [ ] <runeutil/runeutil.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/runeutil/Sanitizer.java>
- [ ] <runeutil/runeutil_test.go> -> <src/test/java/com/williamcallahan/tui4j/compat/bubbles/runeutil/SanitizerTest.java>
- [ ] <spinner/spinner.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/spinner/Spinner.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/spinner/SpinnerType.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/spinner/TickMessage.java>
- [ ] <spinner/spinner_test.go> -> <unmapped>
- [ ] <stopwatch/stopwatch.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/stopwatch/Stopwatch.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/stopwatch/StartStopMessage.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/stopwatch/StartStopMsg.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/stopwatch/TickMessage.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/stopwatch/TickMsg.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/stopwatch/ResetMessage.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/stopwatch/ResetMsg.java>
- [ ] <table/table.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/table/Table.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/table/Column.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/table/Row.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/table/Keys.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/table/Styles.java>
- [ ] <table/table_test.go> -> <unmapped>
- [ ] <textarea/memoization/memoization.go> -> <unmapped>
- [ ] <textarea/memoization/memoization_test.go> -> <unmapped>
- [ ] <textarea/textarea.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/textarea/Textarea.java>
- [ ] <textarea/textarea_test.go> -> <src/test/java/com/williamcallahan/tui4j/compat/bubbles/textarea/TextareaTest.java>
- [ ] <textinput/textinput.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/textinput/TextInput.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/textinput/EchoMode.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/textinput/Keys.java>
- [ ] <textinput/textinput_test.go> -> <src/test/java/com/williamcallahan/tui4j/compat/bubbles/textinput/TextInputTest.java>
- [ ] <timer/timer.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/timer/Timer.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/timer/StartStopMessage.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/timer/TickMessage.java; src/main/java/com/williamcallahan/tui4j/compat/bubbles/timer/TimeoutMessage.java>
- [ ] <viewport/keymap.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/viewport/KeyMap.java>
- [ ] <viewport/viewport.go> -> <src/main/java/com/williamcallahan/tui4j/compat/bubbles/viewport/Viewport.java>
- [ ] <viewport/viewport_test.go> -> <src/test/java/com/williamcallahan/tui4j/compat/bubbles/viewport/ViewportTest.java>
