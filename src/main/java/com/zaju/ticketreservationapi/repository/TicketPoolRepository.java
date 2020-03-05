package com.zaju.ticketreservationapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zaju.ticketreservationapi.entity.TicketPool;

@Repository
public interface TicketPoolRepository extends CrudRepository<TicketPool, Integer> {
	public List<TicketPool> findByEventId(int eventId);
}
