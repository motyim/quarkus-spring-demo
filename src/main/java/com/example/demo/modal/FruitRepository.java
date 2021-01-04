package com.example.demo.modal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FruitRepository extends CrudRepository<Fruit, Long> {

    List<Fruit> findByColor(String color);

}