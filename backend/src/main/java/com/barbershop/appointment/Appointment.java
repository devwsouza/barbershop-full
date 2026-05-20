package com.barbershop.appointment;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;

@Entity
public class Appointment {
 @Id public UUID id;
 public UUID barberId;
 public LocalDateTime startTime;
 public LocalDateTime endTime;
}
