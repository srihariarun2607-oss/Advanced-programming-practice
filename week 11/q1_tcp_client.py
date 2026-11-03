import json
import socket

HOST = "127.0.0.1"
PORT = 5000


def main():
    student_id = input("Enter your student ID: ").strip()
    if not student_id:
        print("Student ID cannot be empty.")
        return

    with socket.create_connection((HOST, PORT), timeout=5) as client:
        client.sendall((student_id + "\n").encode("utf-8"))
        reader = client.makefile("r", encoding="utf-8")
        try:
            response_line = reader.readline()
        finally:
            reader.close()

    if not response_line:
        raise ConnectionError("The server closed the connection without a response.")

    response = json.loads(response_line)
    if "error" in response:
        print(f"Request failed: {response['error']}")
    else:
        print(f"Result for {response['student_id']}: {response['result']}")


if __name__ == "__main__":
    main()
