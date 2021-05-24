package app.beans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tweets")
public class Tweet {

	@Id
	@Column(name = "tweetNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String content;
	@Column
	private String username;
	@Column
	private Timestamp timestamp;
	@OneToMany(mappedBy = "tweetId")
	@JsonIgnore
	private List<Like> likes = new ArrayList<>();
	@OneToMany(mappedBy = "originalTweetId")
	@JsonIgnore
	private List<ReTweet> reTweets = new ArrayList<>();
	@Column
	private int likes_count;
	@Column
	private int retweets_count;

	public Tweet(String textContent, String username, Timestamp timestamp) {
		super();
		this.content = textContent;
		this.username = username;
		this.timestamp = timestamp;
		this.likes_count = getLikesCount();
		this.retweets_count = getReTweetsCount();
	}

	public Tweet() {

	}

	public String getTextContent() {
		return content;
	}

	public void setTextContent(String textContent) {
		this.content = textContent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public List<Like> getLikes() {
		return likes;
	}

	public int getLikesCount() {
		return likes.size();
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public List<ReTweet> getReTweets() {
		return reTweets;
	}

	public int getReTweetsCount() {
		return reTweets.size();
	}

	public void setReTweets(List<ReTweet> reTweets) {
		this.reTweets = reTweets;
	}

	@Override
	public String toString() {
		return "Tweet: " + id + ", text content: " + content + ", username: " + username + ", time stamp: "
				+ timestamp + ", number of likes: " + getLikesCount() + ", number of reTweets: " + getReTweetsCount();
	}

}
