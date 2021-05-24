package app.services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import org.springframework.stereotype.Service;

import app.beans.Like;
import app.exceptions.DoesNotExistException;

@Service
public class LikeService extends ClientService {

	public List<Like> getAllLikes() {
		return editLike.findAll();
	}

	public Like getLike(int likeNo) throws DoesNotExistException {
		if (editLike.existsById(likeNo))
			return editLike.findById(likeNo).get();
		else
			throw new DoesNotExistException();
	}

	public void addLike(int tweetId, Like input) {
		Timestamp date = new Timestamp(Calendar.getInstance().getTimeInMillis());
		Like like = new Like(editTweet.getById(tweetId), input.getUsername(), date);
		editLike.save(like);
	}

}
