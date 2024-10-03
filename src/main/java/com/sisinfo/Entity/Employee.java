package com.sisinfo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    // Aggiungi gli attributi necessari per l'entità Employee

    @Getter
    @Setter
    private double baseSalary;

    @Getter
    @Setter
    private int workedHours;

    @Getter
    @Setter
    private int vacationHours;

    @Getter
    @Setter
    private int permissionHours;


    public Long getId() {
        return id;
    }


}
