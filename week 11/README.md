# Week 11 Programs

These programs cover TCP and UDP client-server communication, symbolic
mathematics with SymPy, and DFA/NFA construction with `automata-lib`.

## Install dependencies

From this directory, run:

```text
python -m pip install -r requirements.txt
```

## 1. Examination results over TCP

Open two terminals in this directory. Start the server in the first:

```text
python q1_tcp_server.py
```

Then run the client in the second:

```text
python q1_tcp_client.py
```

Enter a student ID such as `STU1001`. The server uses sample records; replace
the `STUDENT_RESULTS` entries in `q1_tcp_server.py` with the college's records.
The client and server default to `127.0.0.1:5000`; set the `HOST` and `PORT`
constants in both files to communicate across machines.

## 2. Sensor readings over UDP

Start the receiver in one terminal:

```text
python q2_udp_server.py
```

Run the sender in another and enter readings as `sensor-id:temperature`:

```text
python q2_udp_client.py
```

Enter a blank line to stop the sender. UDP has low overhead and is suitable
for frequent, independent sensor updates when occasional packet loss is
acceptable. Use TCP instead if every reading must arrive reliably and in order.

## 3-6. SymPy and automata

Run each program from this directory:

```text
python q3_symbolic_cost.py
python q4_vehicle_motion.py
python q5_binary_dfa.py
python q6_substring_nfa.py
```

The DFA accepts binary strings ending in `01`. The NFA accepts strings over
`{a, b}` that contain the substring `ab`. For either automaton, enter
comma-separated test strings, or press Enter to use the built-in examples.
