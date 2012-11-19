package HotelReservationSystem.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QueryReply {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int replyid;
	int queryid;
	String replyby;
	String replybody;
	Calendar replydate;
	
	public int getReplyid() {
		return replyid;
	}
	public void setReplyid(int replyid) {
		this.replyid = replyid;
	}
	public int getQueryid() {
		return queryid;
	}
	public void setQueryid(int queryid) {
		this.queryid = queryid;
	}
	public String getReplyby() {
		return replyby;
	}
	public void setReplyby(String replyby) {
		this.replyby = replyby;
	}
	public String getReplybody() {
		return replybody;
	}
	public void setReplybody(String replybody) {
		this.replybody = replybody;
	}
	public Calendar getReplydate() {
		return replydate;
	}
	public void setReplydate(Calendar replydate) {
		this.replydate = replydate;
	}

}
