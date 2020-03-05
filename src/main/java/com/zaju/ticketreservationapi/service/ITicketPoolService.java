package com.zaju.ticketreservationapi.service;

import java.util.List;

import com.zaju.ticketreservationapi.entity.TicketPool;

public interface ITicketPoolService {
	public TicketPool getById(int id);
	public List<TicketPool> getByEventId(int eventId);
	public TicketPool createTicketPool(TicketPool ticketPool);
}
