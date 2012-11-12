package HotelReservationSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Guest {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int guestId;
	String gfname;
	String glname;
	String gemail;
	String gphone;
	String gaddress;
	
	
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
	public String getGfname() {
		return gfname;
	}
	public void setGfname(String gfname) {
		this.gfname = gfname;
	}
	public String getGlname() {
		return glname;
	}
	public void setGlname(String glname) {
		this.glname = glname;
	}
	public String getGemail() {
		return gemail;
	}
	public void setGemail(String gemail) {
		this.gemail = gemail;
	}
	public String getGphone() {
		return gphone;
	}
	public void setGphone(String gphone) {
		this.gphone = gphone;
	}
	public String getGaddress() {
		return gaddress;
	}
	public void setGaddress(String gaddress) {
		this.gaddress = gaddress;
	}
}
