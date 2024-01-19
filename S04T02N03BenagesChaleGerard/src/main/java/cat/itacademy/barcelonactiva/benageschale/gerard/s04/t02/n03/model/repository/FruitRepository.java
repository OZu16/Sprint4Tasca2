package cat.itacademy.barcelonactiva.benageschale.gerard.s04.t02.n03.model.repository;

import cat.itacademy.barcelonactiva.benageschale.gerard.s04.t02.n03.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

}
