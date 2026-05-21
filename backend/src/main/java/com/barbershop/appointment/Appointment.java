package com.barbershop.appointment;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;


@Entity
public class Appointment {

    @Id
    @GeneratedValue
    private UUID id;

    private String barberId;
    private String time;

    public UUID getId() {
        return id;
    }

    public String getBarberId() {
        return barberId;
    }

    public void setBarberId(String barberId) {
        this.barberId = barberId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

