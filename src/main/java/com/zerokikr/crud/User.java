package com.zerokikr.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "age")
	private int age;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // @OneToMany означает, что одному объекту класса User 
	private List<Auto> autos;													   // может соответствовать несколько объектов класса Auto
																				   // orphanRemoval - если удалить User из БД, то все связанные с ним Auto также удалятся
	
	public User() {
		
	}


	public User(String name, int age) {
		this.name = name;
		this.age = age;
		autos = new ArrayList<>();
	}
	
	public void addAuto (Auto auto) {
		auto.setUser(this);
		autos.add(auto);
	}
	
	public void removeAuto (Auto auto) {
		autos.remove(auto);
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public List<Auto> getAutos() {
		return autos;
	}


	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}
