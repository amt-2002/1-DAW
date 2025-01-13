package Ejercicio_repaso;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
        String ciudad1, ciudad2, ciudad3;

        System.out.print("Introduce el nombre de la ciudad 1: ");
        ciudad1 = scanner.nextLine();
        System.out.print("Introduce el nombre de la ciudad 2: ");
        ciudad2 = scanner.nextLine();
        System.out.print("Introduce el nombre de la ciudad 3: ");
        ciudad3 = scanner.nextLine();

        String ciudadMenor, ciudadMediana, ciudadMayor;

        if (ciudad1.length() <= ciudad2.length() && ciudad1.length() <= ciudad3.length()) {
            ciudadMenor = ciudad1;
            if (ciudad2.length() <= ciudad3.length()) {
                ciudadMediana = ciudad2;
                ciudadMayor = ciudad3;
            } else {
                ciudadMediana = ciudad3;
                ciudadMayor = ciudad2;
            }
        } else if (ciudad2.length() <= ciudad1.length() && ciudad2.length() <= ciudad3.length()) {
            ciudadMenor = ciudad2;
            if (ciudad1.length() <= ciudad3.length()) {
                ciudadMediana = ciudad1;
                ciudadMayor = ciudad3;
            } else {
                ciudadMediana = ciudad3;
                ciudadMayor = ciudad1;
            }
        } else {
            ciudadMenor = ciudad3;
            if (ciudad1.length() <= ciudad2.length()) {
                ciudadMediana = ciudad1;
                ciudadMayor = ciudad2;
            } else {
                ciudadMediana = ciudad2;
                ciudadMayor = ciudad1;
            }
        }

        System.out.println(ciudadMenor);
        System.out.println(ciudadMediana);
        System.out.println(ciudadMayor);

        scanner.close();
	}

}
