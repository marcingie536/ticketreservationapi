package com.zaju.ticketreservationapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaju.ticketreservationapi.dto.TicketPoolDTO;
import com.zaju.ticketreservationapi.entity.TicketPool;
import com.zaju.ticketreservationapi.service.ITicketPoolService;

@RestController
@RequestMapping("/api/ticket-pool")
public class TicketPoolController {
	
	private ITicketPoolService ticketPoolService;
	private ModelMapper modelMapper;
	
	public TicketPoolController(ITicketPoolService ticketPoolService, ModelMapper modelMapper) {
		this.ticketPoolService = ticketPoolService;
		this.modelMapper = modelMapper;
	}

	@GetMapping("/event/{eventId}")
	public ResponseEntity<List<TicketPoolDTO>> getByEventId(@PathVariable int eventId) {
		
		List<TicketPool> ticketPools = ticketPoolService.getByEventId(eventId);
		
		List<TicketPoolDTO> ticketPoolsResult = ticketPools.stream()
				.map(ticketPool -> modelMapper.map(ticketPool, TicketPoolDTO.class)).collect(Collectors.toList());
		
		return ResponseEntity.ok(ticketPoolsResult);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TicketPoolDTO> getById(@PathVariable int id) {
		TicketPool ticketPool = ticketPoolService.getById(id);
		
		return ResponseEntity.ok(
				modelMapper.map(ticketPool, TicketPoolDTO.class));
	}
	
	@PostMapping
	public ResponseEntity<TicketPoolDTO> addTicketPool(@RequestBody @Valid TicketPoolDTO ticketPool) {
		TicketPool newTicketPool = modelMapper.map(ticketPool, TicketPool.class);
		
		ticketPoolService.createTicketPool(newTicketPool);
		
		return new ResponseEntity<>(modelMapper.map(newTicketPool, TicketPoolDTO.class), HttpStatus.CREATED);
	}
	
}
