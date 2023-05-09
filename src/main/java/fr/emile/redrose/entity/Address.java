package fr.emile.redrose.entity;

import java.io.Serializable;

import fr.emile.redrose.common.IConstant;

public class Address implements IConstant, Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer number;
	private String numberType;
	private String street;
	private String city;
	private String zipCode;
	private Integer idUser;
	private Boolean isValide;
	private Boolean isDeleted;


	public Address() {
		this(DEFAULT_ID,DEFAULT_ID,"","","","",DEFAULT_ID,true,false);
	
	}
	
	public Address( Integer number,String numberType, String street, String city, String zipCode) {
		this(DEFAULT_ID,number,numberType,street, city,zipCode,DEFAULT_ID,true,false);

	}

	public Address(Integer id, Integer number,
			String numberType, String street, String city, String zipCode, 
			Integer idUser, 
			Boolean isValide,Boolean isDeleted) {
		this.setId(id);
		this.setNumber(number);
		this.setStreet(street);
		this.setCity(city);
		this.setZipCode(zipCode);
		this.setIdUser(idUser);
		this.setValide(isValide);
		this.setDeleted(isDeleted);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return String.format("%d : %s, %s %s %s",
				this.getId(),
				this.getNumber(),
				this.getStreet(),
				this.getZipCode(),
				this.getCity());
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getNumberType() {
		return numberType;
	}
	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}
	public Boolean getIsValide() {
		return isValide;
	}
	public void setIsValide(Boolean isValide) {
		this.isValide = isValide;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	

}
