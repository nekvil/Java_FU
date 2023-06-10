package com.example.CoffeeAPI.controller;

import com.example.CoffeeAPI.model.Menu;
import com.example.CoffeeAPI.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> get(@PathVariable Integer id){
        try{
            Menu menu = menuService.getMenuById(id);
            return new ResponseEntity<Menu>(menu, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public List<Menu> getByName(@PathVariable String name){
        return menuService.getMenusByName(name);
    }

    @GetMapping("/price/{price}")
    public List<Menu> getByPrice(@PathVariable Double price){
        return menuService.getMenusByPrice(price);
    }

    @PostMapping("/")
    public void add(@RequestBody Menu menu){
        menuService.saveMenu(menu);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        menuService.deleteMenu(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Menu menu, @PathVariable Integer id){
        try{
            Menu baseMenu = menuService.getMenuById(id);
            baseMenu.updateMenu(menu);
            menuService.saveMenu(baseMenu);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
