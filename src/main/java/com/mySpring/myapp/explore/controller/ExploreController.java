package com.mySpring.myapp.explore.controller;

import com.mySpring.myapp.carwash.model.CarWash;
import com.mySpring.myapp.carwash.service.CarWashService;
import com.mySpring.myapp.member.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ExploreController {

    @Autowired
    private CarWashService carWashService;

    @GetMapping("/explore.do")
    public String explorePage(Model model) {
        // DB에서 세차장 데이터를 가져옴
        List<CarWash> carWashList = carWashService.getAllCarWashes();
        model.addAttribute("carWashList", carWashList);
        return "explore"; // explore.jsp를 반환
    }
    
    @GetMapping("/earlyExplore.do")
    public String earlyExplorePage(Model model) {
        // DB에서 세차장 데이터를 가져옴
        List<CarWash> carWashList = carWashService.getAllCarWashes();
        model.addAttribute("carWashList", carWashList);
        return "earlyExplore"; // explore.jsp를 반환
    }
    
}
