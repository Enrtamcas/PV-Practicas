import java.util.Scanner;

public class Prac4 {
    public static void main(String[] args) {

        int opcion, n, temperatura, contador1, azar, elegir, x, tabla;
        contador1 = 0;
        double agua, contador;
        contador = 0;
        final double t1 = 0.15;//1º tramo de precio de agua
        final double t2 = 0.20;//2º tramo de precio de agua
        final double t3 = 0.35;//3º tramo de precio de agua
        final double t4 = 0.80;//4º tramo de precio de agua
        boolean comprobar = false; //bandera a modo de error
        boolean comprobar2 = false;//bandera a modo de error
        boolean comprobar3 = false;//bandera a modo de error
        boolean acierto = true;//bandera para comprobar numero azar
        Scanner entrada = new Scanner(System.in);

        System.out.println("**************************************");
        System.out.println("Nombre: Enrique      Apellido1: Tamajón     Apellido2: Castilla");
        System.out.println("**************************************");
        System.out.println("¡Buenos días! Con este programa, podrá realizar las siguientes acciones:");

        do {

            System.out.println("");
            System.out.println("1 ->Calcular el consumo del agua");
            System.out.println("2 ->Calcular la temperatura");
            System.out.println("3 ->Jugar al adivino");
            System.out.println("4 ->Mostrar la tabla de multiplicar al revés");
            System.out.println("5 ->Salir");
            System.out.println("A continuación, introduzca que desea hacer: ");
            opcion = entrada.nextInt();

            while (comprobar2 == false) {
                if ((opcion <= 0) || (opcion > 5)) {
                    System.out.println("Número introducido no válido, por favor, introduzca otro valor:");
                    opcion = entrada.nextInt();
                } else {
                    comprobar2 = true;
                }
            }

            switch (opcion) {
                case 1: {
                    System.out.println("**************************************");
                    System.out.println("PRECIO DEL AGUA");
                    System.out.println("**************************************");

                    System.out.println("Por favor, introduzca la cantidad de metros cúbicos que ha consumido:");
                    agua = entrada.nextDouble();

                    if (agua <= 100) {
                        System.out.println("Usted se encuentra en el 1º tramo.");
                        System.out.printf("El precio total asciende hasta los %.1f €", ((agua * t1)));
                    } else if (agua > 100 && agua <= 600) {
                        System.out.println("Usted se encuentra en el 2º tramo.");
                        System.out.printf("El precio total asciende hasta los %.1f €", (((agua - 100) * t2) + (100 * t1)));
                    } else if (agua > 600 && agua <= 1100) {
                        System.out.println("Usted se encuentra en el 3º tramo.");
                        System.out.printf("El precio total asciende hasta los %.1f €", (((agua - 600) * t3) + ((500 * t2) + (100 * t1))));
                    } else if (agua > 1100) {
                        System.out.println("Usted se encuentra en el 4º tramo.");
                        System.out.printf("El precio total asciende hasta los %.1f €", (((agua - 1100) * t4) + (((500) * t3) + ((500 * t2) + (100 * t1)))));
                    }

                    System.out.println("");
                    break;
                }
                case 2: {

                    System.out.println("**************************************");
                    System.out.println("TEMPERATURAS");
                    System.out.println("**************************************");

                    System.out.println("Introduzca las veces que ha medido la temperatura:");
                    n = entrada.nextInt();
                    for (int i = 1; i <= n; i = i + 1) {
                        System.out.println("Por favor, introduzca la " + i + "º temperatura.");
                        temperatura = entrada.nextInt();
                        contador = temperatura + contador;
                        if (temperatura < 0)
                            contador1 = contador1 + 1;
                    }

                    System.out.println("La media de temperaturas es de: " + (contador / n) + "º");
                    System.out.println("Total de temperaturas bajo cero: " + contador1);

                    System.out.println("");
                    break;
                }
                case 3: {

                    System.out.println("**************************************");
                    System.out.println("ADIVINO");
                    System.out.println("**************************************");

                    azar = (int) ((Math.random() * 100) + 1);
                    x = 7;

                    System.out.println("Se ha seleccionado un número al azar. ¡Hora de jugar!");

                    do {
                        System.out.println("Te queda(n) " + x + " intento(s)");
                        x = x - 1;
                        System.out.println("Elige un número: ");
                        elegir = entrada.nextInt();
                        if (elegir == azar) {
                            System.out.println("¡Usted ha adivinado el número, enhorabuena!");
                            acierto = false;
                        } else if (elegir < azar) {
                            System.out.println("El número que ha seleccionado es menor.");

                            if (elegir > azar - 10) {
                                System.out.println("Usted se está acercando.");
                            } else {
                                if (elegir > azar - 20) {
                                    System.out.println("Usted no está muy cerca.");
                                } else {
                                    if (elegir > azar - 30) {
                                        System.out.println("Usted está bastante lejos.");
                                    }
                                }
                            }
                        } else if (elegir > azar) {
                            System.out.println("El numero que ha seleccionado es mayor.");
                            if (elegir < azar + 10) {
                                System.out.println("Usted se está acercando.");
                            } else {
                                if (elegir < azar + 20) {
                                    System.out.println("Usted no está muy cerca.");
                                } else {
                                    if (elegir < azar + 30) {
                                        System.out.println("Usted está bastante lejos.");
                                    }
                                }
                            }
                        }
                    }
                    while ((x > 0) && (acierto == true));


                    System.out.println("");
                    break;
                }
                case 4: {
                    System.out.println("**************************************");
                    System.out.println("MULTIPLICADOR");
                    System.out.println("**************************************");
                    System.out.println("Introduzca que tabla de multiplicar desea ver: ");
                    tabla = entrada.nextInt();
                    do {
                        if ((tabla <= 0) || (tabla > 10)) {
                            System.out.println("Número introducido no válido, por favor, introduzca otro valor:");
                            tabla = entrada.nextInt();
                        } else {
                            comprobar3 = true;
                        }
                    }
                    while (comprobar3 == false);

                    for (int y = 10; y >= 0; y--) {
                        System.out.println(y + " * " + tabla + " = " + (y * tabla));
                    }
                    System.out.println("");
                    break;
                }
                case 5: {
                    System.out.println("Fin del programa");
                    comprobar = true;
                    System.out.println("");
                    break;
                }

            }
        }
        while (comprobar == false);
    }
}
