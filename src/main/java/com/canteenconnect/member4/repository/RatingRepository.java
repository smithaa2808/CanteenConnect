package com.canteenconnect.member4.repository;
import com.canteenconnect.member4.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface RatingRepository extends JpaRepository<Rating,Long> { List<Rating> findAllByOrderBySubmittedAtDesc(); }
