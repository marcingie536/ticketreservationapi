package com.zaju.ticketreservationapi.service;

import java.util.List;

import com.zaju.ticketreservationapi.entity.Event;
import com.zaju.ticketreservationapi.exception.EntityNotFoundException;

public interface IEventService {

	public List<Event> getAll();
	public Event getById(int id) throws EntityNotFoundException;
}
