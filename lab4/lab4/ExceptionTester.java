import Exceptions.*;

public class ExceptionTester {
    public static void main(String[] args) {
        NumberProcessor processor = new NumberProcessor();
        try {
            int result = processor.computeFunction(-5);
            System.out.println("Result: " + result);
        } catch (NegativeNumberException e) {
            System.out.println("Caught NegativeNumberException: " + e.getMessage());
            e.printStackTrace();
        } 
    }
}