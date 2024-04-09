package org.experis.exercise;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event{
    //Attributi
    private LocalTime hour;
    private BigDecimal price;

    //Costruttore
    public Concert(String title, LocalDate data, int totalPlaces, LocalTime hour, BigDecimal price) throws IllegalArgumentException {
        // richiamo il costruttore della classe Event
        super(title, data, totalPlaces);
        // inizializzo l'attributo hour con il valore passato come parametro
        this.hour = hour;
        // verifico se il prezzo è negativo
        if(price.compareTo(BigDecimal.ZERO) < 0){
            // solleva un'eccezione se il prezzo è negativo
            throw new IllegalArgumentException("Il prezzo non può essere negativo");
        }
        // inizializzo l'attributo price con il valore passato come parametro
        this.price = price;
    }

    //Getter e Setter
    public LocalTime getHour(){
        return hour;
    }
    public void setHour(LocalTime hour){
        this.hour = hour;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price){
        // Verifica se il prezzo è negativo
        if(price.compareTo(BigDecimal.ZERO) < 0){
            // Solleva un'eccezione se il prezzo è negativo
            throw new IllegalArgumentException("Il prezzo non può essere negativo");
        }
        // Imposta il prezzo con il valore passato come parametro
        this.price = price;
    }

    // Metodo per formattare la data
    public String getDataFormatted(){
        // formatta la data nel formato specificato
        return getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    // Metodo per formattare l'ora
    public String getHourFormatted(){
        // formatta l'ora nel formato specificato
        return hour.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    // Metodo per formattare il prezzo
    public String getPriceFormatted(){
        // formatta il prezzo nel formato specificato
        return String.format("%.2f€", price);
    }

    @Override
    public String toString(){
        // Restituisce una stringa formattata con la data, l'orario, il titolo e il prezzo del concerto
        return getDataFormatted() + " - " + getHourFormatted() + " - " + getTitle() + " - " + getPriceFormatted();
    }
}
