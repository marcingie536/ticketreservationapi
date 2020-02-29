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
	private Integer id;

	private String category;

	private String city;

	@Column(name="coordinate_x")
	private Double coordinateX;

	@Column(name="coordinate_y")
	private Double coordinateY;

	private String country;

	@Column(name="create_date")
	private Date createDate;

	private String description;

	@Column(name="even_date")
	private Date evenDate;

	@Column(name="is_happened")
	private boolean isHappened;

	private String name;

	private String number;

	private String object;

	private String street;

	@Column(name="update_date")
	private Date updateDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_organizer")
	private Organizer organizer;

	@OneToMany(mappedBy="event")
	private List<TicketPool> ticketPools;

	public Event() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(Double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public Double getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(Double coordinateY) {
		this.coordinateY = coordinateY;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public Date getEvenDate() {
		return evenDate;
	}

	public void setEvenDate(Date evenDate) {
		this.evenDate = evenDate;
	}

	public boolean isHappened() {
		return isHappened;
	}

	public void setHappened(boolean isHappened) {
		this.isHappened = isHappened;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public List<TicketPool> getTicketPools() {
		return ticketPools;
	}

	public void setTicketPools(List<TicketPool> ticketPools) {
		this.ticketPools = ticketPools;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", category=" + category + ", city=" + city + ", coordinateX=" + coordinateX
				+ ", coordinateY=" + coordinateY + ", country=" + country + ", createDate=" + createDate
				+ ", description=" + description + ", evenDate=" + evenDate + ", isHappened=" + isHappened + ", name="
				+ name + ", number=" + number + ", object=" + object + ", street=" + street + ", updateDate="
				+ updateDate + ", organizer=" + organizer + ", ticketPools=" + ticketPools + "]";
	}
}