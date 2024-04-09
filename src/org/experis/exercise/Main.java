package org.experis.exercise;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // chiedo all'utente di inserire i dettagli dell'evento
        System.out.println("Inserisci i dati dell'evento: ");
        System.out.print("Titolo: ");
        String title = scanner.nextLine();
        System.out.print("Data (AAAA-MM-GG): ");
        // converto la data inserita in un oggetto LocalDate
        LocalDate data = LocalDate.parse(scanner.nextLine());
        System.out.print("Numero di posti totali: ");
        int totalPlaces = scanner.nextInt();

        // chiudo lo scanner
        scanner.close();

    }
}
