# Bubble Tea Compatibility Map

- **Source Repo**: [charmbracelet/bubbletea](https://github.com/charmbracelet/bubbletea)
- **Copyright**: Copyright (c) 2020-2025 Charmbracelet, Inc
- **Java Package**: `com.williamcallahan.tui4j.compat.bubbletea`

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

### Root

- [ ] **commands.go**
  - `Command.java`
  - `BatchMessage.java`
  - ~~`BatchMsg.java`~~ @deprecated
  - `SequenceMessage.java`
  - ~~`SequenceMsg.java`~~ @deprecated
  - `SetWindowTitleMessage.java`
  - ~~`SetWindowTitleMsg.java`~~ @deprecated
  - `OpenUrlMessage.java`
  - ~~`OpenUrlMsg.java`~~ @deprecated
  - `CopyToClipboardMessage.java`
  - ~~`CopyToClipboardMsg.java`~~ @deprecated
  - `ReadClipboardMessage.java`
  - ~~`ReadClipboardMsg.java`~~ @deprecated

- [ ] **commands_test.go** → `<unmapped>`

- [ ] **exec.go**
  - `ExecProcessMessage.java`
  - ~~`ExecProcessMsg.java`~~ @deprecated
  - `ExecCompletedMessage.java`
  - ~~`ExecCompletedMsg.java`~~ @deprecated

- [ ] **exec_test.go** → `<unmapped>`

- [ ] **focus.go**
  - `FocusMessage.java`
  - ~~`FocusMsg.java`~~ @deprecated
  - `BlurMessage.java`
  - ~~`BlurMsg.java`~~ @deprecated

- [ ] **inputreader_other.go**
  - `input/InputHandler.java`
  - `input/NewInputHandler.java`
  - `input/OldLaggyInputHandler.java`
  - `input/NoopInputHandler.java`

- [ ] **inputreader_windows.go** → `<unmapped>`

- [ ] **key.go**
  - `input/key/Key.java`
  - `input/key/KeyType.java`
  - `input/key/KeyNames.java`
  - `input/key/KeyAliases.java`
  - `KeyPressMessage.java`
  - ~~`KeyMsg.java`~~ @deprecated
  - `PasteMessage.java`
  - ~~`PasteMsg.java`~~ @deprecated
  - `UnknownInputByteMessage.java`
  - ~~`UnknownInputByteMsg.java`~~ @deprecated
  - `UnknownSequenceMessage.java`
  - ~~`UnknownSequenceMsg.java`~~ @deprecated

- [ ] **key_other.go** → `<unmapped>`

- [ ] **key_sequences.go**
  - `input/key/Sequences.java`
  - `input/key/ExtendedSequences.java`

- [ ] **key_test.go** → `<unmapped>`

- [ ] **key_windows.go** → `<unmapped>`

- [ ] **logging.go** → `Logging.java`

- [ ] **logging_test.go** → `<unmapped>`

- [ ] **mouse.go**
  - `input/MouseMessage.java`
  - ~~`input/MouseMsg.java`~~ @deprecated
  - `input/MouseButton.java`
  - `input/MouseAction.java`

- [ ] **mouse_test.go** → `<unmapped>`

- [ ] **nil_renderer.go** → `render/NilRenderer.java`

- [ ] **nil_renderer_test.go** → `<unmapped>`

- [ ] **options.go** → `ProgramOption.java`

- [ ] **options_test.go** → `<unmapped>`

- [ ] **renderer.go** → `render/Renderer.java`

- [ ] **screen.go**
  - `WindowSizeMessage.java`
  - ~~`WindowSizeMsg.java`~~ @deprecated
  - `ClearScreenMessage.java`
  - ~~`ClearScreenMsg.java`~~ @deprecated
  - `EnterAltScreenMessage.java`
  - ~~`EnterAltScreenMsg.java`~~ @deprecated
  - `EnterAltScreen.java`
  - `ExitAltScreenMessage.java`
  - ~~`ExitAltScreenMsg.java`~~ @deprecated
  - `ExitAltScreen.java`
  - `EnableMouseCellMotionMessage.java`
  - ~~`EnableMouseCellMotionMsg.java`~~ @deprecated
  - `EnableMouseAllMotionMessage.java`
  - ~~`EnableMouseAllMotionMsg.java`~~ @deprecated
  - `DisableMouseMessage.java`
  - ~~`DisableMouseMsg.java`~~ @deprecated
  - `CheckWindowSizeMessage.java`
  - ~~`CheckWindowSizeMsg.java`~~ @deprecated
  - `ResetMouseCursorMessage.java`
  - ~~`ResetMouseCursorMsg.java`~~ @deprecated
  - `SetMouseCursorPointerMessage.java`
  - ~~`SetMouseCursorPointerMsg.java`~~ @deprecated
  - `SetMouseCursorTextMessage.java`
  - ~~`SetMouseCursorTextMsg.java`~~ @deprecated

- [ ] **screen_test.go** → `<unmapped>`

- [ ] **signals_unix.go** → `Program.java`

- [ ] **signals_windows.go** → `Program.java`

- [ ] **standard_renderer.go**
  - `render/StandardRenderer.java`
  - `PrintLineMessage.java`
  - ~~`PrintLineMsg.java`~~ @deprecated

- [ ] **tea.go**
  - `Program.java`
  - `Model.java`
  - `Message.java`
  - `MessageShim.java`
  - `UpdateResult.java`
  - `QuitMessage.java`
  - ~~`QuitMsg.java`~~ @deprecated
  - `SuspendMessage.java`
  - ~~`SuspendMsg.java`~~ @deprecated
  - `ResumeMessage.java`
  - ~~`ResumeMsg.java`~~ @deprecated
  - `ProgramException.java`
  - `ErrorMessage.java`
  - ~~`ErrorMsg.java`~~ @deprecated

- [ ] **tea_init.go** → `<unmapped>`

- [ ] **tea_test.go** → `<unmapped>`

- [ ] **tty.go** → `Program.java`

- [ ] **tty_unix.go** → `Program.java`

- [ ] **tty_windows.go** → `Program.java`

---

### Tutorials

- [ ] **tutorials/basics/main.go** → `<unmapped>`
- [ ] **tutorials/commands/main.go** → `<unmapped>`

---

### Examples

- [ ] **examples/altscreen-toggle/main.go** → `examples/.../AltScreenToggleExample.java`
- [ ] **examples/autocomplete/main.go** → `examples/.../AutocompleteExample.java`
- [ ] **examples/cellbuffer/main.go** → `examples/.../CellExample.java`
- [ ] **examples/chat/main.go** → `examples/.../ChatExample.java`
- [ ] **examples/composable-views/main.go** → `examples/.../ComposableViewsExample.java`
- [ ] **examples/credit-card-form/main.go** → `examples/.../CreditCardFormExample.java`
- [ ] **examples/debounce/main.go** → `examples/.../DebounceExample.java`
- [ ] **examples/exec/main.go** → `examples/.../ExecExample.java`
- [ ] **examples/eyes/main.go** → `<unmapped>`
- [ ] **examples/file-picker/main.go** → `examples/.../FilePickerExample.java`
- [ ] **examples/focus-blur/main.go** → `examples/.../FocusBlurExample.java`
- [ ] **examples/fullscreen/main.go** → `examples/.../FullscreenExample.java`
- [ ] **examples/glamour/main.go** → `<unmapped>`
- [ ] **examples/help/main.go** → `examples/.../HelpExample.java`
- [ ] **examples/http/main.go** → `examples/.../HttpExample.java`
- [ ] **examples/list-default/main.go** → `examples/.../ListDefaultExample.java`
- [ ] **examples/list-fancy/delegate.go** → `examples/.../Delegate.java`
- [ ] **examples/list-fancy/main.go** → `examples/.../ListFancyExample.java`
- [ ] **examples/list-fancy/randomitems.go** → `examples/.../RandomItemGenerator.java`
- [ ] **examples/list-simple/main.go** → `examples/.../ListSimpleExample.java`
- [ ] **examples/mouse/main.go** → `examples/.../MouseExample.java`
- [ ] **examples/package-manager/main.go** → `examples/.../PackageManagerExample.java`
- [ ] **examples/package-manager/packages.go** → `examples/.../PackageManagerExample.java`
- [ ] **examples/pager/main.go** → `examples/.../PagerExample.java`
- [ ] **examples/paginator/main.go** → `examples/.../PaginatorExample.java`
- [ ] **examples/pipe/main.go** → `examples/.../PipeExample.java`
- [ ] **examples/prevent-quit/main.go** → `examples/.../PreventQuitExample.java`
- [ ] **examples/progress-animated/main.go** → `examples/.../ProgressAnimatedExample.java`
- [ ] **examples/progress-download/main.go** → `examples/.../ProgressDownloadExample.java`
- [ ] **examples/progress-download/tui.go** → `examples/.../ProgressDownloadExample.java`
- [ ] **examples/progress-static/main.go** → `examples/.../ProgressStaticExample.java`
- [ ] **examples/realtime/main.go** → `examples/.../RealtimeExample.java`
- [ ] **examples/result/main.go** → `<unmapped>`
- [ ] **examples/send-msg/main.go** → `examples/.../SendMsgExample.java`
- [ ] **examples/sequence/main.go** → `examples/.../SequenceExample.java`
- [ ] **examples/set-window-title/main.go** → `examples/.../SetWindowTitleExample.java`
- [ ] **examples/simple/main.go** → `examples/.../SimpleExample.java`
- [ ] **examples/simple/main_test.go** → `<unmapped>`
- [ ] **examples/spinner/main.go** → `examples/.../SpinnerExample.java`
- [ ] **examples/spinners/main.go** → `examples/.../SpinnersExample.java`
- [ ] **examples/split-editors/main.go** → `examples/.../SplitEditorsExample.java`
- [ ] **examples/stopwatch/main.go** → `examples/.../StopwatchExample.java`
- [ ] **examples/suspend/main.go** → `examples/.../SuspendExample.java`
- [ ] **examples/table-resize/main.go** → `examples/.../TableResizeExample.java`
- [ ] **examples/table/main.go** → `examples/.../TableExample.java`
- [ ] **examples/tabs/main.go** → `examples/.../TabsExample.java`
- [ ] **examples/textarea/main.go** → `examples/.../TextareaExample.java`
- [ ] **examples/textinput/main.go** → `examples/.../TextInputExample.java`
- [ ] **examples/textinputs/main.go** → `examples/.../TextInputsExample.java`
- [ ] **examples/timer/main.go** → `examples/.../TimerExample.java`
- [ ] **examples/tui-daemon-combo/main.go** → `examples/.../DaemonComboExample.java`
- [ ] **examples/views/main.go** → `examples/.../ViewsExample.java`
- [ ] **examples/window-size/main.go** → `examples/.../WindowSizeExample.java`
