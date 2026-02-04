import java.util.HashMap;
import java.util.Map;

public class RDParser {
    private final String expression;
    private final Map<String, Double> variables;

    public RDParser(String expression) {
        this(expression, new HashMap<>());
    }

    public RDParser(String expression, Map<String, Double> variables) {
        this.expression = expression.replace(" ", "");
        this.variables = new HashMap<>(variables);
        this.injectConstants();
    }

    private void injectConstants() {
        this.variables.putIfAbsent("pi", Math.PI);
        this.variables.putIfAbsent("PI", Math.PI);
        this.variables.putIfAbsent("π", Math.PI); //option + p bei mac lol
        this.variables.putIfAbsent("e", Math.E);
    }


    // startet
    public double evaluate() throws RDParserException {
        return this.evaluateIntern(this.expression);
    }


    // sucht und teilt auf
    private double evaluateIntern(String s) throws RDParserException {
        if (s == null || s.isEmpty()) {
            throw new RDParserException("Empty expression");
        }

        s = this.normalizeLeadingSign(s);

        int pos = this.findOperatorAtLevel(s, '+');
        if (pos == -1) {
            pos = this.findOperatorAtLevel(s, '-');
        }
        if (pos != -1) {
            return this.combineBinary(s, pos);
        }

        pos = this.findOperatorAtLevel(s, '*');
        if (pos == -1) {
            pos = this.findOperatorAtLevel(s, '/');
        }
        if (pos != -1) {
            return this.combineBinary(s, pos);
        }

        pos = this.findOperatorAtLevel(s, '^');
        if (pos != -1) {
            return this.combineBinary(s, pos);
        }

        if (this.isWrappedInParentheses(s)) {
            return this.evaluateIntern(s.substring(1, s.length() - 1));
        }

        Double variableValue = this.variables.get(s);
        if (variableValue != null) {
            return variableValue;
        }

        return this.parseNumber(s);
    }


    // zerlegt
    private double combineBinary(String s, int operatorIndex) throws RDParserException {
        double left = this.evaluateIntern(s.substring(0, operatorIndex));
        double right = this.evaluateIntern(s.substring(operatorIndex + 1));
        return this.applyBinaryOperator(s.charAt(operatorIndex), left, right);
    }


    // grundoperationen
    private double applyBinaryOperator(char operator, double left, double right) throws RDParserException {
        switch (operator) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            case '/':
                return left / right;
            case '^':
                return Math.pow(left, right);
            default:
                throw new RDParserException("Unsupported operator: " + operator);
        }
    }


    // gibts die zahl?
    private double parseNumber(String s) throws RDParserException {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new RDParserException("Invalid number: " + s);
        }
    }

    // 0 vor + und -
    private String normalizeLeadingSign(String s) {
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            return "0" + s;
        }
        return s;
    }

    // sucht klamern
    private int findOperatorAtLevel(String s, char operator) {
        int level = 0;
        for (int i = 0; i < s.length(); ++i) {
            char current = s.charAt(i);
            if (current == '(') {
                ++level;
            } else if (current == ')') {
                --level;
            }
            if (level == 0 && current == operator) {
                return i;
            }
        }
        return -1;
    }

    //ergeben die klammern sinn?
    private boolean isWrappedInParentheses(String s) {
        if (!s.startsWith("(") || !s.endsWith(")")) {
            return false;
        }
        int level = 0;
        for (int i = 0; i < s.length(); ++i) {
            char current = s.charAt(i);
            if (current == '(') {
                ++level;
            } else if (current == ')') {
                --level;
                if (level == 0 && i < s.length() - 1) {
                    return false;
                }
            }
        }
        return level == 0;
    }


}