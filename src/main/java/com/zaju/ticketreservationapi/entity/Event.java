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

@Entity(name="event")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String category;

	private String city;

	@Column(name="coordinate_x")
	private double coordinateX;

	@Column(name="coordinate_y")
	private double coordinateY;

	private String country;

	@Column(name="create_date")
	private Date createDate;

	private String description;

	@Column(name="even_date")
	private Date evenDate;

	@Column(name="is_happened")
	private byte isHappened;

	private String name;

	private String number;

	private String object;

	private String street;

	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to Organizer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_organizer")
	private Organizer organizer;

	//bi-directional many-to-one association to TicketPool
	@OneToMany(mappedBy="event")
	private List<TicketPool> ticketPools;

	public Event() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getCoordinateX() {
		return this.coordinateX;
	}

	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public double getCoordinateY() {
		return this.coordinateY;
	}

	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEvenDate() {
		return this.evenDate;
	}

	public void setEvenDate(Date evenDate) {
		this.evenDate = evenDate;
	}

	public byte getIsHappened() {
		return this.isHappened;
	}

	public void setIsHappened(byte isHappened) {
		this.isHappened = isHappened;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getObject() {
		return this.object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Organizer getOrganizer() {
		return this.organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public List<TicketPool> getTicketPools() {
		return this.ticketPools;
	}

	public void setTicketPools(List<TicketPool> ticketPools) {
		this.ticketPools = ticketPools;
	}

	public TicketPool addTicketPool(TicketPool ticketPool) {
		getTicketPools().add(ticketPool);
		ticketPool.setEvent(this);

		return ticketPool;
	}

	public TicketPool removeTicketPool(TicketPool ticketPool) {
		getTicketPools().remove(ticketPool);
		ticketPool.setEvent(null);

		return ticketPool;
	}

}