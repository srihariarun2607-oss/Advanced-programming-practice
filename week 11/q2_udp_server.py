import json
import math
import socket

HOST = "127.0.0.1"
PORT = 5001


def main():
    with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as server:
        server.bind((HOST, PORT))
        print(f"UDP weather server listening on {HOST}:{PORT}")
        print("Press Ctrl+C to stop.")

        while True:
            packet, address = server.recvfrom(1024)
            try:
                reading = json.loads(packet.decode("utf-8"))
                if not isinstance(reading, dict):
                    raise ValueError("reading must be a JSON object")
                sensor_id = reading["sensor_id"]
                temperature = reading["temperature"]
                if not isinstance(sensor_id, str) or not sensor_id.strip():
                    raise ValueError("sensor_id must be a non-empty string")
                if (
                    isinstance(temperature, bool)
                    or not isinstance(temperature, (int, float))
                    or not math.isfinite(temperature)
                ):
                    raise ValueError("temperature must be a finite number")
            except (UnicodeDecodeError, json.JSONDecodeError, KeyError, ValueError) as error:
                print(f"Ignoring invalid reading from {address}: {error}")
                continue

            print(
                f"Sensor {sensor_id.strip()} reported "
                f"{temperature} °C from {address[0]}:{address[1]}"
            )


if __name__ == "__main__":
    main()
