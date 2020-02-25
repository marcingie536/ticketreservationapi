package com.zaju.ticketreservationapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zaju.ticketreservationapi.dto.EventDTO;
import com.zaju.ticketreservationapi.entity.Event;
import com.zaju.ticketreservationapi.service.IEventService;

@RestController
@RequestMapping("/api/event")
public class EventController {

	private IEventService eventService;
	private ModelMapper modelMapper;

	public EventController(IEventService eventService, ModelMapper modelMapper) {
		this.eventService = eventService;
		this.modelMapper = modelMapper;
	}

	@GetMapping
	public ResponseEntity<List<EventDTO>> getAll() {
				
		List<Event> events =  eventService.getAll();
		List<EventDTO> eventsResult = events.stream().map(event -> modelMapper.map(event, EventDTO.class))
				.collect(Collectors.toList());
			
		return ResponseEntity.ok(eventsResult);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EventDTO> getById(@RequestParam int id) {
		Event event = eventService.getById(id);
		
		return ResponseEntity.ok(
				modelMapper.map(event, EventDTO.class));
	}
}
