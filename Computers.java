public class Computers {

    public static void main(String[] args) {
        CalculatingDevice[] arr = {
            new Computer("Cray"),
            new CalculatingDevice("Abacus"),
            new Calculator("HP")
        };
        CalculatingDevice.printRes(arr, 21, 7);
    }
}

// Base class
class CalculatingDevice {
    private String name;

    public CalculatingDevice(String name) {
        this.name = name;
    }

    public String calculate(double x, double y) {
        double sum = x + y;
        return name + ": " + x + "+" + y + "=" + sum;
    }

    public static void printRes(CalculatingDevice[] a, double x, double y) {
        for (CalculatingDevice device : a) {
            System.out.println(device.calculate(x, y));
        }
    }
}

// Subclass extending CalculatingDevice
class Calculator extends CalculatingDevice {

    public Calculator(String name) {
        super(name);
    }

    @Override
    public String calculate(double x, double y) {
        String result = super.calculate(x, y);
        double difference = x - y;
        return result + "; " + x + "-" + y + "=" + difference;
    }
}

// Subclass extending Calculator
class Computer extends Calculator {

    public Computer(String name) {
        super(name);
    }

    @Override
    public String calculate(double x, double y) {
        String result = super.calculate(x, y);
        double product = x * y;
        double quotient = x / y;
        return result + "; " + x + "*" + y + "=" + product + "; " + x + "/" + y + "=" + quotient;
    }
}
