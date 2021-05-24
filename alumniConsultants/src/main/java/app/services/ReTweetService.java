package app.services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import app.beans.ReTweet;
import app.beans.ReTweetUser;
import app.exceptions.DoesNotExistException;

@Service
public class ReTweetService extends ClientService {

	public List<ReTweet> getAllReTweets() {
		return editReTweet.findAll();
	}

	public ReTweet getReTweet(int retweetNo) throws DoesNotExistException {
		if (editReTweet.existsById(retweetNo))
			return editReTweet.findById(retweetNo).get();
		else
			throw new DoesNotExistException();
	}

	public void addReTweet(ReTweetUser retweet, int tweetId) {
		Timestamp date = new Timestamp(Calendar.getInstance().getTimeInMillis());
		ReTweet input = new ReTweet(editTweet.getById(tweetId).getTextContent(), retweet.getUsername(),
				editTweet.getById(tweetId), editTweet.getById(tweetId).getUsername(), date);
		editReTweet.save(input);
	}

}
