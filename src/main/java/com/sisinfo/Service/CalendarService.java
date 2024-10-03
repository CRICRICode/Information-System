package com.sisinfo.Service;

import com.sisinfo.Entity.Calendar;
import com.sisinfo.Repository.CalendarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {
    private CalendarRepository calendarRepository;

    @Autowired
    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public Calendar createEvent(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    public void deleteEvent(Long id) {
        calendarRepository.deleteById(id);
    }

    public List<Calendar> getAllEvents() {
        return calendarRepository.findAll();
    }
}
