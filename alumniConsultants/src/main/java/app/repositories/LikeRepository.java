package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.beans.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {

}
