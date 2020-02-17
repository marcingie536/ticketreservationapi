package com.zaju.ticketreservationapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zaju.ticketreservationapi.entity.Event;
import com.zaju.ticketreservationapi.repository.EventRepository;

@Service
public class EventService implements IEventService {

	private EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	@Override
	public List<Event> getAll() {
		List<Event> huj = (List<Event>) eventRepository.findAll();
		
		return huj;
	}

}
