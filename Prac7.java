import java.util.Scanner;

public class Prac7 {

    public static int factorial(int n) {

        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int mcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return mcd(b, a % b);
        }
    }

    public static int mult(int m, int n) {

        if (n == 1) {
            return m;
        } else {
            return m + mult(m, n - 1);
        }
    }

    public static int pot(int b, int e) {
        if (e == 1) {
            return b;
        } else {
            return b * pot(b, e - 1);
        }
    }

    public static void main(String[] args) {


        int n, a, b, c, d, e, f;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número para calcular el factorial: ");
        n = scanner.nextInt();
        System.out.println(factorial(n));


        System.out.println("Introduzca los valores a dividir: ");
        System.out.print("a: ");
        a = scanner.nextInt();
        System.out.print("b: ");
        b = scanner.nextInt();
        System.out.println("a/b= " + mcd(a, b));


        System.out.println("Introduzca los valores para multiplicar: ");
        System.out.print("c: ");
        d = scanner.nextInt();
        System.out.print("d: ");
        c = scanner.nextInt();
        System.out.println("c*d= " + mult(c, d));

        System.out.println("Introduzca los valores de tal forma que c^d:");
        System.out.print("e: ");
        e = scanner.nextInt();
        System.out.print("f: ");
        f = scanner.nextInt();
        System.out.println("e^f = " + pot(e, f));

    }
}
