import java.util.Scanner;

public class Prac2 {

    public static void main(String[] args) {
        String a, b; //cadenas
        double c, d, e; //variables, lado1, lado2, ángulo
        System.out.println("(Programa realizado por Enrique Tamajón Castilla \n¡Buenos días! En este programa, podrá comprobar varias funcionalidades de las cadenas de texto y de triangulas.");
        System.out.println("------------------CADENAS------------------");
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca la primera palabra:");
        a = entrada.nextLine();
        System.out.println("Introduzcal la segunda palabra:");
        b = entrada.nextLine();
        System.out.println("Bien. \nLa longitud de la primera cadena es de: " + (a.length()) + " dígitos. \nLa longitud de la segunda cadena es de: " + (b.length()) + " dígitos.");
        System.out.println("¿La cadena 1 es igual a la cadena 2? (Sin mayúsculas) ->" + a.equals(b));
        System.out.println("¿La cadena 1 es igual a la cadena 2? (Con mayúsculas) ->" + a.equalsIgnoreCase(b));
        System.out.println("Cadena 1 en mayúsculas: " + a.toUpperCase());
        System.out.println("Cadena 2 en minúsculas: " + b.toLowerCase());
        if ((a.indexOf('a')) > (-1)) { //Con este if, nos aseguramos de que, en caso de que no haya ninguna 'a' en la cadena, no imprima el número.
            System.out.println("La letra 'a' se encuentra en la primera posición: " + (1 + a.indexOf('a'))); //Ya que la posición inicial es la 0, se le suma 1 para el primer digito.
        } else {
            System.out.println("La letra 'a' no está en la cadena " + a);
        }
        if ((b.indexOf('a') > (-1))) {
            System.out.println("La letra 'a' que se encuentra en la última posición: " + (1 + b.lastIndexOf('a')));
        } else {
            System.out.println("La letra 'a' no está en la cadena " + b);
        }
        System.out.println("Cabe declarar que 'A' no es 'a', por lo que no lo reconocerá.");
        System.out.println("------------------TRIÁNGULOS------------------");
        System.out.println("Introduzca el primer lado: ");
        c = entrada.nextDouble();
        System.out.println("Introduzca el segundo lado: ");
        d = entrada.nextDouble();
        System.out.println("Introduzca el ángulo: ");
        e = Math.toRadians(entrada.nextDouble());
        double area = ((1 / 2.00) * c * d * Math.sin(e));
        System.out.println("El area es: " + area);
    }

}
