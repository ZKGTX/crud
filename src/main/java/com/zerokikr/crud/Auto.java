package com.zerokikr.crud;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "autos")
public class Auto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column (name = "model")
	private String model;
	
	
	@Column (name = "color")
	private String color;
	
	
	@ManyToOne(fetch = FetchType.LAZY) // многим Auto соответствует один User 
	@JoinColumn(name = "user_id")	// @JoinColumn указывает, через какой столбец в таблице autos происходит связь с таблицей users (через FOREIGN KEY)
	private User user;				// FetchType указывает, будут ли загружаться все Autos, относящиеся к конкретному User, при его загрузке. LAZY - не будут (только при необходимости, после вызова getAutos())
	
	
	@ManyToMany
	@JoinTable(
			name = "autos_x_racers",
			joinColumns = @JoinColumn(name = "auto_id"),
			inverseJoinColumns = @JoinColumn(name = "racer_id")
			)
	private List<Racer>racers;
	
	public Auto() {
		
	}

	public Auto(String model, String color) {
		this.model = model;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public List<Racer> getRacers() {
		return racers;
	}

	public void setRacers(List<Racer> racers) {
		this.racers = racers;
	}

	

	@Override
	public String toString() {
		return "Auto [model=" + model + ", color=" + color + "]";
	}
	
	
	
	
	
	
	

}
