package com.mySpring.myapp.carwash.service;

import com.mySpring.myapp.carwash.model.CarWash;
import java.util.List;

public interface CarWashService {
    List<CarWash> getRecommendedCarWashes();
    List<CarWash> getAllCarWashes(); // 추가
}

