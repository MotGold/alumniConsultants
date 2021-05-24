package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.beans.ReTweet;

public interface RetweetRepository extends JpaRepository<ReTweet, Integer> {

}
