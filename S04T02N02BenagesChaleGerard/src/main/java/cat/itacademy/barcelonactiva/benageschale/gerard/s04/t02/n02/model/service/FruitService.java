package cat.itacademy.barcelonactiva.benageschale.gerard.s04.t02.n02.model.service;

import cat.itacademy.barcelonactiva.benageschale.gerard.s04.t02.n02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.benageschale.gerard.s04.t02.n02.model.exceptions.FruitNotFoundException;

import java.util.List;

public interface FruitService {

    public Fruit saveFruit(Fruit fruit);
    public void updateFruit(Fruit fruit);
    public void deleteFruit(long id) throws FruitNotFoundException;
    public Fruit getFruit(long id) throws FruitNotFoundException;
    public List<Fruit> getAllFruits();
}
