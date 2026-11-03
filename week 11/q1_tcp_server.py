import json
import socket

HOST = "127.0.0.1"
PORT = 5000

STUDENT_RESULTS = {
    "STU1001": "Mathematics: 88, Physics: 91, Chemistry: 85",
    "STU1002": "Mathematics: 76, Physics: 82, Chemistry: 90",
    "STU1003": "Mathematics: 95, Physics: 89, Chemistry: 93",
}


def handle_client(connection, address):
    with connection:
        print(f"Connected by {address}")
        reader = connection.makefile("r", encoding="utf-8")
        try:
            student_id = reader.readline(257).strip()
            if not student_id:
                response = {"error": "No student ID was provided."}
            elif len(student_id) > 256:
                response = {"error": "Student ID is too long."}
            else:
                result = STUDENT_RESULTS.get(student_id.upper())
                if result is None:
                    response = {"error": "No result found for that student ID."}
                else:
                    response = {"student_id": student_id.upper(), "result": result}

            connection.sendall((json.dumps(response) + "\n").encode("utf-8"))
        finally:
            reader.close()


def main():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server:
        server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        server.bind((HOST, PORT))
        server.listen()
        print(f"TCP result server listening on {HOST}:{PORT}")

        while True:
            connection, address = server.accept()
            handle_client(connection, address)


if __name__ == "__main__":
    main()
