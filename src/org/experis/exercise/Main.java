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
        int totalPlaces = Integer.parseInt(scanner.nextLine());
        System.out.println("=======================");

        // Crea l'evento
        Event event;
        try {
            // istanzio un nuovo evento
            event = new Event(title, data, totalPlaces);
        } catch (IllegalArgumentException e) {
            // gestisco l'eccezione se i parametri non sono validi
            System.out.println("Errore: " + e.getMessage());
            return;
        }

        // chiedo all'utente se vuole prenotare
        System.out.print("Vuoi effettuare una prenotazione? (s/n):");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("s")){
            System.out.print("Quanti posti vuoi prenotare? ");
            int numberReservations = scanner.nextInt();
            try{
                // effetuo la prenotazione
                event.bookEvent(numberReservations);
                System.out.println("PRENOTAZIONE EFFETTUATA CON SUCCESSO ");
                // gestisco l'eccezione se la prenotazione non è possibile
            } catch(IllegalArgumentException e){
                System.out.println("Errore " + e.getMessage());
            }
        }
        scanner.nextLine();
        // stampo il numero di posti prenotati e disponibili con titolo e data dell'evento
        System.out.println("EVENTO: " + event.getTitle());
        System.out.println("DATA: " + event.getData());
        System.out.println("Posti prenotati: " + event.getReservedPlaces());
        System.out.println("Posti disponibili: " + (event.getTotalPlaces() - event.getReservedPlaces()));
        System.out.println("=======================");


        // chiedo all'utente se vuole disdire
        System.out.print("Vuoi disdire una prenotazione? (s/n): ");
        answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("s")) {
            System.out.print("Quanti posti vuoi disdire? ");
            int numberCancel = scanner.nextInt();
            try {
                // effettuo la disdetta
                event.cancelEvent(numberCancel);
                System.out.println("DISDETTA EFFETTUATA CON SUCCESSO");
                // gestisco l'eccezione se la disdetta non è possibile
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }


        // stampo il numero di posti prenotati e disponibili dopo la disdetta con titolo e data dell'evento
        System.out.println("EVENTO: " + event.getTitle());
        System.out.println("DATA: " + event.getData());
        System.out.println("Posti prenotati dopo la disdetta: " + event.getReservedPlaces());
        System.out.println("Posti disponibili dopo la disdetta: " + (event.getTotalPlaces() - event.getReservedPlaces()));
        System.out.println("=======================");

        // chiudo lo scanner
        scanner.close();

    }
}
