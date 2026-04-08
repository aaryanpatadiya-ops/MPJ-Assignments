class Figure {
    double value;

    Figure(double r) {
        value = 3.14 * r * r;
        System.out.println("Area of Circle: " + value);
    }

    Figure(double l, double b) {
        value = l * b;
        System.out.println("Area of Rectangle: " + value);
    }

    void calculate(double b, double h, String shape) {
        double result = 0.5 * b * h;
        System.out.println("Area of Triangle: " + result);
    }

    void calculate(int s) {
        int result = s * s;
        System.out.println("Area of Square: " + result);
    }
}

public class AreaCalc {
    public static void main(String[] args) {

        Figure obj1 = new Figure(7.0);
        Figure obj2 = new Figure(8.0, 3.0);

        Figure obj3 = new Figure(2.0);
        obj3.calculate(12, 6, "tri");
        obj3.calculate(5);
    }
}
