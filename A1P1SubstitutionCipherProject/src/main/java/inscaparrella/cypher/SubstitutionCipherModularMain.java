package inscaparrella.cypher;
/*
Júlia Carulla
Julio Bravo
*/

import java.util.Scanner;

public class SubstitutionCipherModularMain {
    public static void main(String[] args) {

        final String ALFABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String clau, alfabetXifrat = "", input, resultat = "";
        char l;
        Scanner keyboard = new Scanner(System.in);
        int menu, comptador = 0, posicio;

        do {
            System.out.println("Menú");
            System.out.println("0. Sortir");
            System.out.println("1. Xifrar un text");
            System.out.println("2. Desxifrar un text");
            menu = keyboard.nextInt();
            keyboard.nextLine();;

            switch (menu) {
                case 0:
                    System.out.println("Sortint del programa.");
                    break;

                case 1:
                    System.out.println("Si us plau, introdueix la paraula clau: ");
                    clau = keyboard.next().toUpperCase();
                    keyboard.nextLine();
                    clau += ALFABET;
                    comptador = 0;
                    alfabetXifrat = "";
                    resultat = "";

                    while (comptador <= clau.length() - 1) {
                        l = clau.charAt(comptador);
                        if (!alfabetXifrat.contains(String.valueOf(l))) {
                            alfabetXifrat += l + "";
                        }
                        comptador++;
                    }

                    System.out.println("Quin text vols xifrar?");
                    input = keyboard.nextLine().toUpperCase();

                    while (comptador <= input.length() - 1) {
                        l = input.charAt(comptador);
                        posicio = ALFABET.indexOf(l);
                        if (posicio != -1) {
                            resultat += alfabetXifrat.charAt(posicio);
                        }
                        comptador++;
                    }

                    System.out.println("El resultat del xifratge és: " + resultat);
                    break;
                    
                case 2:
                    System.out.println("siusplau, introdueixi la paraula clau que es va utilitzar per xifrar el text:  ");
                    clau = keyboard.next().toUpperCase();
                    keyboard.nextLine();
                    clau = clau + ALFABET;
                    comptador = 0;
                    alfabetXifrat = "";
                    resultat = "";


                    while (comptador <= clau.length() - 1) {
                        l = clau.charAt(comptador);
                        if (!alfabetXifrat.contains(String.valueOf(l))) {
                            alfabetXifrat += l + "";
                        }
                        comptador++;
                    }

                    System.out.println("Quin text vols desxifrar?");
                    input = keyboard.nextLine().toUpperCase();
                    System.out.println(alfabetXifrat);

                    while (comptador <= input.length() - 1) {
                        l = input.charAt(comptador);
                        posicio = alfabetXifrat.indexOf(l);
                        if (posicio != -1) {
                            resultat += ALFABET.charAt(posicio);
                        }
                        comptador++;
                    }

                    System.out.println("El resultat del xifratge és: " + resultat);

                    break;
                default:
                    System.out.println("Opció incorrecta. Introdueix de nou la opció");
            }
            System.out.println("Prem enter per continuar.");
            keyboard.nextLine();

        } while (menu != 0);
    }
}
