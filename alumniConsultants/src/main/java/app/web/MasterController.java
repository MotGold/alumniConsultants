package app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.beans.Like;
import app.beans.ReTweet;
import app.beans.ReTweetUser;
import app.beans.Tweet;
import app.beans.TweetText;
import app.services.LikeService;
import app.services.ReTweetService;
import app.services.TweetService;

import io.swagger.annotations.Api;

@Api(tags = "AlumniConsultants")
@RestController
@RequestMapping("AlumniConsultants")
@CrossOrigin(origins = "http://localhost:4200")
public class MasterController {

	public MasterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	LikeService likesEdit;
	@Autowired
	ReTweetService retweetEdit;
	@Autowired
	TweetService tweetEdit;

	@GetMapping("tweets")
	public List<Tweet> getAllTweets() {
		return tweetEdit.getAllTweets();
	}

	@PostMapping("addTweet")
	public void addTweet(@RequestBody TweetText newTweet) {
		tweetEdit.addTweet(newTweet);
	}

	@PostMapping("tweets/{tweetId}/likes")
	public void addLike(@PathVariable int tweetId, @RequestBody Like like) {
		likesEdit.addLike(tweetId, like);
	}
	
	@PostMapping("tweets/{tweetId}/retweets")
	public void addReTweet(@PathVariable int tweetId, @RequestBody ReTweetUser input) {
		retweetEdit.addReTweet(input, tweetId);
	}
	
	@GetMapping("retweets")
	public List<ReTweet> getAllReTweets() {
		return retweetEdit.getAllReTweets();
	}

}
