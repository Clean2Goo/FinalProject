package com.mySpring.myapp.carwash.service;

import com.mySpring.myapp.carwash.dao.CarWashDAO;
import com.mySpring.myapp.carwash.model.CarWash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Spring에서 Service Bean으로 등록
public class CarWashServiceImpl implements CarWashService {

    @Autowired
    private CarWashDAO carWashDAO;

    @Override
    public List<CarWash> getRecommendedCarWashes() {
        return carWashDAO.getRecommendedCarWashes();
    }
    @Override
    public List<CarWash> getAllCarWashes() {
        return carWashDAO.getRecommendedCarWashes(); // 임시로 동일 메서드 사용
    }

}
