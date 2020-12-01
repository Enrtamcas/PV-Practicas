import java.util.Scanner;

public class Prac3 {

    public static void main(String[] args) {
        int mes, x;
        Scanner read = new Scanner(System.in);
        System.out.println("---------Cuatrimestre---------");


        System.out.println("Introduzca el mes en el que nos encontramos: ");
        mes = read.nextInt();
        if (mes < 1 || mes > 12) {
            System.out.println("El mes introducido no es válido.");
        } else {
            if (mes >= 1 && mes <= 4) System.out.println("Este mes está en el 1º cuatrimestre.");
            else if (mes > 4 && mes <= 8) System.out.println("Este mes está en el 2º cuatrimestre.");
            else if (mes > 8 && mes <= 12) System.out.println("Este mes está en el 3º cuatrimestre.");


            System.out.println("---------Función---------");
            System.out.println("Introduzca un valor de x para la función. (Dominio de la función: [0,∞): ");
            x = read.nextInt();

            if (x < 0) {
                System.out.println("El valor introducido no se encuentra en el dominio de la función.");
            } else {
                if (x >= 0 && x < 1) System.out.println("La función en " + x + " es igual a " + ((x * x) + 5));
                else if (x >= 1 && x < 3)
                    System.out.println("La función en " + x + " es igual a " + ((x) + (Math.sin(x))));
                else if (x >= 3 && x < 5) System.out.println("La función en " + x + " es igual a " + (3));
                else if (x >= 5) System.out.println("La función en " + x + " es igual a " + (x * x));
            }
        }
    }
}
