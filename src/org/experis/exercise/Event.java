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
        if (data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La data dell'evento è già passata");
        }
        if(totalPlaces <= 0){
            throw new IllegalArgumentException("Il numero dei posti deve essere positivo");
        }
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


}
