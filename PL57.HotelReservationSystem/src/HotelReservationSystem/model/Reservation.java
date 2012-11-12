package HotelReservationSystem.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int ReserveId;
	Calendar arrivalDate;
	Calendar departureDate;
	String roomtypeid;
	int guestId;
	int adults;
	int children;
	
	
	public int getReserveId() {
		return ReserveId;
	}
	public void setReserveId(int reserveId) {
		ReserveId = reserveId;
	}
	public String getRoomtypeid() {
		return roomtypeid;
	}
	public void setRoomtypeid(String roomtypeid) {
		this.roomtypeid = roomtypeid;
	}
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
		this.guestId =guestId;
	}
	public int getAdults() {
		return adults;
	}
	public void setAdults(int adults) {
		this.adults = adults;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public GregorianCalendar getArrivatDate() {
		return (GregorianCalendar) arrivalDate;
	}
	public void setArrivatDate(Calendar arrivalDate) {
		this.arrivalDate=arrivalDate;
	   
	}
	public GregorianCalendar getDepartureDate() {
		return (GregorianCalendar) departureDate;
	}
	public void setDepartureDate(Calendar departureDate) {
		
		this.departureDate = departureDate;
	}
}
