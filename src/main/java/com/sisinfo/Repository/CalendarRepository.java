package com.sisinfo.Repository;

import com.sisinfo.Entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    // Aggiungi eventuali metodi personalizzati per le operazioni sul repository del calendario
}
