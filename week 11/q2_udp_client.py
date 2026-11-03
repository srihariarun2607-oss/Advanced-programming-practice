import json
import math
import socket

HOST = "127.0.0.1"
PORT = 5001


def parse_reading(text):
    sensor_id, separator, temperature_text = text.partition(":")
    if not separator or not sensor_id.strip():
        raise ValueError("Use the format sensor-id:temperature.")

    try:
        temperature = float(temperature_text.strip())
    except ValueError as error:
        raise ValueError("Temperature must be a number.") from error
    if not math.isfinite(temperature):
        raise ValueError("Temperature must be a finite number.")

    return {"sensor_id": sensor_id.strip(), "temperature": temperature}


def main():
    print("Enter readings as sensor-id:temperature. Press Enter to finish.")
    with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as client:
        while True:
            text = input("Reading: ").strip()
            if not text:
                break

            try:
                reading = parse_reading(text)
            except ValueError as error:
                print(error)
                continue

            packet = json.dumps(reading).encode("utf-8")
            client.sendto(packet, (HOST, PORT))
            print(f"Sent reading from {reading['sensor_id']}.")


if __name__ == "__main__":
    main()
