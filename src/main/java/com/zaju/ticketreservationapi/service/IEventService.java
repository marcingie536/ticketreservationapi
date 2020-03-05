package com.zaju.ticketreservationapi.service;

import java.util.List;

import com.zaju.ticketreservationapi.entity.Event;
import com.zaju.ticketreservationapi.exception.EntityNotFoundException;

public interface IEventService {

	public List<Event> getAll(int page, int size);
	public Event getById(int id) throws EntityNotFoundException;
	public Event save(Event event);
}
