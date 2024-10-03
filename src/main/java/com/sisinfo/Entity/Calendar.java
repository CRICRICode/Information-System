package com.sisinfo.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

// Si divde in giorni in base alla data corrente, ci sono festa, ferie, permesso, giorno lavorativo.

@Data
@Entity
public class Calendar {
    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private LocalDateTime startDateTime;

    @Getter
    @Setter
    private LocalDateTime endDateTime;

    @OneToOne
    private Event event;

    public Calendar(){}
    public Calendar(String title, LocalDateTime startDateTime, LocalDateTime endDateTime, Event event) {
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.event = event;
    }

}
