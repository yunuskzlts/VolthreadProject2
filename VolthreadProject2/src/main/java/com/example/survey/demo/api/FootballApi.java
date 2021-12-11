package com.example.survey.demo.api;

import com.example.survey.demo.model.Football;
import com.example.survey.demo.service.FootballService;
import com.example.survey.demo.service.HappinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class FootballApi {
    @Autowired
    private FootballService footballService;
    @Autowired
    private HappinessService happinessService;

    @GetMapping("/football")
    public String showFootball(Football football){

        return "footballAdd";
    }
    @PostMapping("/addFootball")
    public String addFootball(Football football, BindingResult result, Model model){
        if(result.hasErrors()){
            return "footballAdd";
        }
        footballService.saveFootball(football);
        return "redirect:/indexFootballAdd";
    }
    @GetMapping("/indexFootball")
    public String showFootballList(Model model){
        model.addAttribute("footballList",footballService.findAll());
        model.addAttribute("happinessList",happinessService.findAll());
        return "index";
    }
    @GetMapping("/editFootball/{id}")
    public String showFootball(@PathVariable("id") long id, Model model){
        Football football = footballService.findById(id);
        model.addAttribute("football",football);
        return "footballUpdate";
    }
    @PostMapping("/updateFootball/{id}")
    public String updateFootball(@PathVariable("id")long id,Football football,BindingResult result,Model model){
        if (result.hasErrors()) {
            football.setId(id);
            return "footballUpdate";
        }
        footballService.saveFootball(football);
        return "redirect:/indexFootball";
    }
    @GetMapping("/deleteFootball/{id}")
    public String deleteFootball(@PathVariable("id")long id){
        footballService.delete(id);
        return "redirect:/indexFootball";
    }

}
