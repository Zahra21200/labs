package Root;

public class DoubleComplex implements Complex<Double> {
    private final double real;
    private final double imaginary;

    public DoubleComplex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Double getReal() {
        return real;
    }

    public Double getImaginary() {
        return imaginary;
    }

    public Complex<Double> add(Complex<Double> z) {
        return new DoubleComplex(real + z.getReal(), imaginary + z.getImaginary());
    }

    public Complex<Double> subtract(Complex<Double> z) {
        return new DoubleComplex(real - z.getReal(), imaginary - z.getImaginary());
    }

    public Complex<Double> product(Complex<Double> z) {
        double newReal = real * z.getReal() - imaginary * z.getImaginary();
        double newImaginary = real * z.getImaginary() + imaginary * z.getReal();
        return new DoubleComplex(newReal, newImaginary);
    }

    public Complex<Double> div(Complex<Double> z) {
        double denominator = z.getReal() * z.getReal() + z.getImaginary() * z.getImaginary();
        double newReal = (real * z.getReal() + imaginary * z.getImaginary()) / denominator;
        double newImaginary = (imaginary * z.getReal() - real * z.getImaginary()) / denominator;
        return new DoubleComplex(newReal, newImaginary);
    }


    public String toString() {
        return real + " + " + imaginary + "i";
    }
}