package reservation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RoomTypes {
	
	String roomTypes;
	List<RoomTypes> roomList = new ArrayList<RoomTypes>();
	ResultSet rs = null;
	HotelConnection hc = new HotelConnection();
	
	public void displayRoomTypes()
	{
		
		rs = hc.connect("Select * from roomtypes");
	
		try {
			while(rs.next())
			{
				//System.out.println(rs.getString("roomtype"));
				RoomTypes roomType = new RoomTypes();
				roomType.setRoomTypes(rs.getString("roomtype"));
				roomList.add(roomType);
				
			}
			
			for(int i=0;i<roomList.size();i++)
			{
				System.out.println(roomList.get(i).getRoomTypes());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public String getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(String roomTypes) {
		this.roomTypes = roomTypes;
	}
}
