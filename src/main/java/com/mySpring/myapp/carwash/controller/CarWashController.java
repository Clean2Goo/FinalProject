package com.mySpring.myapp.carwash.controller;

import com.mySpring.myapp.carwash.model.CarWash;
import com.mySpring.myapp.carwash.service.CarWashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarWashController {

    @Autowired
    private CarWashService carWashService;

    @GetMapping("/api/carwashes/recommended")
    @ResponseBody
    public List<CarWash> getRecommendedCarWashes() {
        return carWashService.getRecommendedCarWashes();
    }
}
