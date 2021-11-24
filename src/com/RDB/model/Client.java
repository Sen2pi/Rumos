package com.RDB.model;

import java.time.LocalDate;
import java.util.Calendar;

public class Client {


	private Integer id;
	private String nif;
	private String name;
	private String password;
	private LocalDate birthDate;
	private Integer phone;
	private Integer mobile;
	private String email;
	private String profession;
	
	public Client(String nif, String name, String password, LocalDate birthDate, 
			Integer phone, Integer mobile,
			String email, String profession) {
		super();
		this.nif = nif;
		this.name = name;
		this.password = password;
		this.birthDate = birthDate;
		this.phone = phone;
		this.mobile = mobile;
		this.email = email;
		this.profession = profession;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}


	@Override
	public String toString() {
		Calendar now = Calendar.getInstance();
		int year1 = now.get(Calendar.YEAR);
		int year2 = birthDate.getYear();
		int age = year1 - year2;
		int month1 = now.get(Calendar.MONTH);
		int month2 = birthDate.getMonthValue();
		if (month2 > month1) {
			  age--;
			} else if (month1 == month2) {
			  int day1 = now.get(Calendar.DAY_OF_MONTH);
			  int day2 = birthDate.getDayOfMonth();
			  if (day2 > day1) {
			    age--;
			  		}
			}
		return "\nClient id: " + id + " | NIF: " + nif + " | Name: " + name +  " Born in: "
				+ birthDate + " " + age + " years old " + " | Phone Number: " + phone + " | Mobile Phone Number:" + mobile + " | Email: " + email + " | Profession: "
				+ profession + "\n" ;
	}

}
