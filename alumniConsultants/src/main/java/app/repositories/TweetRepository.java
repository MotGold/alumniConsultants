package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.beans.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {

}
