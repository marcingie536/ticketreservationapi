package com.zaju.ticketreservationapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zaju.ticketreservationapi.entity.Event;
import com.zaju.ticketreservationapi.exception.EntityNotFoundException;
import com.zaju.ticketreservationapi.repository.EventRepository;

@Service
public class EventService implements IEventService {

	private EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public List<Event> getAll() {		
		return (List<Event>) eventRepository.findAll();
	}
	
	public Event getById(int id) {
		Optional<Event> event = eventRepository.findById(id);
		
		if(!event.isPresent()) {
			throw new EntityNotFoundException(Event.class.getSimpleName(), Integer.toString(id)); 
		}
		
		return event.get();
	}
	
	public Event save(Event event) {
		return eventRepository.save(event);
	}

}
