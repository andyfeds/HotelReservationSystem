package HotelReservationSystem.model;

import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class CheckIn {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int CheckInId;
	private int ReserveId;
	private int RoomNo;
	private GregorianCalendar CheckInDate;
	private String CheckInTime;
	private int StayDays;
	public int getCheckInId() {
		return CheckInId;
	}
	public void setCheckInId(int checkInId) {
		CheckInId = checkInId;
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
	public GregorianCalendar getCheckInDate() {
		return CheckInDate;
	}
	public void setCheckInDate(GregorianCalendar checkInDate) {
		CheckInDate = checkInDate;
	}
	public String getCheckInTime() {
		return CheckInTime;
	}
	public void setCheckInTime(String checkInTime) {
		CheckInTime = checkInTime;
	}
	public int getStayDays() {
		return StayDays;
	}
	public void setStayDays(int stayDays) {
		StayDays = stayDays;
	}
	
	
	
	
	
	

}
