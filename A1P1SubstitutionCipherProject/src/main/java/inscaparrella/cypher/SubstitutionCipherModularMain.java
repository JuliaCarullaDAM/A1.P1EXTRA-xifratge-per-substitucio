package inscaparrella.cypher;
/*
Júlia Carulla
Julio Bravo
*/

import java.util.Scanner;

public class SubstitutionCipherModularMain {
    public static void main(String[] args) {

        final String ALFABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String clau, alfabetXifrat, input, resultat;
        Scanner keyboard = new Scanner(System.in);
        int menu, comptador, posicio;

        do {
            System.out.println("Menú");
            System.out.println("0. Sortir");
            System.out.println("1. Xifrar un text");
            System.out.println("2. Desxifrar un text");
            menu = keyboard.nextInt();
            keyboard.nextLine();

            switch (menu) {
                case 0:
                    System.out.println("Sortint del programa.");
                    break;

                case 1:
                    System.out.println("Si us plau, introdueix la paraula clau: ");
                    clau = keyboard.next().toUpperCase();
                    keyboard.nextLine();

                    clau += ALFABET;
                    alfabetXifrat = "";

                    SubstitutionCipherModularMain.creadorAlfabet(clau, alfabetXifrat);

                    System.out.println("Quin text vols xifrar?");
                    input = keyboard.nextLine().toUpperCase();
                    resultat = "";

                    SubstitutionCipherModularMain.xifratge(input, resultat, alfabetXifrat, ALFABET);

                    System.out.println("El resultat del xifratge és: " + resultat);
                    break;

                case 2:
                    System.out.println("siusplau, introdueixi la paraula clau que es va utilitzar per xifrar el text:  ");
                    clau = keyboard.next().toUpperCase();
                    keyboard.nextLine();
                    clau = clau + ALFABET;
                    comptador = 0;
                    alfabetXifrat = "";

                    while (comptador <= clau.length() - 1) {
                        lletra = clau.charAt(comptador);
                        if (!alfabetXifrat.contains(String.valueOf(lletra))) {
                            alfabetXifrat += lletra + "";
                        }
                        comptador++;
                    }

                    System.out.println("Quin text vols desxifrar?");
                    input = keyboard.nextLine().toUpperCase();
                    comptador = 0;
                    resultat = "";

                    while (comptador <= input.length() - 1) {
                        lletra = input.charAt(comptador);
                        posicio = alfabetXifrat.indexOf(lletra);
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

    static void creadorAlfabet(String clau, String alfabetXifrat) {
        char lletra;

        for (int i = 0; i <= clau.length() - 1; i++) {
            lletra = clau.charAt(i);
            if (!alfabetXifrat.contains(String.valueOf(lletra))) {
                alfabetXifrat += lletra + "";
            }
        }
    }

    static void xifratge(String input, String resultat, String alfabetXifrat, String ALFABET) {
        char lletra;
        int posicio;

        for (int i = 0; i <= input.length() - 1; i++) {
            lletra = input.charAt(i);
            posicio = ALFABET.indexOf(lletra);
            if (posicio != -1) {
                resultat += alfabetXifrat.charAt(posicio);
            }
        }
    }
}
