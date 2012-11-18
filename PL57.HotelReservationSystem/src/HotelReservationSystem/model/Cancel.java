package HotelReservationSystem.model;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cancel {

@Id	
private int cancelId;
private Calendar cancelDate;	
private int reserveId;
private int guestId;
private String roomTypeId;
private Calendar arrivalDate;
private Calendar departureDate;
private int pnr;


public int getReserveId() {
	return reserveId;
}
public void setReserveId(int reserveId) {
	this.reserveId = reserveId;
}

public int getGuestId() {
	return guestId;
}
public void setGuestId(int guestId) {
	this.guestId = guestId;
}
public String getRoomTypeId() {
	return roomTypeId;
}
public void setRoomTypeId(String roomTypeId) {
	this.roomTypeId = roomTypeId;
}



public int getPnr() {
	return pnr;
}
public void setPnr(int pnr) {
	this.pnr = pnr;
}
public int getCancelId() {
	return cancelId;
}
public void setCancelId(int cancelId) {
	this.cancelId = cancelId;
}

public Calendar getCancelDate() {
	return cancelDate;
}
public void setCancelDate(Calendar cancelDate) {
	this.cancelDate = cancelDate;
}
public Calendar getArrivalDate() {
	return arrivalDate;
}
public void setArrivalDate(Calendar arrivalDate) {
	this.arrivalDate = arrivalDate;
}
public Calendar getDepartureDate() {
	return departureDate;
}
public void setDepartureDate(Calendar departureDate) {
	this.departureDate = departureDate;
}

	


}
