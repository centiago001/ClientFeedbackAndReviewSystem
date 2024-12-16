package com.example.feedBackReviewSystem.service;

import com.example.feedBackReviewSystem.dto.FeedbackDataDTO;

import java.util.List;

public interface FeedBackDataInterface {

//    List<FeedbackDataDTO> getAllFeedBackData();
    int addFeedBack(FeedbackDataDTO data);
    List<FeedbackDataDTO> getAprovedFeedBacks();
    List<FeedbackDataDTO> getAllFeedBacks();
    int updateAproval(long id);
    int deleteFeedBack(long id);
}
