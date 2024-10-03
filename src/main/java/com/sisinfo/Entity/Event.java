package com.sisinfo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    private EventType event;

    @Getter
    @Setter
    @ManyToOne
    private Calendar calendar;

    enum EventType {
        Festivita,
        Permesso,
        Ferie,
        Malattia,
        Lutto,
        Natalita,
    }

}
