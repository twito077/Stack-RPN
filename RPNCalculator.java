package demo;

public class RPNCalculator {
    public int evaluate(String expression) {
        Stack stack = new Stack();
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int result = applyOperator(token, a, b);
                stack.push(String.valueOf(result));
            } else {
                stack.push(token);
            }
        }
        
        return Integer.parseInt(stack.pop());
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int applyOperator(String operator, int a, int b) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}

