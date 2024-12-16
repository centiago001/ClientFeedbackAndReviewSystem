package com.example.feedBackReviewSystem.service;

import com.example.feedBackReviewSystem.dto.FeedbackDataDTO;
import com.example.feedBackReviewSystem.entity.FeedBackDataEntity;
import com.example.feedBackReviewSystem.mapperUtil.mapper;
import com.example.feedBackReviewSystem.repository.FeedBackDataRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedBackDataService implements  FeedBackDataInterface{
    private FeedBackDataRepository repo;
    private mapper mp;
    FeedBackDataService(FeedBackDataRepository repo,mapper mp){
        this.repo=repo;
        this.mp=mp;
    }


    @Override
    public int addFeedBack(FeedbackDataDTO data) {
        try{

            repo.save(mp.mapToEntity(data));
            return 1;
        }
        catch( Exception  e){
            return 0;
        }


    }

    @Override
    public List<FeedbackDataDTO> getAprovedFeedBacks() {
        ArrayList<FeedbackDataDTO> lst=new ArrayList<>();
        for(FeedBackDataEntity tmp : repo.findByIsApprovedTrue()){
            lst.add(mp.mapToDTO(tmp));
        }
        return lst ;
    }

    @Override
    public List<FeedbackDataDTO> getAllFeedBacks() {
        ArrayList<FeedbackDataDTO> lst=new ArrayList<>();
        for(FeedBackDataEntity tmp : repo.findAll()){
            lst.add(mp.mapToDTO(tmp));
        }
        return lst ;
    }

    @Override
    public int updateAproval(long id) {


        return repo.updateIsApprovedById(id);
    }

    @Override
    public int deleteFeedBack(long id) {
        repo.deleteById(id);
        return 1;
    }
}
