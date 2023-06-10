package com.example.CoffeeAPI.service;

import com.example.CoffeeAPI.model.Menu;
import com.example.CoffeeAPI.repository.MenuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAllMenus(){
        return menuRepository.findAll();
    }

    public List<Menu> getMenusByName(String name){
        return menuRepository.findByName(name);
    }

    public List<Menu> getMenusByPrice(Double price){
        return menuRepository.findByPrice(price);
    }

    public void saveMenu(Menu menu){
        menuRepository.save(menu);
    }

    public void deleteMenu(Integer id){
        menuRepository.deleteById(id);
    }


    public Menu getMenuById(Integer id){
        return menuRepository.findById(id).orElse(null);
    }

}
