import sympy as sp


def main():
    quantity = sp.symbols("q")

    cost_expression = (quantity + 3) * (quantity + 5)
    expanded_cost = sp.expand(cost_expression)
    factored_cost = sp.factor(expanded_cost)
    simplified_expression = sp.simplify(
        (quantity**2 - 9) / (quantity - 3) - (quantity + 3)
    )

    production_equation = sp.Eq(quantity**2 - 5 * quantity + 6, 0)
    production_quantities = sp.solve(production_equation, quantity)

    print(f"Symbolic production quantity: {quantity}")
    print(f"Cost expression: {cost_expression}")
    print(f"Expanded cost expression: {expanded_cost}")
    print(f"Factored cost expression: {factored_cost}")
    print(f"Simplified expression: {simplified_expression}")
    print(f"Quadratic equation: {production_equation}")
    print(f"Production quantities: {production_quantities}")


if __name__ == "__main__":
    main()
