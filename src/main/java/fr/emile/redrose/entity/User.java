package fr.emile.redrose.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import fr.emile.redrose.utils.Utils;
import fr.emile.redrose.common.IConstant;
import fr.emile.redrose.enums.Gender;

@Entity
@Table(name = "user")
@XmlRootElement
public class User implements Serializable, IConstant {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String firstname;
	private String lastname;
	private Gender gender;
	private Date birthdate;
	private String email;
	private Boolean isDeleted ;
	
	@Embedded
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id", nullable = false)
	private Address address ;
	
	public User( ) {
		this(DEFAULT_ID,"","",NULL_DATE,false);
		
	}
	
	public User( String firstname, String lastname, Date birthdate) {
		this(DEFAULT_ID,firstname,lastname,birthdate,false);
	}
	
	
	public User(Integer id, String firstname, String lasttname, Date birthdate, boolean isDeleted) {
		this.setId ( id);
		this.setFirstname ( firstname);
		this.setLasttname ( lasttname);
		this.setBirthdate ( birthdate);
		this.setDeleted ( isDeleted);
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLasttname() {
		return lastname;
	}
	public void setLasttname(String lasttname) {
		this.lastname = lasttname;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Boolean isDeleted() {
		return this.GetDeleted();
	}

	public Boolean GetDeleted() {
		return this.isDeleted;
	}

	public void setDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Version
	protected Integer version;


	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return String.format("%d : %s %s %s",getId(), getFirstname(), getLasttname(), 
				Utils.date2String(this.getBirthdate(),"dd/MM/yyyy"));
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
			

}
