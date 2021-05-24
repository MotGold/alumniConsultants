package app.services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import app.beans.Tweet;
import app.beans.TweetText;
import app.exceptions.DoesNotExistException;

@Service
public class TweetService extends ClientService{

	public List<Tweet> getAllTweets() {
		return editTweet.findAll();
	}

	public Tweet getTweet(int tweetNo) throws DoesNotExistException {
		if (editTweet.existsById(tweetNo))
			return editTweet.findById(tweetNo).get();
		else
			throw new DoesNotExistException();
	}

	public void addTweet(TweetText body) {
		Timestamp date = new Timestamp(Calendar.getInstance().getTimeInMillis());
		Tweet tweet = new Tweet(body.getTextContent(), body.getUsername(), date);
		editTweet.save(tweet);
	}

}
