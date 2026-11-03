import sympy as sp


def main():
    time = sp.symbols("t")
    displacement = time**3 - 6 * time**2 + 9 * time + 5
    velocity = sp.diff(displacement, time)
    acceleration = sp.diff(velocity, time)
    rest_times = sp.solve(sp.Eq(velocity, 0), time)

    print(f"Displacement function: s(t) = {displacement}")
    print(f"Velocity function: v(t) = {velocity}")
    print(f"Acceleration function: a(t) = {acceleration}")
    print(f"Times when the vehicle is momentarily at rest: {rest_times}")

    try:
        start = sp.Rational(input("Enter the start time (seconds): ").strip())
        end = sp.Rational(input("Enter the end time (seconds): ").strip())
    except (TypeError, ValueError, ZeroDivisionError) as error:
        raise ValueError("Enter valid numeric times, such as 0, 3, or 1/2.") from error

    if start < 0 or end < 0 or start > end:
        raise ValueError("Times must be non-negative and the start must not exceed the end.")

    interval_displacement = sp.integrate(velocity, (time, start, end))
    print(f"Displacement from t={start} to t={end}: {interval_displacement}")


if __name__ == "__main__":
    main()
