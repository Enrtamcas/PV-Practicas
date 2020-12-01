import java.util.Scanner;

public class Prac6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        presentacion();//Método para presentarme
        do {
            menu(); //Menu
            option = scanner.nextInt(); //Método que se encarga de darle un valor a la opcion que luego será utilizada en el switch
            change(scanner, option); //Método que se encarga de seleccionar la opcion
        } while (option != 3); //Al seleccionar la opcion 3, se rompe el programa
    }


    public static void presentacion() {//Inicio del método de presentacion
        System.out.println("*******************");
        System.out.println("Subprogramas.  Nombre: Enrique  Apellidos: Tamajón Castilla");
        System.out.println("*******************");
    } //Fin del método de presentacion

    public static void menu() { //Inicio método menu
        System.out.println("\nMenú\n" +
                "1-> Múltiplos sinceros.\n" +
                "2-> Números Colegas.\n" +
                "3-> Terminar.\n" +
                "Por favor, introduzca una opción.");
    } //Fin del método menu

    public static void change(Scanner scanner, int x) { //Método para switch

        switch (x) {
            case 1: {
                numberSincero(scanner); //En caso 1, se realiza el multiplo sincero
                break;
            }
            case 2: {
                numberColega(scanner); //En caso 2, se realiza el numero colega
                break;
            }
            case 3: {
                System.out.println("Fin del programa."); //En caso 3, se rompe el programa
                break;
            }
            default: {
                System.out.println("Valor introducido no válido.");
            }
        }
    }

    public static int chooseNumber(Scanner scanner, int x, int z) { //Método de comprobacion de error entre dos numeros dados
        int option;
        option = scanner.nextInt();
        while (option < x || option > z) {
            System.out.println("Valor no válido. Introduzca otro, por favor: ");
            option = scanner.nextInt();
        }
        return option;
    } //Fin del método

    public static void numberSincero(Scanner scanner) { //Método para mostrar los numeros sinceros
        int x, s;
        System.out.println("*******************");
        System.out.println("Números sinceros");
        System.out.println("*******************");
        System.out.println("Introduzca un número base (entre 1 y 9):");
        x = chooseNumber(scanner, 1, 9); //base
        System.out.println("Introduzca un número mayor que " + x);
        s = scanner.nextInt();//limite
        while (x >= s) {
            System.out.println("Número no válido. Introduzca otro.");
            s = scanner.nextInt();
        }
        System.out.println("Este número funcionará como límite, y se calcularán todos los múltiplos sinceros hasta " + s);


        for (int i = x; i <= s; i++) {
            if (((i % x) == 0) && (x == calculateNSincero(scanner, i))) {
                System.out.println(i + " es un número sincero en base " + x);
            }
        }
    } //Fin del método

    public static int calculateNSincero(Scanner scanner, int s) { //Método para calcular la suma de todos los digitos de un numero dado.
        int sumaDigitos = 0;
        while (s > 0) {
            sumaDigitos = sumaDigitos + (s % 10);
            s = s / 10;
        }
        return sumaDigitos;
    } //Fin del método

    public static void numberColega(Scanner scanner) { //Método para mostrar los numeros colegas
        int x, s;
        Scanner read = new Scanner(System.in);
        System.out.println("*******************\n" +
                "Números colegas\n" +
                "*******************\n");
        System.out.println("Introduzca un número (entre 1 y 9):");
        x = chooseNumber(scanner, 1, 9); //base
        System.out.println("Introduzca un número.");
        s = read.nextInt();

        if (((start(s) / x) == 1) && (end(s) / x) == 1) {
            System.out.println("El número " + s + " es colega.");
        } else {
            System.out.println("El número " + s + " no es colega.");
        }
    } //Fin del subprograma para mostrar los numeros colegas

    public static int end(int x) { //Método para calcular la ultima cifra del numero
        x = x % 10;
        return x;
    } //Fin

    public static int start(int s) {//Método para calcular la primera cifra del numero
        while (s > 9) {
            s = s / 10;
        }
        return s;
    }//Fin
}
