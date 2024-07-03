//package com.example.Fruit_shop.service;

//public class FruitService {
//}
// src/main/java/com/example/fruitshop/service/FruitService.java

package com.example.Fruit_shop.service;
import com.example.Fruit_shop.model.Fruit;
import com.example.Fruit_shop.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Optional<Fruit> getFruitById(Long id) {
        return fruitRepository.findById(id);
    }

    public Fruit saveFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public void deleteFruit(Long id) {
        fruitRepository.deleteById(id);
    }
}

