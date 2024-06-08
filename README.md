# Task 10 Computers

June 8, 2024
Deadline: Jun 24 (inclusive)

Create three classes:

### 1. `CalculatingDevice`
- **Constructor**: Takes a `name` (`String`).
- **Method**: 
  ```java
  public String calculate(double x, double y)
  ```
  This method calculates the sum of its arguments and returns a string (not a number) with the name of the machine and the result of the addition.
- **Static Method**:
  ```java
  public static void printRes(CalculatingDevice[] a, double x, double y)
  ```
  This method takes an array of calculating machines and arguments `x` and `y`. It prints the results of calculations with these arguments for each machine from the array.

### 2. `Calculator`
- Extends `CalculatingDevice`.
- **Override Method**:
  ```java
  public String calculate(double x, double y)
  ```
  This method gets the result of addition by invoking `super.calculate` and adds the result of subtraction (as a string).

### 3. `Computer`
- Extends `Calculator`.
- **Override Method**:
  ```java
  public String calculate(double x, double y)
  ```
  This method gets the result of addition and subtraction by invoking `super.calculate` and adds, as a string, the results of multiplication and division.

### The following program:

```java
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
```

### Should print something like:

```
Cray: 21.0+7.0=28.0; 21.0-7.0=14.0; 21.0*7.0=147.0; 21.0/7.0=3.0
Abacus: 21.0+7.0=28.0
HP: 21.0+7.0=28.0; 21.0-7.0=14.0
```

### Implementation

#### CalculatingDevice.java

```java
public class CalculatingDevice {
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
```

#### Calculator.java

```java
public class Calculator extends CalculatingDevice {

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
```

#### Computer.java

```java
public class Computer extends Calculator {

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
```

#### Computers.java

```java
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
```

### Explanation:

1. **CalculatingDevice Class:**
   - Has a constructor to initialize the name.
   - The `calculate` method sums the two numbers and returns a formatted string with the result.
   - The `printRes` static method iterates over an array of `CalculatingDevice` objects and prints their calculations.

2. **Calculator Class:**
   - Extends `CalculatingDevice`.
   - Overrides the `calculate` method to include subtraction in the result string.

3. **Computer Class:**
   - Extends `Calculator`.
   - Overrides the `calculate` method to include multiplication and division in the result string.

4. **Computers Class:**
   - Contains the `main` method.
   - Creates an array of `CalculatingDevice` objects including instances of `Computer`, `CalculatingDevice`, and `Calculator`.
   - Calls the `printRes` method to print the results for each device with the provided arguments.

### Output:

When you run the `Computers` class, it should produce the following output:

```
Cray: 21.0+7.0=28.0; 21.0-7.0=14.0; 21.0*7.0=147.0; 21.0/7.0=3.0
Abacus: 21.0+7.0=28.0
HP: 21.0+7.0=28.0; 21.0-7.0=14.0
```
