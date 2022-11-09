package udacity.calculator;


// https://classroom.udacity.com/nanodegrees/nd079/parts/cd0381/modules/70dc24e1-d575-429b-9a48-e4a10de20895/lessons/59ab92ec-385b-479a-9e12-7e67e7e71277/concepts/ab95ac1e-511f-430c-9ef0-8b59eb8f8f55
public final class Calculate {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: Calculate [int] [operator] [int]");
            return;
        }

        Calculator calculator = new Calculator();
        calculator.registerOperation("+", (a, b) -> a + b);
        calculator.registerOperation("-", (a, b) -> a - b);
        calculator.registerOperation("/", (a, b) -> a / b);
        calculator.registerOperation("*", (a, b) -> a * b);
        calculator.registerOperation("^", (a, b) -> (int) Math.pow(a, b));

        int a = Integer.parseInt(args[0]);
        String operator = args[1];
        int b = Integer.parseInt(args[2]);

        System.out.println(calculator.calculate(a, operator, b));
    }
}
