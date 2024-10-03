package com.sisinfo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Entity
public class CalendarEvent {
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
}
