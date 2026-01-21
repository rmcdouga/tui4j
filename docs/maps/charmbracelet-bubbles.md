# Bubbles Compatibility Map

- **Source Repo**: [charmbracelet/bubbles](https://github.com/charmbracelet/bubbles)
- **Copyright**: Copyright (c) 2020-2025 Charmbracelet, Inc
- **Java Package**: `com.williamcallahan.tui4j.compat.bubbles`

---

## Naming Convention

**As of v0.3.0**, tui4j standardizes on idiomatic Java naming:

| Preferred (use these) | Deprecated (avoid) |
|-----------------------|-------------------|
| `*Message.java` | ~~`*Msg.java`~~ |

The `*Msg` suffix classes are deprecated and will be removed in a future release.
Use the corresponding `*Message` classes instead.

---

## Source File Mappings

- [ ] **bubbles.go** → `<unmapped>`

- [ ] **cursor/cursor.go**
  - `cursor/Cursor.java`
  - `cursor/CursorMode.java`

- [ ] **cursor/cursor_test.go** → `<unmapped>`

- [ ] **filepicker/filepicker.go**
  - `filepicker/FilePicker.java`
  - `filepicker/KeyMap.java`
  - `filepicker/Styles.java`
  - `filepicker/DidSelectFileMessage.java`
  - ~~`filepicker/DidSelectFileMsg.java`~~ @deprecated
  - `filepicker/DidSelectDirectoryMessage.java`
  - ~~`filepicker/DidSelectDirectoryMsg.java`~~ @deprecated

- [ ] **filepicker/hidden_unix.go** → `<unmapped>`

- [ ] **filepicker/hidden_windows.go** → `<unmapped>`

- [ ] **help/help.go**
  - `help/Help.java`
  - `help/KeyMap.java`
  - `help/Styles.java`

- [ ] **help/help_test.go** → `help/HelpTest.java`

- [ ] **key/key.go**
  - `key/Binding.java`
  - `key/Help.java`

- [ ] **key/key_test.go** → `key/BindingTest.java`

- [ ] **list/defaultitem.go**
  - `list/DefaultItem.java`
  - `list/DefaultItemStyles.java`
  - `list/DefaultDelegate.java`

- [ ] **list/keys.go** → `list/KeyMap.java`

- [ ] **list/list.go**
  - `list/List.java`
  - `list/Item.java`
  - `list/ItemDelegate.java`
  - `list/FilterState.java`
  - `list/FilterFunction.java`
  - `list/FilteredItem.java`
  - `list/FetchedItems.java`
  - `list/FetchedCurrentPageItems.java`
  - `list/ListDataSource.java`
  - `list/DefaultDataSource.java`
  - `list/Rank.java`
  - `list/StatusMessageTimeoutMessage.java`
  - `list/fuzzy/FuzzyFilter.java`
  - `list/fuzzy/Match.java`

- [ ] **list/list_test.go** → `<unmapped>`

- [ ] **list/style.go** → `list/Styles.java`

- [ ] **paginator/paginator.go**
  - `paginator/Paginator.java`
  - `paginator/KeyMap.java`
  - `paginator/Bounds.java`
  - `paginator/Type.java`

- [ ] **paginator/paginator_test.go** → `paginator/PaginatorTest.java`

- [ ] **progress/progress.go**
  - `progress/Progress.java`
  - `progress/FrameMessage.java`
  - ~~`progress/FrameMsg.java`~~ @deprecated
  - `progress/SetPercentMessage.java`
  - ~~`progress/SetPercentMsg.java`~~ @deprecated
  - `progress/Spring.java`

- [ ] **progress/progress_test.go** → `progress/ProgressTest.java`

- [ ] **runeutil/runeutil.go** → `runeutil/Sanitizer.java`

- [ ] **runeutil/runeutil_test.go** → `runeutil/SanitizerTest.java`

- [ ] **spinner/spinner.go**
  - `spinner/Spinner.java`
  - `spinner/SpinnerType.java`
  - `spinner/TickMessage.java`

- [ ] **spinner/spinner_test.go** → `<unmapped>`

- [ ] **stopwatch/stopwatch.go**
  - `stopwatch/Stopwatch.java`
  - `stopwatch/StartStopMessage.java`
  - ~~`stopwatch/StartStopMsg.java`~~ @deprecated
  - `stopwatch/TickMessage.java`
  - ~~`stopwatch/TickMsg.java`~~ @deprecated
  - `stopwatch/ResetMessage.java`
  - ~~`stopwatch/ResetMsg.java`~~ @deprecated

- [ ] **table/table.go**
  - `table/Table.java`
  - `table/Column.java`
  - `table/Row.java`
  - `table/Keys.java`
  - `table/Styles.java`

- [ ] **table/table_test.go** → `<unmapped>`

- [ ] **textarea/memoization/memoization.go** → `<unmapped>`

- [ ] **textarea/memoization/memoization_test.go** → `<unmapped>`

- [ ] **textarea/textarea.go** → `textarea/Textarea.java`

- [ ] **textarea/textarea_test.go** → `textarea/TextareaTest.java`

- [ ] **textinput/textinput.go**
  - `textinput/TextInput.java`
  - `textinput/EchoMode.java`
  - `textinput/Keys.java`

- [ ] **textinput/textinput_test.go** → `textinput/TextInputTest.java`

- [ ] **timer/timer.go**
  - `timer/Timer.java`
  - `timer/StartStopMessage.java`
  - `timer/TickMessage.java`
  - `timer/TimeoutMessage.java`

- [ ] **viewport/keymap.go** → `viewport/KeyMap.java`

- [ ] **viewport/viewport.go** → `viewport/Viewport.java`

- [ ] **viewport/viewport_test.go** → `viewport/ViewportTest.java`
