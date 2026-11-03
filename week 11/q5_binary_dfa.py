from automata.fa.dfa import DFA

binary_suffix_dfa = DFA(
    states={"q0", "q1", "q2"},
    input_symbols={"0", "1"},
    transitions={
        "q0": {"0": "q1", "1": "q0"},
        "q1": {"0": "q1", "1": "q2"},
        "q2": {"0": "q1", "1": "q0"},
    },
    initial_state="q0",
    final_states={"q2"},
)


def is_accepted(text):
    return all(symbol in {"0", "1"} for symbol in text) and binary_suffix_dfa.accepts_input(
        text
    )


def main():
    entered = input(
        "Enter binary strings separated by commas (press Enter for examples): "
    )
    if entered.strip():
        test_strings = [item.strip() for item in entered.split(",")]
    else:
        test_strings = ["1001", "01", "110", "10101", "", "2"]

    for text in test_strings:
        display_text = text if text else "<empty>"
        result = "accepted" if is_accepted(text) else "rejected"
        print(f"{display_text!r}: {result}")


if __name__ == "__main__":
    main()
