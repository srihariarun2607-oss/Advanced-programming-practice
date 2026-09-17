public class Temperature {
    double celsius;

    void convert(){
        double fahrenheit = (celsius * 9/5) + 32;
        System.out.println("Temperature in Celsius: " + celsius);
        System.out.println("Temperature in Fahrenheit: " + fahrenheit);
    }
    public static void main(String[] args) {
        Temperature t = new Temperature();
        t.celsius = 100.0;
        t.convert();
    }
}
