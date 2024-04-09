package org.experis.exercise;

import java.time.LocalDate;

public class Event {
    // Attributi
    private String title;
    private LocalDate data;
    private int totalPlaces;
    private int reservedPlaces;

    //Costruttore
    public Event(String title, LocalDate data, int totalPlaces) throws IllegalArgumentException{
        // Controlla se la data dell'evento è precedente alla data odierna
        if (data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La data dell'evento è già passata");
        }
        // Controlla se il numero totale di posti è minore o uguale a zero
        if(totalPlaces <= 0){
            throw new IllegalArgumentException("Il numero dei posti deve essere positivo");
        }
        // Inizializza i campi della classe con i valori forniti
        this.title = title;
        this.data = data;
        this.totalPlaces = totalPlaces;
        this.reservedPlaces = 0;
    }


    // Getter e Setter
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public LocalDate getData(){
        return data;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public int getTotalPlaces(){
        return totalPlaces;
    }

    public void setTotalPlaces(int totalPlaces){
        this.totalPlaces = totalPlaces;
    }

    public int getReservedPlaces(){
        return reservedPlaces;
    }

    public void setReservedPlaces(int reservedPlaces){
        this.reservedPlaces = reservedPlaces;
    }

    // Metodo per poter prenotare un posto
    public void prenota(int numberPlaces) throws IllegalStateException{
        // controllo se la data è precedente alla data odierna
        if(data.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Impossibile prenotare per un evento passato");
        }
        // controllo se il numero dei posti prenotati più il numero dei posti richiesti supera il totale dei posti disponibili
        if(reservedPlaces + numberPlaces > totalPlaces){
            throw new IllegalStateException("Posti esauriti per questo evento");
        }
        // aggiorno il numero dei posti prenotati
        reservedPlaces += numberPlaces;
    }

    // Metodo per poter disdire un posto
    public void disdici(int numberPlaces) throws IllegalStateException{
        // controllo se la data è precedente alla data odierna
        if(data.isBefore(LocalDate.now())){
            throw new IllegalStateException("Impossibile disdire per un evento passato");
        }
        // controllo se il numero di posti prenotati meno il numero di posti da disdire è inferiore a zero
        if(reservedPlaces - numberPlaces < 0){
            throw new IllegalStateException("Non ci sono abbsatanza prenotazioni da disdire");
        }
        // aggiorno il numero di posti prenotati
        reservedPlaces -= numberPlaces;
    }

    @Override
    public String toString(){
        // Restituisce una stringa rappresentante la data e il titolo dell'evento
        return data.toString() + " - " + title;
    }
}
