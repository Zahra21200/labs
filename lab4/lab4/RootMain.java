import Root.*;

public class RootMain {
    public static void main(String[] args) {
       
        Complex<Double> complex1 = new DoubleComplex(1, 2);
        Complex<Double> complex2 = new DoubleComplex(2, -1);

        Complex<Double> sum = complex1.add(complex2);
        Complex<Double> difference = complex1.subtract(complex2);
        Complex<Double> product = complex1.product(complex2);
        Complex<Double> quotient = complex1.div(complex2);

        System.out.println("Sum: " + sum);
        System.out.println("Sub: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Div: " + quotient);
    }
}