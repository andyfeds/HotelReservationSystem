package HotelReservationSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class RoomTypes {

	@Id
	private String roomtypeid;
	private String roomType;
	private String description;
	private int roomprice;
	private int totalrooms;
	private int availRooms;
	
	
	public String getRoomtypeid() {
		return roomtypeid;
	}
	public void setRoomtypeid(String roomtypeid) {
		this.roomtypeid = roomtypeid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRoomprice() {
		return roomprice;
	}
	public void setRoomprice(int roomprice) {
		this.roomprice = roomprice;
	}
	public int getTotalrooms() {
		return totalrooms;
	}
	public void setTotalrooms(int totalrooms) {
		this.totalrooms = totalrooms;
	}
		
	
	public int getAvailRooms() {
		return availRooms;
	}
	public void setAvailRooms(int availRooms) {
		this.availRooms = availRooms;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	
	
	
}
