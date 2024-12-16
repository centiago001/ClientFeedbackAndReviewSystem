package com.example.feedBackReviewSystem.repository;


import com.example.feedBackReviewSystem.entity.FeedBackDataEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeedBackDataRepository extends JpaRepository<FeedBackDataEntity, Long> {
    @Query("SELECT f FROM FeedBackDataEntity f WHERE f.isApprove = true")
    List<FeedBackDataEntity> findByIsApprovedTrue();

    @Transactional
    @Modifying
    @Query("UPDATE FeedBackDataEntity f SET f.isApprove = true WHERE f.id = :id")
    int updateIsApprovedById(@Param("id") Long id);

}
