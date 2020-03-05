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
	private Integer id;

	@Column(name="create_date")
	private Date createDate;

	private String description;

	@Column(name="is_sold")
	private boolean isSold;

	private Double price;

	@Column(name="sold_tickets_number")
	private Integer soldTicketsNumber;

	@Column(name="tickets_number")
	private Integer ticketsNumber;
	
	@Column(name="pool_number")
	private Integer poolNumber;

	@OneToMany(mappedBy="ticketPool")
	private List<Ticket> tickets;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_event")
	private Event event;

	public TicketPool() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public boolean isSold() {
		return isSold;
	}

	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getSoldTicketsNumber() {
		return soldTicketsNumber;
	}

	public void setSoldTicketsNumber(Integer soldTicketsNumber) {
		this.soldTicketsNumber = soldTicketsNumber;
	}

	public Integer getTicketsNumber() {
		return ticketsNumber;
	}

	public void setTicketsNumber(Integer ticketsNumber) {
		this.ticketsNumber = ticketsNumber;
	}

	public Integer getPoolNumber() {
		return poolNumber;
	}

	public void setPoolNumber(Integer poolNumber) {
		this.poolNumber = poolNumber;
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

	@Override
	public String toString() {
		return "TicketPool [id=" + id + ", createDate=" + createDate + ", description=" + description + ", isSold="
				+ isSold + ", price=" + price + ", soldTicketsNumber=" + soldTicketsNumber + ", ticketsNumber="
				+ ticketsNumber + "]";
	}	
}