package cat.itacademy.barcelonactiva.benageschale.gerard.s04.t02.n03.model.service;

import cat.itacademy.barcelonactiva.benageschale.gerard.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.benageschale.gerard.s04.t02.n03.model.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.benageschale.gerard.s04.t02.n03.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IFruitService implements FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public Fruit saveFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public void updateFruit(Fruit fruit) {
        fruitRepository.save(fruit);
    }

    @Override
    public void deleteFruit(long id) throws FruitNotFoundException{
        Optional<Fruit> fruit = fruitRepository.findById(id);
        if(fruit.isPresent()){
            fruitRepository.deleteById(id);
        }
        else{
            throw new FruitNotFoundException("Fruita no existent");
        }
    }

    @Override
    public Fruit getFruit(long id) throws FruitNotFoundException {
        return fruitRepository.findById(id)
                .orElseThrow(() ->new FruitNotFoundException("Fruita no existent"));
    }


    @Override
    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }


}
