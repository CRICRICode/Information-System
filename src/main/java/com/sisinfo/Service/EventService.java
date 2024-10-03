package com.sisinfo.Service;

import com.sisinfo.Entity.Event;
import com.sisinfo.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        return optionalEvent.orElse(null);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.setEvent(updatedEvent.getEvent());
            event.setCalendar(updatedEvent.getCalendar());
            return eventRepository.save(event);
        }
        return null;
    }

    public void deleteEvent(Long id) {
            eventRepository.deleteById(id);
    }
}

