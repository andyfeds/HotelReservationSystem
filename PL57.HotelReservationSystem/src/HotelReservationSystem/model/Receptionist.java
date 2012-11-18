package HotelReservationSystem.model;

import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Receptionist {
	
	@Id
	private int idreceptionist;
	private String fname;
	private String lname;
	private GregorianCalendar dob;
	private String eId;
	private String username;
	private String password;
	private String M_Number;
	private String gender;
	private String address;
	
	
	public int getIdreceptionist() {
		return idreceptionist;
	}
	public void setIdreceptionist(int idreceptionist) {
		this.idreceptionist = idreceptionist;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public GregorianCalendar getDob() {
		return dob;
	}
	public void setDob(GregorianCalendar dob) {
		this.dob = dob;
	}
	public String getM_Number() {
		return M_Number;
	}
	public void setM_Number(String m_Number) {
		M_Number = m_Number;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
