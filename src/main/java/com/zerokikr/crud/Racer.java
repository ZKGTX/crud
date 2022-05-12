package com.zerokikr.crud;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "racers")
public class Racer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "autos_x_racers",
			joinColumns = @JoinColumn(name = "racer_id"),
			inverseJoinColumns = @JoinColumn(name = "auto_id")
			)
	private List<Auto>autos;

	public Racer() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Auto> getAutos() {
		return autos;
	}

	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}
	
	
	
	
}
