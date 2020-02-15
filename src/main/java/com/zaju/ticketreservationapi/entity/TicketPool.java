package com.zaju.ticketreservationapi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="ticket_pool")
public class TicketPool implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="create_date")
	private Date createDate;

	private String description;

	@Column(name="is_sold")
	private boolean isSold;

	private double price;

	@Column(name="sold_tickets_number")
	private int soldTicketsNumber;

	@Column(name="tickets_number")
	private int ticketsNumber;

	@OneToMany(mappedBy="ticketPool")
	private List<Ticket> tickets;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_event")
	private Event event;

	public TicketPool() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsSold() {
		return isSold;
	}

	public void setIsSold(boolean isSold) {
		this.isSold = isSold;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSoldTicketsNumber() {
		return soldTicketsNumber;
	}

	public void setSoldTicketsNumber(int soldTicketsNumber) {
		this.soldTicketsNumber = soldTicketsNumber;
	}

	public int getTicketsNumber() {
		return ticketsNumber;
	}

	public void setTicketsNumber(int ticketsNumber) {
		this.ticketsNumber = ticketsNumber;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}