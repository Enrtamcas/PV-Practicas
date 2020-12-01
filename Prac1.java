import java.util.Scanner;

public class Prac1 {

    public static void main(String[] args) {
        int x, y;
        System.out.println("(Programa realizado por Enrique Tamajón Castilla) \n¡Buenos días! En este programa, usted será capaz de visualizar cualquier operación de un número A y un número B");
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el valor de A:");
        x = entrada.nextInt();
        System.out.println("Introduzca el valor de B:");
        y = entrada.nextInt();
        System.out.println("Las operaciones, son las siguientes: \n Suma: " + (x + y) + "\n Resta: " + (x - y) + "\n Multiplicación: " + (x * y) + "\n División: " + (x / y) + "\n Resto: " + (x % y) + "\n A elevado a B: " + (Math.pow(x, y)));
    }
}
