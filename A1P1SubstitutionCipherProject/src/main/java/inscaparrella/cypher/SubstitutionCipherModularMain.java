package inscaparrella.cypher;
/*
Júlia Carulla
Julio Bravo
*/

import java.util.Scanner;

public class SubstitutionCipherModularMain {
    static final String ALFABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {

        String clau, alfabetXifrat, input, resultat;
        Scanner keyboard = new Scanner(System.in);
        int menu;

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
                    alfabetXifrat = SubstitutionCipherModularMain.creadorAlfabet(clau);

                    System.out.println("Quin text vols xifrar?");
                    input = keyboard.nextLine().toUpperCase();
                    resultat = SubstitutionCipherModularMain.xifratge(input, alfabetXifrat, ALFABET);

                    System.out.println("El resultat del xifratge és: " + resultat);
                    break;

                case 2:
                    System.out.println("siusplau, introdueixi la paraula clau que es va utilitzar per xifrar el text:  ");
                    clau = keyboard.next().toUpperCase();
                    keyboard.nextLine();

                    clau = clau + ALFABET;

                    alfabetXifrat = SubstitutionCipherModularMain.creadorAlfabet(clau);

                    System.out.println("Quin text vols desxifrar?");
                    input = keyboard.nextLine().toUpperCase();

                    resultat = SubstitutionCipherModularMain.desxifratge(input, alfabetXifrat, ALFABET);
                    System.out.println("El resultat del xifratge és: " + resultat);
                    break;
                default:
                    System.out.println("Opció incorrecta. Introdueix de nou la opció");
            }
            System.out.println("Prem enter per continuar.");
            keyboard.nextLine();

        } while (menu != 0);
    }

    static String creadorAlfabet(String clau) {
        char lletra;
        String alfabetXifrat = "";

        for (int i = 0; i <= clau.length() - 1; i++) {
            lletra = clau.charAt(i);
            if (!alfabetXifrat.contains(String.valueOf(lletra))) {
                alfabetXifrat += lletra + "";
            }
        }
        return alfabetXifrat;
    }

    static String xifratge(String input, String alfabetXifrat, final String ALFABET) {
        char lletra;
        int posicio;
        String resultat = "";


        for (int i = 0; i <= input.length() - 1; i++) {
            lletra = input.charAt(i);
            posicio = ALFABET.indexOf(lletra);
            if (posicio != -1) {
                resultat += alfabetXifrat.charAt(posicio);
            }
        }
        return resultat;
    }

    static String desxifratge(String input, String alfabetXifrat, String ALFABET) {
        char lletra;
        int posicio;
        String resultat = "";

        for (int i = 0; i <= input.length() - 1; i++) {
            lletra = input.charAt(i);
            posicio = alfabetXifrat.indexOf(lletra);
            if (posicio != -1) {
                resultat += ALFABET.charAt(posicio);
            }
        }
        return resultat;

    }
}
