import java.util.Scanner;

public class Prac8 {
    public static final int STUDENTS = 20; //Inicializamos la variable que marcara el maximo de estudiantes.
    public static final int EXIT = 9;//Con este valor, indicamos cual es la cifra para terminar la ejecucion del programa
    public static int MAX = 0; //variable que marca el maximo del array

    public static int menu(Scanner scanner) { //Este metodo imprime el menu y le permite al usuario introducir la entrada
        int a;
        System.out.println("1-> Insert grades.\n"
                + "2-> Show grades.\n"
                + "3-> calculate statistics.\n"
                + "4-> Show the grade of one student.\n"
                + "5-> Edit the grade of one student.\n"
                + "6-> Show the registration and the grade of a student.\n"
                + "7-> Show the worst grade.\n"
                + "8-> Edit all the grades based on a percentage.\n"
                + "9-> Exit.\n"
                + "Choose an option: ");
        a = scanner.nextInt();
        return a;
    }

    public static double chooseNumber(double n, double a, double b, Scanner scanner) { //Este metodo persigue el fin de comprobar que el valor introducido sea valido dentro del rango.

        n = scanner.nextDouble();
        while (n < a || n > b) {
            System.out.println("Invalid value. Insert another one.");
            n = scanner.nextDouble();
        }
        return n;
    }

    public static void chooseMenu(int a, double[] array, Scanner scanner) { //este switch sera el encargado de mover y habilitar las opciones del menu
        switch (a) {
            case 1:
                MAX = fillGrades(array, scanner); //metodo para rellenar el array de notas. //La variable "MAX" nos indica el tope de alumnos
                break;
            case 2:
                showGrades(array); //metodo para mostrar el array.
                break;
            case 3:
                calculateStatistics(array, scanner); //metodo para calcular estadisticas
                break;
            case 4:
                showOneGrade(array, scanner); //metodo para modificar una nota
                break;
            case 5:
                insertOneGrade(array, scanner); //metodo para instertar o editar una nota
                break;
            case 6:
                showGrades2(array, scanner); //metodo para mostrar la tabla con las notas
                break;
            case 7:
                worstGrade(array, scanner); //metodo que muestra las peores notas
                break;
            case 8:
                percentage(array, scanner); //metodo que aplica el porcentaje
                break;
            case EXIT:
                System.out.println("End of the process."); //fin del proceso
                break;
            default:
                System.out.println("Invalid value.");
        }
        System.out.println("");
    }

    public static int fillGrades(double[] array, Scanner scanner) { //metodo para a?adir notas
        int check, //variable para comprobar si el usuario desea seguir introduciendo notas
                MAX = 0; //inicializamos el tope actual a 0
        System.out.println("*************************");
        System.out.println("Enter grades.");
        System.out.println("*************************");
        System.out.println("Do you want to insert the student grade?\n1-> Yes    Another value-> No");
        check = scanner.nextInt();
        while (check == 1 && MAX < array.length) {
            System.out.println("Student number " + (MAX + 1) + ". Grade:");
            array[MAX] = chooseNumber(array[MAX], 0, 10, scanner); //aplicamos este metodo para filtrar las notas fuera del rango
            MAX += 1; //aumentamos el tope
            System.out.println("Do you want to insert another grade?\n1-> Yes    Another value-> No"); //comprobacion para seguir introduciendo notas
            check = scanner.nextInt();
        }
        System.out.println("");
        return MAX; //devolvemos el valor tope, para trabajar con el durante el resto del programa

    }

    public static void showGrades(double[] array) { //nos muestra el array
        if (MAX == 0) System.out.println("There are no grades.");
        for (int i = 0; i < MAX; i++) {
            System.out.println("Student number: " + (i + 1) + ". grade: " + array[i] + ".");
        }
        System.out.println("");
    }

    public static void calculateStatistics(double[] array, Scanner scanner) { //Con este metodo calculamos las estadisticas
        int x, y, z, aux; //Variables para contabilizar aprobados, notables, sobresalientes. El auxiliar tendra la funcion de marcarnos la posicion del alumno con mayor nota
        double MAX1 = 0;//con esta variable comprobaremos la nota maxima
        double w = 0;//inicializamos los contadores
        x = y = z = 0;
        MAX1 = 0;
        aux = 0;
        if (MAX == 0) System.out.println("There are no grades.");
        else {
            System.out.println("*************************");
            System.out.println("Calculate Statistics.");
            System.out.println("*************************");
            for (int i = 0; i < MAX; i++) {
                w += array[i]; //recogemos el valor MAXimo de la suma de las notas para la media
                if (array[i] >= 5) x += +1; //recogemos la cantidad de aprobados
                if (array[i] >= 7 && array[i] < 9) y += 1; //recogemos la cantidad de notables
                else if (array[i] >= 9 && array[i] <= 9.6) z += 1; //recogemos la cantidad de sobresalientes
                if (array[i] > MAX1) { //este if comprueba la nota MAXima dentro de la lista
                    MAX1 = array[i]; //MAX1 es la nota maxima
                    aux = i; //aux graba la posicion de la lista de la nota maxima
                }
            }
            System.out.println("Arithmetic average: " + (w / MAX)); //media
            System.out.println("Students that have passed the test: " + (x * 100 / MAX) + "%"); //porcentaje de aprobados
            System.out.println("Students that have a grade between 7 and 9: " + (y * 100 / MAX) + "%"); //porcentaje de notables
            System.out.println("Students that have a grade between 9 and 9.6: " + (z * 100 / MAX) + "%"); //porcentaje de sobresalientes
            System.out.println("The greatest grade is " + MAX1 + ". It has been obtained by the student number " + (aux + 1)); //muestra la mejor nota y el numero del alumno
        }
        System.out.println("");
    }

    public static void showOneGrade(double[] array, Scanner scanner) { //metodo para mostrar una nota en concreto
        int a;
        if (MAX == 0) System.out.println("There are no grades.");
        else {
            System.out.println("*************************");
            System.out.println("Show the grade of one student.");
            System.out.println("*************************");
            System.out.println("Which grade do you want to see? Insert his registration:");
            a = scanner.nextInt();
            System.out.println("His grade is: " + array[a - 1]); //ya que el array comienza desde 0, si queremos ver la nota del alumno 5, este ocupa la posicion 4, por lo que al numero introducido se le resta uno
        }
        System.out.println("");
    }

    public static void insertOneGrade(double[] array, Scanner scanner) { //nos permite editar una nota
        int a;
        double b;
        if (MAX == 0) System.out.println("There are no grades.");
        else {
            System.out.println("*************************");
            System.out.println("Insert the grade of one student.");
            System.out.println("*************************");
            System.out.println("Which is the student that do you want to insert a new grade?:");
            a = scanner.nextInt();
            System.out.println("What is his new grade?:");
            b = scanner.nextDouble();
            array[a - 1] = b; //se le asigna la nota introducida al alumno correspondiente (sigue el mismo principio del apartado anterior)
            System.out.println("Now his grade is: " + array[a - 1]);//sigue el mismo principio que el apartado anterior
            System.out.println("");
        }
    }

    public static void showGrades2(double[] array, Scanner scanner) { //metodo para mostrar la tabla
        if (MAX == 0) System.out.println("There are no grades.");
        else {
            System.out.println("*************************");
            System.out.println("Show grades 2.");
            System.out.println("*************************");
            String b;
            System.out.println(
                    "Student    grade    State\n" +
                            "-------    ----    -----");
            for (int i = 0; i < MAX; i++) {
                b = check(array[i]); //metodo de comprobacion de nota, devuelve un String
                System.out.println((i + 1) + "          " + (array[i]) + "     " + b);
            }
            System.out.println("");
        }
    }

    public static String check(double a) {//metodo de comprobacion de nota
        String b = "";
        if (a >= 0.0 && a < 5.0) b = "Fail";
        if (a >= 5.0 && a < 7.0) b = "Pass";
        if (a >= 7.0 && a < 9.0) b = "Good";
        if (a >= 9.0 && a < 9.6) b = "Remarkable";
        if (a >= 9.6 && a <= 10) b = "Distinction";
        return b;
    }

    public static void worstGrade(double[] array, Scanner scanner) { //metodo que muestra las peores notas
        if (MAX == 0) System.out.println("There are no grades.");
        else {
            System.out.println("*************************");
            System.out.println("Show worst grade.");
            System.out.println("*************************");
            double min = 10;
            for (int i = 0; i < MAX; i++) { //primero recorre el array para seleccionar la nota mas baja
                if (array[i] < min) {
                    min = array[i];
                }
            }
            for (int i = 0; i < MAX; i++) { //vuelve a recorrer el array e imprime aquellos con la nota mas baja
                if (min == array[i]) {
                    System.out.println("Students: " + (i + 1) + "    Grade: " + min);
                }
            }
        }
    }

    public static void percentage(double[] array, Scanner scanner) { //metodo para aplicar el porcentaje
        if (MAX == 0) System.out.println("There are no grades.");
        else {
            double percentage;
            System.out.println("*************************");
            System.out.println("Percentages.");
            System.out.println("*************************");
            System.out.print("Insert the percentage that will increase the grade of all the students: ");
            percentage = scanner.nextDouble(); //se introduce el porcentaje que modificara a las notas
            for (int i = 0; i < MAX; i++) {
                array[i] = array[i] + (array[i] * ((percentage / 100))); //se recorre y se modifican las notas en base al porcentaje
                if (array[i] > 10) array[i] = 10; //en caso de superar la nota MAXima, se reescribe como 10
                if (array[i] < 0) array[i] = 0; //en caso de sacar una nota inferior a la minima, se reescribe como 0
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] grades = new double[STUDENTS]; //nuestro vector que originalmente tendra la longitud de la variable STUDENTS
        int a; //variable que nos permitira movernos dentro del switch
        System.out.println("*************************");
        System.out.println("Practica de Enrique Tamajon Castilla");
        System.out.println("*************************");
        do {
            a = menu(scanner);
            chooseMenu(a, grades, scanner);
        } while (a != EXIT);
    }
}


