package com.zaju.ticketreservationapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="ticket")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="create_date")
	private Date createDate;

	private double price;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_order")
	private Order order;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pool")
	private TicketPool ticketPool;

	public Ticket() {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public TicketPool getTicketPool() {
		return ticketPool;
	}

	public void setTicketPool(TicketPool ticketPool) {
		this.ticketPool = ticketPool;
	}
}