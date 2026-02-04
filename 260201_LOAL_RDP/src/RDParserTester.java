import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RDParserTester {



    public static void main(String[] args) {



        /* AUFGABE 2:
        // Test for right associativity:
        // 2^3^2 is 512.0 (2^9), not 64.0 (8^2)
        RDParser parser = new RDParser("2^3^2");
        // Result: 512.0
        // Combined test
        RDParser parser2 = new RDParser("4+5*2^2");
        // Priority: 2^2=4 -> 5*4=20 -> 4+20=24
        // Result: 24.0

        try {
            System.out.println(parser2.evaluate());
            System.out.println(parser.evaluate());
        } catch(RDParserException e) {
            e.printStackTrace();
        }
         */

   try {
        // Example1 1: Using PI and ^
        // Area of a circle: r^2 * pi (with r=10)
        String formel1 = "10^2 * PI";
        RDParser parser1 = new RDParser(formel1);
        System.out.println("Area of a circle (r=10): " + parser1.evaluate());


        // Example 2: Using variables
       Map<String, Double> myVars = new HashMap<>();
       myVars.put("x", 5.0);
       myVars.put("y", 3.0);
       myVars.put("cost", 9.99);

        // Expression: -x + y * cost
        // Expectation: -5 + 3 * 9.99 = -5 + 29.97 = 24.97
       RDParser parser2 = new RDParser("-x + y * cost", myVars);
       System.out.println("Result: " + parser2.evaluate());

       //scanner
       Scanner scanner = new Scanner(System.in);
         System.out.print("Enter a mathematical expression: ");
            String userInput = scanner.nextLine();
            RDParser userParser = new RDParser(userInput, myVars);
            try {
                double result = userParser.evaluate();
                System.out.println("Result: " + result);
            } catch (RDParserException e) {
                System.err.println("Error evaluating expression: " + e.getMessage());
            }
            scanner.close();


        // Example 3: Error (unknown variable z)
       RDParser parserError = new RDParser("x * z", myVars);
       System.out.println(parserError.evaluate());

    } catch(RDParserException e) {
        System.err.println("Parse Error: " + e.getMessage());
    }
}


}