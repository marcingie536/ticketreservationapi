package com.zaju.ticketreservationapi.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TicketPoolDTO {
	private Integer id;
	private Date createDate;
	@NotEmpty
	private String description;
	private boolean isSold;
	@NotNull
	private Double price;
	private Integer soldTicketsNumber;
	@NotNull
	private Integer ticketsNumber;
	@NotNull
	private Integer poolNumber;
	@NotNull
	private Integer idEvent;
	
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
	public Integer getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(Integer idEvent) {
		this.idEvent = idEvent;
	}
}
