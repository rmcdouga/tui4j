# Audit: Fix Charmbracelet 1:1 Parity

**Date:** 2026-01-20
**Status:** In Progress
**Objective:** Ensure `tui4j` is a high-fidelity port of `charmbracelet/bubbletea`, `bubbles`, `lipgloss`, and `x`, strictly adhering to `AGENTS.md`. Remove duplicates and fix non-compliant naming/logic.

## 1. Top-Level Structure Verification (COMPLETE)

Ensure the following mapping is strictly enforced (per `AGENTS.md`):

| Charm Repo | Upstream Path | TUI4J Path | Status |
|---|---|---|---|
| `bubbletea` | root (`*.go`) | `com.williamcallahan.tui4j.compat.bubbletea.*` | ✅ |
| `bubbles` | `*` | `com.williamcallahan.tui4j.compat.bubbles.*` | ✅ |
| `lipgloss` | `*` | `com.williamcallahan.tui4j.compat.lipgloss.*` | ✅ |
| `harmonica` | `*` | `com.williamcallahan.tui4j.compat.harmonica.*` | ✅ |
| `x/ansi` | `ansi/*` | `com.williamcallahan.tui4j.compat.x.ansi.*` | ✅ |

## 2. Message Consolidation & Renaming (IN PROGRESS)

Upstream `bubbletea` defines core messages in the root package (or `key`, `mouse`, `window` conceptually). TUI4J has them scattered in `message` package with `*Message` suffix.

**Action:** Move to `compat.bubbletea` (or appropriate sub-package if matching specialized Go files) and rename to `*Msg`.

- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.BatchMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.BatchMsg` (Usage: `tea.BatchMsg`)
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.BlurMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.BlurMsg`
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.ClearScreenMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.ClearScreenMsg` (Internal?)
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.DisableMouseMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.DisableMouseMsg` (Cmd result?)
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.EnableMouseAllMotionMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.EnableMouseAllMotionMsg`
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.EnableMouseCellMotionMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.EnableMouseCellMotionMsg`
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.EnterAltScreen` -> `com.williamcallahan.tui4j.compat.bubbletea.EnterAltScreenMsg`
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.ExecCompletedMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.ExecCompletedMsg` (Start/Finish?)
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.ExecProcessMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.ExecProcessMsg`
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.ExitAltScreen` -> `com.williamcallahan.tui4j.compat.bubbletea.ExitAltScreenMsg`
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.FocusMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.FocusMsg`
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.KeyPressMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.KeyMsg` (**High Priority**)
    - *Reference: `bubbletea/key.go` defines `KeyMsg`*
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.PrintLineMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.PrintLineMsg` (?)
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.QuitMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.QuitMsg`
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.ResumeMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.ResumeMsg`
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.SequenceMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.SequenceMsg`
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.SetWindowTitleMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.SetWindowTitleMsg`
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.SuspendMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.SuspendMsg`
- [/] `com.williamcallahan.tui4j.compat.bubbletea.message.WindowSizeMessage` -> `com.williamcallahan.tui4j.compat.bubbletea.WindowSizeMsg`
    - *Reference: `bubbletea/tea.go` defines `WindowSizeMsg`*

## 3. Lip Gloss Flattening (COMPLETE)
Move sub-packages to root `compat.lipgloss` to match Go.

- [x] `lipgloss.term` -> `lipgloss` (Move `Output.java`)
- [x] `lipgloss.list` -> `lipgloss` (Move `List.java`, `ListEnumerator.java`)
- [x] `lipgloss.margin` -> `lipgloss` (Already integrated in Style)
- [x] `lipgloss.padding` -> `lipgloss` (Already integrated in Style)
- [x] `lipgloss.placement` -> `lipgloss` (Already integrated in Style)
- [x] Verify no `compat.bubbletea.lipgloss` legacy package exists.

## 4. Bubbles Parity Check (COMPLETE)
Verify matching file presence and naming.

### 4.1 Key
- [x] `Key.java` vs `Binding.java`.
- **Status**: Accept deviation. Go has `key.Binding` and `help.KeyMap`. Java has `Binding` and `KeyMap` interface.

### 4.2 Viewport
- [x] Extract `KeyMap` from `Viewport.java` to `viewport/KeyMap.java`.
- [x] Update `Viewport.java` to use new `KeyMap`.

### 4.3 List
- [x] Rename `list/Keys.java` to `list/KeyMap.java`.
- [x] Update `List.java` to use `list.KeyMap`.
- [x] Ensure `list.KeyMap` implements `Help.KeyMap`.

### 4.4 Cursor
- [x] Merge `CursorMode` into `Cursor.Mode`.
- [x] Update `TextInput` and `Textarea` to use `Cursor.Mode`.

### 4.5 FilePicker
- [x] Merge `DidSelectFileMsg` / `DidSelectDirectoryMsg` into `FilePicker`.
- [x] Resolve `ErrorMessage` usage.

## 5. Execution Plan
1.  **Refactor Messages:** Move and rename all `compat.bubbletea.message` classes.
2.  **Update Imports:** Fix all references in `tui4j` code and examples.
3.  **Delete Legacy:** Remove `compat.bubbletea.message` package once empty.
4.  **Audit Native:** Review `com.williamcallahan.tui4j.message` for redundant types to deprecate/remove.
