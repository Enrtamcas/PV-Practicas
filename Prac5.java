import java.util.Scanner;

public class Prac5 {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        int opcion, x, y, z, w, contador, primoc, producto, productoT, compra; //Inicialización de variables que se usaran a lo largo del programa
        double precio, precioT, dinero;
        productoT = 0; //Las siguientes variables son contadores
        precioT = 0;
        contador = 0;
        primoc = 0;
        boolean comprobar = false;
        boolean comprobar2 = true;


        System.out.println("*********************************************");
        System.out.println("Nombre: Enrique   Apellidos: Tamajón Castilla");
        System.out.println("*********************************************");
        System.out.println("Bienvenido a este nuevo programa. Por favor, inserte que es lo que desea:");
        do {

            do {

                System.out.println(""); //Menú de opciones
                System.out.println("1 -> Número de primos en un rango.");
                System.out.println("2 -> Suma de primos en un rango.");
                System.out.println("3 -> Gasto de compras.");
                System.out.println("4 -> Fin de ejecución.");
                opcion = read.nextInt();
                System.out.println("");
                if (opcion <= 0 || opcion >= 5) { //Comprobación de que no se introduce un número incorrecto
                    System.out.println("Valor introducido no válido, por favor, introduzca otro:");
                } else {
                    comprobar = true;
                }
            } while (comprobar == false);
            switch (opcion) {
                case 1: { //Caso 1, cadena de primos
                    System.out.println("*********************************************");
                    System.out.println("Cadena de primos");
                    System.out.println("*********************************************");

                    System.out.println("Introduzca el primer valor del rango:");
                    x = read.nextInt();
                    System.out.println("Introduzca el segundo valor del rango:");
                    y = read.nextInt();
                    System.out.println("Los siguientes números son primos:");

                    for (int i = x; i <= y; i++) { //Primer for que recorre los números del intervalo
                        if (i == 1) System.out.print("1 ");
                        for (int nx = 1; nx <= i; nx++) { //Un segundo for que se encarga de comprobar si un número es únicamente divisible entre si mismo y entre 1
                            if (((i % nx) == 0))
                                primoc = primoc + 1; //Al ser primo, el contador siempre ascenderá a dos. (i/1 e i/i) al ejecutar la divisón.
                        }
                        if (primoc == 2)
                            System.out.print(i + " "); //Si este contador fuera mayor a 3, significa que es divisible por un número distinto de 1 y de i, por lo que no es primo
                        primoc = 0;  //Al terminar de examinar el número, el contador regresa a 0
                    }
                    break;
                }
                case 2: {
                    System.out.println("*********************************************");
                    System.out.println("Suma de primos");
                    System.out.println("*********************************************");

                    System.out.println("Introduzca el primer valor del rango (entre 10 y 50):");
                    z = read.nextInt();
                    while (z < 10 || z >= 50) { //Caso de error
                        System.out.println("Por favor, introduzca un número dentro del rango. [10, 50]");
                        z = read.nextInt();
                    }
                    System.out.println("Introduzca el segundo valor del rango(entre 51 y 100):");
                    w = read.nextInt();
                    while (w < 51 || w > 100) { //Caso de error
                        System.out.println("Por favor, introduzca un número dentro del rango. [51, 100]");
                        w = read.nextInt();
                    }
                    System.out.println("Los siguientes números son primos: ");

                    for (int b = z; b <= w; b++) { //= al caso 1
                        if (b == 1) System.out.print("1 ");
                        for (int ns = 1; ns <= b; ns++) {
                            if (((b % ns) == 0)) primoc = primoc + 1;
                        }
                        if (primoc == 2) {
                            System.out.print(b + " ");
                            contador = contador + b;
                        } //Contador de suma de primos
                        primoc = 0;
                    }
                    System.out.println("");
                    System.out.println("La suma de los primos es de: " + contador);
                    break;
                }
                case 3: {
                    System.out.println("*********************************************");
                    System.out.println("Gasto de compras");
                    System.out.println("*********************************************");
                    do {
                        System.out.println("Introduzca la cantidad de productos que ha comprado:");
                        producto = read.nextInt();
                        System.out.println("A continuación, introduzca el precio en euros, por favor.");
                        precio = read.nextDouble();
                        dinero = precio * producto; //Variable que almacena el dinero gastado en esta compra
                        System.out.println("Gastado en esta compra: " + dinero + "€");
                        productoT = producto + productoT; //Variable que almacena la cantidad de productos total
                        precioT = dinero + precioT; //Variable que almacena lo gastado hasta el momento
                        System.out.println("¿Desea seguir comprando?");
                        System.out.println("1-> Sí­     2->No");
                        System.out.println("(Todo valor distinto de 1 será considerado como que usted desea dejar de comprar)");
                        compra = read.nextInt();
                    } while (compra == 1);
                    System.out.println("Usted ha comprado un total de: " + productoT + " producto(s)");
                    System.out.println("Usted ha gastado un total de: " + precioT + "€");
                    if (precioT <= 50) System.out.println("Gasto contenido.");
                    else if (precioT > 50 && precioT <= 100) System.out.println("Si era necesario...");
                    else if (precioT > 100 && precioT <= 150) System.out.println("Has gastado mucho.");
                    else if (precioT > 150) System.out.println("Te has pasao' bacalao.");
                    break;
                }
                case 4: {
                    System.out.println("Fin del programa.");
                    comprobar2 = false;
                    break;
                }
            }
        } while (comprobar2 == true);


    }
}
