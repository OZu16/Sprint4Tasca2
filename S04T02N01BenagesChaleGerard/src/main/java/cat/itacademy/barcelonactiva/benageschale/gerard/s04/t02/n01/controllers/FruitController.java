package cat.itacademy.barcelonactiva.benageschale.gerard.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.benageschale.gerard.s04.t02.n01.model.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.benageschale.gerard.s04.t02.n01.model.service.IFruitService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cat.itacademy.barcelonactiva.benageschale.gerard.s04.t02.n01.model.domain.Fruit;

import java.util.List;


@RestController
@RequestMapping(value = "/api/fruit")
public class FruitController {

    @Autowired
    private IFruitService fruitService;


    @PostMapping(value = "/add")
    public ResponseEntity<String> createFruit(@RequestBody Fruit fruit) {
            fruitService.saveFruit(fruit);
            return new ResponseEntity<>("Fruita afegida amb èxit", HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteFruitById(@PathVariable("id") Long id) throws FruitNotFoundException {
        Fruit fruit = fruitService.getFruit(id);
            fruitService.deleteFruit(id);
            return new ResponseEntity<>("Fruita eliminada amb èxit", HttpStatus.GONE);

    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() throws FruitNotFoundException {
        List<Fruit> fruits = fruitService.getAllFruits();
        if(fruits.isEmpty()){
            throw new FruitNotFoundException("");
        }
        return new ResponseEntity<>(fruits, HttpStatus.OK);
    }


    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> searchFruitById(@PathVariable("id") Long id) throws FruitNotFoundException {
       Fruit fruit = fruitService.getFruit(id);
            return new ResponseEntity<>(fruit, HttpStatus.FOUND);
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFruitById(@PathVariable("id") long id, @RequestBody Fruit updateFruit) throws FruitNotFoundException {
        Fruit fruit = fruitService.getFruit(id);

        if (updateFruit != null) {
            fruit.setName(updateFruit.getName());
            fruit.setKg(updateFruit.getKg());
            fruitService.updateFruit(fruit);
            return new ResponseEntity<>("Canvis realitzats amb èxit", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Sense canvis", HttpStatus.NOT_MODIFIED);


    }
}
