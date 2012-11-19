package HotelReservationSystem.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CheckOut {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int CheckOutId;
	private int ReserveId;
	private int guestid;
	private int pnr;
	private int RoomNo;
	private Calendar CheckOutDate;
	private String CheckOutTime;
	private int CheckInId;
	private int DaysStayed;
	
	public int getDaysStayed() {
		return DaysStayed;
	}
	public void setDaysStayed(int daysStayed) {
		DaysStayed = daysStayed;
	}
	public int getCheckOutId() {
		return CheckOutId;
	}
	public void setCheckOutId(int checkOutId) {
		CheckOutId = checkOutId;
	}
	
	public int getGuestid() {
		return guestid;
	}
	public void setGuestid(int guestid) {
		this.guestid = guestid;
	}
	public int getPnr() {
		return pnr;
	}
	public void setPnr(int pnr) {
		this.pnr = pnr;
	}
	public int getReserveId() {
		return ReserveId;
	}
	public void setReserveId(int reserveId) {
		ReserveId = reserveId;
	}
	public int getRoomNo() {
		return RoomNo;
	}
	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}
	public Calendar getCheckOutDate() {
		return CheckOutDate;
	}
	public void setCheckOutDate(Calendar checkOutDate) {
		CheckOutDate = checkOutDate;
	}
	public String getCheckOutTime() {
		return CheckOutTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		CheckOutTime = checkOutTime;
	}
	public int getCheckInId() {
		return CheckInId;
	}
	public void setCheckInId(int checkInId) {
		CheckInId = checkInId;
	}
	
	
	
	
}
