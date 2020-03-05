package com.zaju.ticketreservationapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zaju.ticketreservationapi.entity.TicketPool;
import com.zaju.ticketreservationapi.exception.EntityNotFoundException;
import com.zaju.ticketreservationapi.repository.TicketPoolRepository;

@Service
public class TicketPoolService implements ITicketPoolService{

	private TicketPoolRepository ticketPoolRepository;
	
	public TicketPoolService(TicketPoolRepository ticketPoolRepository) {
		this.ticketPoolRepository = ticketPoolRepository;
	}
	
	public TicketPool getById(int id) {
		Optional<TicketPool> ticketPoolOptional = ticketPoolRepository.findById(id);
		
		if(!ticketPoolOptional.isPresent()) {
			throw new EntityNotFoundException(TicketPool.class.getSimpleName(), Integer.toString(id));
		}
		
		return ticketPoolOptional.get();
	}

	public List<TicketPool> getByEventId(int eventId) {
		return ticketPoolRepository.findByEventId(eventId);
	}

	public TicketPool createTicketPool(TicketPool ticketPool) {
		ticketPool.setSoldTicketsNumber(0);
		return ticketPoolRepository.save(ticketPool);
	}

}
