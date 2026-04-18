package com.example.urlshortener.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class URLEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String longURLString;
	
	private String shortCodeString;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLongURLString() {
		return longURLString;
	}

	public void setLongURLString(String longURLString) {
		this.longURLString = longURLString;
	}

	public String getShortCodeString() {
		return shortCodeString;
	}

	public void setShortCodeString(String shortCodeString) {
		this.shortCodeString = shortCodeString;
	}
}
