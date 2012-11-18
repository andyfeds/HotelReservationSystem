package HotelReservationSystem.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GuestQuery {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int queryid;
	String postedby;
	String email;
	Calendar date;
	String body;
	int status;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getQueryid() {
		return queryid;
	}
	public void setQueryid(int queryid) {
		this.queryid = queryid;
	}
	public String getPostedby() {
		return postedby;
	}
	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	
}
