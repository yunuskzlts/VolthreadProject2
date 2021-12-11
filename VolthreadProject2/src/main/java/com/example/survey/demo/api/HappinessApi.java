package com.example.survey.demo.api;


import com.example.survey.demo.model.Happiness;
import com.example.survey.demo.service.FootballService;
import com.example.survey.demo.service.HappinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HappinessApi {
    @Autowired
    private FootballService footballService;
    @Autowired
    private HappinessService happinessService;

    @GetMapping("/happiness")
    public String showHappiness(Happiness happiness){
        return "happinessAdd";
    }
    @PostMapping("/addHappiness")
    public String addHappiness(Happiness happiness, BindingResult result, Model model){
        if(result.hasErrors()){
            return "happinessAdd";
        }
        happinessService.saveHappiness(happiness);
        return "redirect:/indexHappiness";
    }
    @GetMapping("/indexHappiness")
    public String showHappiness(Model model){
        model.addAttribute("averageHappiness",happinessService.calculateHappinessRate());
        model.addAttribute("happinessList",happinessService.findAll());
        model.addAttribute("footballList",footballService.findAll());
        return "index";
    }
    @GetMapping("/editHappiness/{id}")
    public String showHappiness(@PathVariable("id") long id, Model model){
        Happiness happiness=happinessService.findById(id);
        model.addAttribute("happiness",happiness);
        return "happinessUpdate";
    }
    @PostMapping("/updateHappiness/{id}")
    public String updateHappiness(@PathVariable("id") long id, Happiness happiness,
                                  BindingResult result){
        if(result.hasErrors()){
            happiness.setId(id);
            return "happinessUpdate";
        }
        happinessService.saveHappiness(happiness);
        return "redirect:/indexHappiness";
    }
    @GetMapping("/deleteHappiness/{id}")
    public String deleteHappiness(@PathVariable("id") long id){
        happinessService.delete(id);
        return "redirect:/indexHappiness";
    }

}
