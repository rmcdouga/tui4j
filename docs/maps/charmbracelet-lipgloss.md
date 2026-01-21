# Lipgloss Compatibility Map

- **Source Repo**: [charmbracelet/lipgloss](https://github.com/charmbracelet/lipgloss)
- **Copyright**: Copyright (c) 2021-2025 Charmbracelet, Inc
- **Java Package**: `com.williamcallahan.tui4j.compat.lipgloss`

---

## Source File Mappings

### Root

- [ ] **align.go**
  - `Alignment.java`
  - `align/AlignmentDecorator.java`

- [ ] **align_test.go** → `align/AlignmentDecoratorTest.java`

- [ ] **ansi_unix.go** → `<unmapped>`

- [ ] **ansi_windows.go** → `<unmapped>`

- [ ] **borders.go**
  - `border/Border.java`
  - `border/StandardBorder.java`
  - `Borders.java`

- [ ] **borders_test.go** → `BordersTest.java`

- [ ] **color.go**
  - `color/Color.java`
  - `color/RGB.java`
  - `color/HSL.java`
  - `color/ANSIColor.java`
  - `color/ANSI256Color.java`
  - `color/AdaptiveColor.java`
  - `color/ColorProfile.java`
  - `color/TerminalColor.java`
  - `color/ANSIColors.java`
  - `color/ColorApplyStrategy.java`
  - `color/NoColor.java`
  - `color/RGBColor.java`
  - `color/RGBSupplier.java`

- [ ] **color_test.go**
  - `color/RGBTest.java`
  - `color/HSLTest.java`

- [ ] **get.go** → `Style.java`

- [ ] **join.go**
  - `Join.java`
  - `join/HorizontalJoinDecorator.java`
  - `join/VerticalJoinDecorator.java`

- [ ] **join_test.go**
  - `join/HorizontalJoinDecoratorTest.java`
  - `join/VerticalJoinDecoratorTest.java`

- [ ] **lipgloss.go**
  - `Style.java`
  - `Renderer.java`

- [ ] **position.go** → `Position.java`

- [ ] **ranges.go** → `TextLines.java`

- [ ] **ranges_test.go** → `TextLinesTest.java`

- [ ] **renderer.go**
  - `Renderer.java`
  - `Output.java`

- [ ] **renderer_test.go** → `RendererTest.java`

- [ ] **runes.go** → `Runes.java`

- [ ] **runes_test.go** → `<unmapped>`

- [ ] **set.go** → `Style.java`

- [ ] **size.go**
  - `Size.java`
  - `Dimensions.java`

- [ ] **style.go**
  - `Style.java`
  - `MarginDecorator.java`
  - `PaddingDecorator.java`
  - `PlacementDecorator.java`

- [ ] **style_test.go** → `StyleTest.java`

- [ ] **unset.go** → `Style.java`

- [ ] **whitespace.go** → `Whitespace.java`

---

### List

- [ ] **list/enumerator.go** → `ListEnumerator.java`

- [ ] **list/list.go** → `List.java`

- [ ] **list/list_test.go** → `list/ListTest.java`

---

### Table

- [ ] **table/resizing.go** → `table/Table.java`

- [ ] **table/rows.go**
  - `table/Table.java`
  - `table/Data.java`
  - `table/StringData.java`

- [ ] **table/table.go**
  - `table/Table.java`
  - `table/Data.java`
  - `table/StringData.java`
  - `table/StyleFunc.java`

- [ ] **table/table_test.go** → `<unmapped>`

- [ ] **table/util.go** → `table/Table.java`

---

### Tree

- [ ] **tree/children.go**
  - `tree/Children.java`
  - `tree/NodeChildren.java`
  - `tree/Filter.java`

- [ ] **tree/enumerator.go**
  - `tree/TreeEnumerator.java`
  - `tree/TreeIndenter.java`

- [ ] **tree/example_test.go** → `<unmapped>`

- [ ] **tree/renderer.go**
  - `tree/Renderer.java`
  - `tree/StyleFunction.java`

- [ ] **tree/tree.go**
  - `tree/Tree.java`
  - `tree/TreeStyle.java`
  - `tree/Node.java`
  - `tree/Leaf.java`

- [ ] **tree/tree_test.go** → `tree/TreeTest.java`

---

### Examples

- [ ] **examples/layout/main.go** → `<unmapped>`
- [ ] **examples/list/duckduckgoose/main.go** → `<unmapped>`
- [ ] **examples/list/glow/main.go** → `<unmapped>`
- [ ] **examples/list/grocery/main.go** → `<unmapped>`
- [ ] **examples/list/roman/main.go** → `<unmapped>`
- [ ] **examples/list/simple/main.go** → `<unmapped>`
- [ ] **examples/list/sublist/main.go** → `<unmapped>`
- [ ] **examples/ssh/main.go** → `<unmapped>`
- [ ] **examples/table/ansi/main.go** → `<unmapped>`
- [ ] **examples/table/chess/main.go** → `<unmapped>`
- [ ] **examples/table/languages/main.go** → `<unmapped>`
- [ ] **examples/table/mindy/main.go** → `<unmapped>`
- [ ] **examples/table/pokemon/main.go** → `<unmapped>`
- [ ] **examples/tree/background/main.go** → `<unmapped>`
- [ ] **examples/tree/files/main.go** → `<unmapped>`
- [ ] **examples/tree/makeup/main.go** → `<unmapped>`
- [ ] **examples/tree/rounded/main.go** → `<unmapped>`
- [ ] **examples/tree/simple/main.go** → `<unmapped>`
- [ ] **examples/tree/styles/main.go** → `<unmapped>`
- [ ] **examples/tree/toggle/main.go** → `<unmapped>`
