package com.example.feedBackReviewSystem.mapperUtil;

import com.example.feedBackReviewSystem.dto.FeedbackDataDTO;
import com.example.feedBackReviewSystem.entity.FeedBackDataEntity;
import org.springframework.stereotype.Component;

@Component
public class mapper {

    public FeedbackDataDTO mapToDTO(FeedBackDataEntity data){
        FeedbackDataDTO newData=new FeedbackDataDTO();
        newData.setId(data.getId());
        newData.setName(data.getName());
        newData.setEmail(data.getEmail());
        newData.setRating(data.getRating());
       newData.setComment(data.getComment());
       newData.setApprove(data.getApprove());
        return newData;
    }


 public FeedBackDataEntity mapToEntity(FeedbackDataDTO data){
     FeedBackDataEntity newData=new FeedBackDataEntity();
        newData.setId(data.getId());
        newData.setName(data.getName());
        newData.setEmail(data.getEmail());
        newData.setRating(data.getRating());
        newData.setComment(data.getComment());
        newData.setApprove(data.getApprove());
        return newData;
    }
}
