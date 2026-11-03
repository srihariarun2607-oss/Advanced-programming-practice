from automata.fa.nfa import NFA

substring_nfa = NFA(
    states={"q0", "q1", "q2"},
    input_symbols={"a", "b"},
    transitions={
        "q0": {"a": {"q0", "q1"}, "b": {"q0"}},
        "q1": {"a": set(), "b": {"q2"}},
        "q2": {"a": {"q2"}, "b": {"q2"}},
    },
    initial_state="q0",
    final_states={"q2"},
)


def is_accepted(text):
    return all(symbol in {"a", "b"} for symbol in text) and substring_nfa.accepts_input(
        text
    )


def main():
    entered = input(
        "Enter strings over {a, b} separated by commas (press Enter for examples): "
    )
    if entered.strip():
        test_strings = [item.strip() for item in entered.split(",")]
    else:
        test_strings = ["ab", "aab", "baba", "bbb", "a", "", "abc"]

    for text in test_strings:
        display_text = text if text else "<empty>"
        result = "accepted" if is_accepted(text) else "rejected"
        print(f"{display_text!r}: {result}")


if __name__ == "__main__":
    main()
