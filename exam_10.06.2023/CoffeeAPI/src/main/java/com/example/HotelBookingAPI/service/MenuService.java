package com.example.HotelBookingAPI.service;

import com.example.HotelBookingAPI.model.Menu;
import com.example.HotelBookingAPI.repository.MenuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAllAdditionalServices(){
        return menuRepository.findAll();
    }

    public List<Menu> getAdditionalServiceByName(String name){
        return menuRepository.findByName(name);
    }

    public List<Menu> getAdditionalServiceByPricePerDay(Double pricePerDay){
        return menuRepository.findByPricePerDay(pricePerDay);
    }

    public void saveAdditionalService(Menu menu){
        menuRepository.save(menu);
    }

    public void deleteAdditionalService(Integer id){
        menuRepository.deleteById(id);
    }

    public Menu getAdditionalServiceById(Integer id){
        return menuRepository.findById(id).orElse(null);
    }
}
