package app.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "likes")
public class Like {

	@Id
	@Column(name = "like_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	@ManyToOne
	@JsonIgnore
	private Tweet tweetId;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private Timestamp timestamp;

	public Like(Tweet tweetId, String username, Timestamp timestamp) {
		super();
		this.tweetId = tweetId;
		this.username = username;
		this.timestamp = timestamp;
	}

	public Like() {

	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Tweet getTweetId() {
		return tweetId;
	}
	
	

	@Override
	public String toString() {
		return "Liked by: " + username + ", time stamp:" + timestamp;
	}

}
