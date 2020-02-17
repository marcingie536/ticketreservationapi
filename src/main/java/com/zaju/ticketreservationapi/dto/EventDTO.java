package com.zaju.ticketreservationapi.dto;

import java.util.Date;

public class EventDTO {
	private int id;
	private String category;
	private String city;
	private Double coordinateX;
	private Double coordinateY;
	private String country;
	private Date createDate;
	private String description;
	private Date evenDate;
	private boolean isHappened;
	private String name;
	private String number;
	private String object;
	private String street;
	private Date updateDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public double getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	}
	public double getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(double coordinateY) {
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
	public boolean getIsHappened() {
		return isHappened;
	}
	public void setIsHappened(boolean isHappened) {
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
}
