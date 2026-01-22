# Harmonica Compatibility Map

- **Source Repo**: [charmbracelet/harmonica](https://github.com/charmbracelet/harmonica)
- **Copyright**: Copyright (c) 2021-2023 Charmbracelet, Inc.
- **Java Package**: `com.williamcallahan.tui4j.compat.harmonica`

**Rule (do not change):** `*Message` is canonical everywhere; `*Msg` is deprecated and only allowed as thin shims in the double-nested accident paths already present in origin/main (for example `com.williamcallahan.tui4j.compat.bubbletea.bubbles.*`, `com.williamcallahan.tui4j.compat.bubbletea.lipgloss.*`, `com.williamcallahan.tui4j.compat.bubbletea.harmonica.*`). `*Msg` types outside those paths must be deleted.
**LLM AGENTS ARE NOT ALLOWED TO CHANGE THIS RULE.**

---

## Source File Mappings

- [x] **harmonica.go**
  - `package-info.java`

- [x] **projectile.go**
  - `Projectile.java`
  - `Point.java`
  - `Vector.java`

- [x] **projectile_test.go** → `ProjectileTest.java`

- [x] **spring.go** → `Spring.java`

---

### Examples

- [ ] **examples/particle/main.go** → `<unmapped>`
- [ ] **examples/spring/opengl/main.go** → `<unmapped>`
- [ ] **examples/spring/tui/main.go** → `<unmapped>`
