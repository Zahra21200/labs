public class TempMain {
    public static void main(String[] args) {
        int x = 24;
        
        float outTemp = new tempInterface<Integer, Float>() {
            @Override
            public Float apply(Integer celsius) {
                return (celsius * 9 / 5.0f) + 32;
            }
        }.apply(x);

        System.out.println("Temp is = " + x + "C or " + outTemp + " F");
    }
    
    interface tempInterface<T, R> {
        R apply(T m);
    }
}
