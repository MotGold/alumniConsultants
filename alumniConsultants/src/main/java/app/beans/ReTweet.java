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
@Table(name = "retweets")
public class ReTweet {

	@Id
	@Column(name = "retweet_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	private String content = "";
	private String retweet_user = "";
	@JsonIgnore
	@ManyToOne
	private Tweet originalTweetId;
	@Column
	private String tweet_user;
	@Column
	private Timestamp timestamp;

	public ReTweet(String content, String retweet_user, Tweet originalTweetId, String tweet_user, Timestamp timestamp) {
		super();
		this.content = content;
		this.retweet_user = retweet_user;
		this.originalTweetId = originalTweetId;
		this.tweet_user = tweet_user;
		this.timestamp = timestamp;
	}

	public ReTweet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRetweet_user() {
		return retweet_user;
	}

	public void setRetweet_user(String retweet_user) {
		this.retweet_user = retweet_user;
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

	public String getContent() {
		return content;
	}

	public Tweet getOriginalTweetId() {
		return originalTweetId;
	}

	public String getTweet_user() {
		return tweet_user;
	}

	@Override
	public String toString() {
		return "ReTweet [id=" + id + ", content=" + content + ", retweet_user=" + retweet_user + ", OriginalTweetId="
				+ originalTweetId + ", tweet_user=" + tweet_user + ", timestamp=" + timestamp + "]";
	}

}
