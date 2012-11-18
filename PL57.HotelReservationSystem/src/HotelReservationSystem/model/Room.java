package HotelReservationSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Room {
	@Id
	
	private int RoomNo;
	private String roomtypeid;
	private String Status;
	
	public int getRoomNo() {
		return RoomNo;
	}
	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}
	public String getRoomtypeid() {
		return roomtypeid;
	}
	public void setRoomtypeid(String roomtypeid) {
		this.roomtypeid = roomtypeid;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}

}
