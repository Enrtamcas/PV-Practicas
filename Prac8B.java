
import java.io.Serializable;
import java.util.Scanner;

class StudentsData implements Serializable {
    public String name;
    public double mark;
    public int age;
}

public class Prac8B {

    public static final int STUDENTS = 20; //Inicializamos la variable que marcara el maximo de estudiantes.
    public static final int EXIT = 13;//Con este valor, indicamos cual es la cifra para terminar la ejecucion del programa
    public static int MAX = 0; //variable que marca el maximo del array, inicializada a 0
    public static int ROW = 0; //Inicializamos como variable global las filas de la matriz
    public static int COLUMN = 0;//Inicializamos como variable global las columnas de la matriz
    public static boolean checkMatrix = false; //Comprobaci?n del programa para ver si ya hay una matriz creada
    public static Scanner scanner = new Scanner(System.in);
    public static StudentsData[] objets = new StudentsData[STUDENTS]; //Creamos el array de la clase StudentsData
    public static int[][] matrix; //Creamos el array bidimensional de la matriz

    public static int menu() { //Este metodo imprime el menu y le permite al usuario introducir la entrada
        int a;
        System.out.println("1-> Insert grades.\n"
                + "2-> Show grades.\n"
                + "3-> calculate statistics.\n"
                + "4-> Show the grade of one student.\n"
                + "5-> Edit the grade of one student.\n"
                + "6-> Show the registration and the grade of a student.\n"
                + "7-> Show the worst grade.\n"
                + "8-> Edit all the grades based on a percentage.\n"
                + "9 -> Fill matrix.\n"
                + "10 -> Show matrix.\n"
                + "11 -> Show an element of the matrix.\n"
                + "12 -> Modify an element of the matrix. \n"
                + "13 -> Exit.\n"
                + "Choose an option: ");
        a = scanner.nextInt();
        return a;
    }

    public static double chooseNumber(double n, double a, double b) { //Este metodo persigue el fin de comprobar que el valor introducido sea valido dentro del rango.

        n = scanner.nextDouble();
        while (n < a || n > b) {
            System.out.println("Invalid value. Insert another one.");
            n = scanner.nextDouble();
        }
        return n;
    }

    public static void chooseMenu(int a) { //este switch sera el encargado de mover y habilitar las opciones del menu
        switch (a) {
            case 1:
                fillGrades(); //metodo para rellenar el array de notas. //La variable "MAX" nos indica el tope de alumnos
                break;
            case 2:
                showGrades(); //metodo para mostrar el array.
                break;
            case 3:
                calculateStatistics(); //metodo para calcular estadisticas
                break;
            case 4:
                showOneGrade(); //metodo para modificar una nota
                break;
            case 5:
                insertOneGrade(); //metodo para instertar o editar una nota
                break;
            case 6:
                showGrades2(); //metodo para mostrar la tabla con las notas
                break;
            case 7:
                worstGrade(); //metodo que muestra las peores notas
                break;
            case 8:
                percentage(); //metodo que aplica el porcentaje
                break;
            case 9:
                fillMatrix(); //metodo para rellenar la matriz
                break;
            case 10:
                showMatrix(); //metodo para mostrar la matriz
                break;
            case 11:
                searchMatrix(); //metodo para buscar dentro de la matriz
                break;
            case 12:
                modifyMatrix(); //metodo para modificar la matriz
                break;
            case EXIT:
                System.out.println("End of the process."); //fin del proceso
                break;
            default:
                System.out.println("Invalid value.");
        }
        System.out.println("");
    }

    public static void fillGrades() { //metodo para a?adir notas
        int check; //variable para comprobar si el usuario desea seguir introduciendo notas
        System.out.println("*************************");
        System.out.println("Insert grades.");
        System.out.println("*************************");
        System.out.println("Do you want to insert the student grade?\n1-> Yes    Another value-> No");
        check = scanner.nextInt();
        for (int i = 0; i < objets.length; i++) {
            objets[i] = new StudentsData();
        }
        while (check == 1 && MAX < objets.length) {
            System.out.println("Student number " + (MAX + 1) + ".");
            System.out.print("Name: ");
            objets[MAX].name = scanner.next();
            System.out.print("Grade: ");
            objets[MAX].mark = chooseNumber(objets[MAX].mark, 0, 10); //aplicamos este metodo para filtrar las notas fuera del rango
            System.out.print("Age: ");
            objets[MAX].age = scanner.nextInt();
            MAX += 1; //aumentamos el tope
            System.out.println("\nDo you want to insert another grade?\n1-> Yes    Another value-> No"); //comprobacion para seguir introduciendo notas
            check = scanner.nextInt();
        }
        System.out.println("");
    }

    public static void showGrades() { //nos muestra el array
        if (MAX == 0) System.out.println("There are no grades.");
        else {
            for (int i = 0; i < MAX; i++) {
                System.out.println("Student number: " + (i + 1) + ".");
                System.out.println("Name: " + objets[i].name);
                System.out.println("Grade: " + objets[i].mark);
                System.out.println("Age: " + objets[i].age);
                System.out.println("");
            }
            System.out.println("");
        }
    }

    public static void calculateStatistics() { //Con este metodo calculamos las estadisticas
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
                w += objets[i].mark; //recogemos el valor MAXimo de la suma de las notas para la media
                if (objets[i].mark >= 5) x += +1; //recogemos la cantidad de aprobados
                if (objets[i].mark >= 7 && objets[i].mark < 9) y += 1; //recogemos la cantidad de notables
                else if (objets[i].mark >= 9 && objets[i].mark <= 9.6) z += 1; //recogemos la cantidad de sobresalientes
                if (objets[i].mark > MAX1) { //este if comprueba la nota MAXima dentro de la lista
                    MAX1 = objets[i].mark; //MAX1 es la nota maxima
                    aux = i; //aux graba la posicion de la lista de la nota maxima
                }
            }
            System.out.println("Arithmetic average: " + (w / MAX)); //media
            System.out.println("Students that have passed the test: " + (x * 100 / MAX) + "%"); //porcentaje de aprobados
            System.out.println("Students that have a grade between 7 and 9: " + (y * 100 / MAX) + "%"); //porcentaje de notables
            System.out.println("Students that have a grade between 9 and 9.6: " + (z * 100 / MAX) + "%"); //porcentaje de sobresalientes
            System.out.println("The greatest grade is " + MAX1 + ". It has been obtained by the student number " + (aux + 1) + " (" + objets[aux].name + ")"); //muestra la mejor nota y el numero del alumno
        }
        System.out.println("");
    }

    public static void showOneGrade() { //metodo para mostrar una nota en concreto
        int a;
        if (MAX == 0) System.out.println("There are no grades.");
        else {
            System.out.println("*************************");
            System.out.println("Show the grade of one student.");
            System.out.println("*************************");
            System.out.println("Which grade do you want to see? Insert his registration:");
            a = scanner.nextInt();
            System.out.println("Student's name: " + objets[a - 1].name);
            System.out.println("Grade: " + objets[a - 1].mark); //ya que el array comienza desde 0, si queremos ver la nota del alumno 5, este ocupa la posicion 4, por lo que al numero introducido se le resta uno
            System.out.println("Age: " + objets[a - 1].age);
        }
        System.out.println("");
    }

    public static void insertOneGrade() { //nos permite editar una nota
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
            objets[a - 1].mark = b; //se le asigna la nota introducida al alumno correspondiente (sigue el mismo principio del apartado anterior)
            System.out.println("Now his grade is: " + objets[a - 1].mark);//sigue el mismo principio que el apartado anterior
            System.out.println("");
        }
    }

    public static void showGrades2() { //metodo para mostrar la tabla
        if (MAX == 0) System.out.println("There are no grades.");
        else {
            System.out.println("*************************");
            System.out.println("Show grades 2.");
            System.out.println("*************************");
            String b;
            System.out.println(
                    "Student    Grade   State    Name\n" +
                            "-------    ----    -----    -----");
            for (int i = 0; i < MAX; i++) {
                b = check(objets[i].mark); //metodo de comprobacion de nota, devuelve un String
                System.out.println((i + 1) + "          " + objets[i].mark + "     " + b + "    " + objets[i].name);
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

    public static void worstGrade() { //metodo que muestra las peores notas
        if (MAX == 0) System.out.println("There are no grades.");
        else {
            System.out.println("*************************");
            System.out.println("Show worst grade.");
            System.out.println("*************************");
            double min = 10;
            for (int i = 0; i < MAX; i++) { //primero recorre el array para seleccionar la nota mas baja
                if (objets[i].mark < min) {
                    min = objets[i].mark;
                }
            }
            for (int i = 0; i < MAX; i++) { //vuelve a recorrer el array e imprime aquellos con la nota mas baja
                if (min == objets[i].mark) {
                    System.out.println("Student: " + (i + 1) + ".");
                    System.out.println("Name: " + objets[i].name);
                    System.out.println("Grade: " + objets[i].mark);
                    System.out.println("");

                }
            }
        }
    }

    public static void percentage() { //metodo para aplicar el porcentaje
        if (MAX == 0) System.out.println("There are no grades.");
        else {
            double percentage;
            System.out.println("*************************");
            System.out.println("Percentages.");
            System.out.println("*************************");
            System.out.print("Insert the percentage that will increase the grade of all the students: ");
            percentage = scanner.nextDouble(); //se introduce el porcentaje que modificara a las notas
            for (int i = 0; i < MAX; i++) {
                objets[i].mark += (objets[i].mark * ((percentage / 100))); //se recorre y se modifican las notas en base al porcentaje
                if (objets[i].mark > 10) objets[i].mark = 10; //en caso de superar la nota MAXima, se reescribe como 10
                if (objets[i].mark < 0)
                    objets[i].mark = 0; //en caso de sacar una nota inferior a la minima, se reescribe como 0
            }
        }

    }

    public static void fillMatrix() { //metodo para rellenar la matriz
        System.out.println("*************************");
        System.out.println("Fill the matrix.");
        System.out.println("*************************");

        System.out.println("Please, insert the height (number of rows) and the width (number of columns) of the matrix: ");
        System.out.print("Rows: ");
        ROW = scanner.nextInt(); //insertamos el numero de filas
        System.out.print("Columns: ");
        COLUMN = scanner.nextInt(); //insertamos el numero de columnas

        matrix = new int[ROW][COLUMN]; //dimensionamos el array

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                System.out.println("Position: "); //nos muestra la posicion donde nos encontramos
                System.out.println("Row: " + (i + 1));
                System.out.println("Column: " + (j + 1));
                System.out.print("Insert value: ");
                matrix[i][j] = scanner.nextInt(); //introducimos el valor de la matriz
            }
        }
        checkMatrix = true; //comprobacion para saber si hemos creado el array
    }

    public static void showMatrix() { //metodo para mostrar la matriz
        if (checkMatrix) {
            System.out.println("*************************");
            System.out.println("Fill the matrix.");
            System.out.println("*************************");
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COLUMN; j++) { //muestra el array
                    System.out.print(matrix[i][j] + "\t ");
                }
                System.out.println("");
            }
        } else System.out.println("There is no matrix.");
    }

    public static void searchMatrix() { //metodo para buscar dentro de la matriz
        if (checkMatrix) {
            int showRow, showColumn;
            System.out.println("*************************");
            System.out.println("Search a value on the matrix.");
            System.out.println("*************************");
            System.out.print("Insert the row of the number: ");
            showRow = scanner.nextInt();
            System.out.print("Insert the column of the number: ");
            showColumn = scanner.nextInt();
            System.out.println("The value is " + matrix[showRow - 1][showColumn - 1]);
        } else System.out.println("There is no matrix.");
    }

    public static void modifyMatrix() { //metodo para modificar un valor dentro del array
        if (checkMatrix) {
            int chooseRow, chooseColumn, modify;
            System.out.println("*************************");
            System.out.println("Modify a value on the matrix.");
            System.out.println("*************************");
            System.out.print("Insert the row of the number: ");
            chooseRow = scanner.nextInt();
            System.out.print("Insert the column of the number: ");
            chooseColumn = scanner.nextInt();
            System.out.println("Current value: " + matrix[chooseRow][chooseColumn]);
            System.out.println("Insert the new value: ");
            modify = scanner.nextInt();
            matrix[chooseRow - 1][chooseColumn - 1] = modify;
        } else System.out.println("There is no matrix.");
    }

    public static void main(String[] args) {
        int a; //variable que nos permitira movernos dentro del switch
        System.out.println("*************************");
        System.out.println("Practica de Enrique Tamajon Castilla");
        System.out.println("*************************");
        do {
            a = menu();
            chooseMenu(a);
        } while (a != EXIT);
    }


}