package app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.repositories.LikeRepository;
import app.repositories.RetweetRepository;
import app.repositories.TweetRepository;

@Service
public abstract class ClientService {

	@Autowired
	protected LikeRepository editLike;
	@Autowired
	protected RetweetRepository editReTweet;
	@Autowired
	protected TweetRepository editTweet;

}
