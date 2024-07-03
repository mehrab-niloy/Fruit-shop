// src/main/java/com/example/fruitshop/controller/FruitController.java
package com.example.Fruit_shop.controller;

import com.example.Fruit_shop.model.Fruit;
import com.example.Fruit_shop.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @GetMapping
    public String getAllFruits(Model model) {
        List<Fruit> fruits = fruitService.getAllFruits();
        model.addAttribute("fruits", fruits);
        return "fruit-list";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Fruit> getFruitById(@PathVariable Long id) {
        return fruitService.getFruitById(id);
    }

    @PostMapping
    public String createFruit(@ModelAttribute Fruit fruit) {
        fruitService.saveFruit(fruit);
        return "redirect:/fruits";
    }

    @DeleteMapping("/{id}")
    public String deleteFruit(@PathVariable Long id) {
        fruitService.deleteFruit(id);
        return "redirect:/fruits";
    }
}
