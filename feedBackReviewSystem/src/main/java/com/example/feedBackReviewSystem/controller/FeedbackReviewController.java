package com.example.feedBackReviewSystem.controller;

import com.example.feedBackReviewSystem.dto.FeedbackDataDTO;
import com.example.feedBackReviewSystem.service.FeedBackDataService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FeedbackReviewController {
    private FeedBackDataService fbdService;
    FeedbackReviewController( FeedBackDataService fbdService){
        this.fbdService=fbdService;
    }

    @GetMapping("/")
    String home(Model model) {
        model.addAttribute("data", fbdService.getAprovedFeedBacks());
        return "home";
    }

    @GetMapping("/feedbackForm")
    String feedbackForm(Model model) {
        model.addAttribute("title", "Welcome to Feedback Review");
        return "feedbackForm";
    }

    @PostMapping("/feedbackSubmit")
    String submitForm(@ModelAttribute FeedbackDataDTO data, Model model) {
        if(fbdService.addFeedBack(data) ==1) {
            model.addAttribute("success", "feedback added successfully wait for admin approvel");
        }
        else
        {
          model.addAttribute("failer","feedback not submited succesfully... plz try again... ");
        }
        return "redirect:/";
    }

    @GetMapping("/admin")
    String admin(Model model){
        List<FeedbackDataDTO> feedbacks=fbdService.getAllFeedBacks();

        System.err.println(feedbacks.get(0).getApprove());

        model.addAttribute("allData", feedbacks);
        return "adminDashboard";
    }

@GetMapping("/approveFeedback/{id}")
//ResponseEntity<Map<String, String>> approveFeedBack(@PathVariable long feedbackId){
String approveFeedBack(@PathVariable long id){
    System.err.println(id);
    fbdService.updateAproval(id);
//    Map<String, String> response = new HashMap<>();
//    response.put("status", "success");
//    response.put("message", "Feedback approved successfully!");

//    return ResponseEntity.ok(response);
    return "redirect:/admin";
}
@GetMapping("/deleteFeedBack/{id}")
    String deleteFeedBack(@PathVariable long id)
    {
        fbdService.deleteFeedBack(id);
     return "redirect:/admin";
    }
}
