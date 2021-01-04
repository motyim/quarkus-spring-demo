package com.example.demo.service;


import com.example.demo.modal.Fruit;
import com.example.demo.modal.FruitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    private final FruitRepository fruitRepository;

    public FruitController(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @GetMapping(produces = "application/json")
    public Iterable<Fruit> findAll() {
        return fruitRepository.findAll();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        fruitRepository.deleteById(id);
    }

    @PostMapping(path = "/name/{name}/color/{color}", produces = "application/json")
    public Fruit create(@PathVariable(name = "name") String name, @PathVariable(name = "color") String color) {
        return fruitRepository.save(new Fruit(name, color));
    }

    @PutMapping(path = "/id/{id}/color/{color}", produces = "application/json")
    public Fruit changeColor(@PathVariable(name = "id") Long id, @PathVariable(name = "color") String color) {
        Optional<Fruit> optional = fruitRepository.findById(id);
        if (optional.isPresent()) {
            Fruit fruit = optional.get();
            fruit.setColor(color);
            return fruitRepository.save(fruit);
        }

        throw new IllegalArgumentException("No Fruit with id " + id + " exists");
    }

    @GetMapping(path = "/color/{color}", produces = "application/json")
    public List<Fruit> findByColor(@PathVariable(name = "color") String color) {
        return fruitRepository.findByColor(color);
    }
}