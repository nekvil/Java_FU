package com.example.HotelBookingAPI.controller;

import com.example.HotelBookingAPI.model.Menu;
import com.example.HotelBookingAPI.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private MenuService menuService;

    @GetMapping("")
    public List<Menu> getAllAdditionalServices(){
        return menuService.getAllAdditionalServices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> get(@PathVariable Integer id){
        try{
            Menu menu = menuService.getAdditionalServiceById(id);
            return new ResponseEntity<Menu>(menu, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public List<Menu> getByName(@PathVariable String name){
        return menuService.getAdditionalServiceByName(name);
    }

    @GetMapping("/price-per-day/{pricePerDay}")
    public List<Menu> getByPricePerDay(@PathVariable Double pricePerDay){
        return menuService.getAdditionalServiceByPricePerDay(pricePerDay);
    }

    @PostMapping("/")
    public void add(@RequestBody Menu menu){
        menuService.saveAdditionalService(menu);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        menuService.deleteAdditionalService(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Menu menu, @PathVariable Integer id){
        try{
            Menu baseMenu = menuService.getAdditionalServiceById(id);
            baseMenu.updateAdditionalService(menu);
            menuService.saveAdditionalService(baseMenu);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
