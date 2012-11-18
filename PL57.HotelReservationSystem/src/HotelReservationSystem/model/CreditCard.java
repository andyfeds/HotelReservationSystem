package HotelReservationSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreditCard {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int creditcardid;
	String creditcardno;
	int cvv;
	int guestid;
	String expiry;
	int reservationid;
	
	public int getCreditcardid() {
		return creditcardid;
	}
	public void setCreditcardid(int creditcardid) {
		this.creditcardid = creditcardid;
	}
	public String getCreditcardno() {
		return creditcardno;
	}
	public void setCreditcardno(String creditcardno) {
		this.creditcardno = creditcardno;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public int getGuestid() {
		return guestid;
	}
	public void setGuestid(int guestid) {
		this.guestid = guestid;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public int getReservationid() {
		return reservationid;
	}
	public void setReservationid(int reservationid) {
		this.reservationid = reservationid;
	}

}
