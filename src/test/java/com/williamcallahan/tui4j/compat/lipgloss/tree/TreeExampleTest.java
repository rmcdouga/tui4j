package com.williamcallahan.tui4j.compat.lipgloss.tree;

import com.williamcallahan.tui4j.compat.x.ansi.Strip;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Port of github.com/charmbracelet/lipgloss/tree/example_test.go.
 */
class TreeExampleTest {

    @Test
    void exampleLeafSetHidden() {
        Tree tree = new Tree().child(
                "Foo",
                Tree.withRoot("Bar")
                        .child(
                                "Qux",
                                Tree.withRoot("Quux").child("Hello!"),
                                "Quuux"
                        ),
                "Baz"
        );

        Tree bar = (Tree) tree.children().at(1);
        Leaf quuux = (Leaf) bar.children().at(2);
        quuux.setHidden(true);

        assertThat(tree.render()).isEqualTo(
                """
                        ├── Foo
                        ├── Bar
                        │   ├── Qux
                        │   └── Quux
                        │       └── Hello!
                        └── Baz""");
    }

    @Test
    void exampleNewLeaf() {
        Tree tree = new Tree().child(
                "Foo",
                Tree.withRoot("Bar")
                        .child(
                                "Qux",
                                Tree.withRoot("Quux")
                                        .child(
                                                Tree.newLeaf("This should be hidden", true),
                                                Tree.newLeaf(Tree.withRoot("I am groot").child("leaves"), false)
                                        ),
                                "Quuux"
                        ),
                "Baz"
        );

        assertThat(tree.render()).isEqualTo(
                """
                        ├── Foo
                        ├── Bar
                        │   ├── Qux
                        │   ├── Quux
                        │   │   └── I am groot
                        │   │       └── leaves
                        │   └── Quuux
                        └── Baz""");
    }

    @Test
    void exampleLeafSetValue() {
        Tree tree = Tree
                .withRoot("⁜ Makeup")
                .child(
                        "Glossier",
                        "Fenty Beauty",
                        new Tree().child(
                                "Gloss Bomb Universal Lip Luminizer",
                                "Hot Cheeks Velour Blushlighter"
                        ),
                        "Nyx",
                        "Mac",
                        "Milk"
                )
                .enumerator(new TreeEnumerator.RounderEnumerator());

        Leaf glossier = (Leaf) tree.children().at(0);
        glossier.setValue("Il Makiage");

        assertThat(Strip.strip(tree.render())).isEqualTo(
                """
                        ⁜ Makeup
                        ├── Il Makiage
                        ├── Fenty Beauty
                        │   ├── Gloss Bomb Universal Lip Luminizer
                        │   ╰── Hot Cheeks Velour Blushlighter
                        ├── Nyx
                        ├── Mac
                        ╰── Milk""");
    }

    @Test
    void exampleTreeHide() {
        Tree tree = new Tree().child(
                "Foo",
                Tree.withRoot("Bar")
                        .child(
                                "Qux",
                                Tree.withRoot("Quux")
                                        .child("Foo", "Bar")
                                        .hide(true),
                                "Quuux"
                        ),
                "Baz"
        );

        assertThat(tree.render()).isEqualTo(
                """
                        ├── Foo
                        ├── Bar
                        │   ├── Qux
                        │   └── Quuux
                        └── Baz""");
    }

    @Test
    void exampleTreeSetHidden() {
        Tree tree = new Tree().child(
                "Foo",
                Tree.withRoot("Bar")
                        .child(
                                "Qux",
                                Tree.withRoot("Quux")
                                        .child("Foo", "Bar"),
                                "Quuux"
                        ),
                "Baz"
        );

        Tree bar = (Tree) tree.children().at(1);
        Tree quux = (Tree) bar.children().at(1);
        quux.setHidden(true);

        assertThat(tree.render()).isEqualTo(
                """
                        ├── Foo
                        ├── Bar
                        │   ├── Qux
                        │   └── Quuux
                        └── Baz""");
    }
}
