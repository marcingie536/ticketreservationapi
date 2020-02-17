package com.zaju.ticketreservationapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zaju.ticketreservationapi.entity.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer>{

}
