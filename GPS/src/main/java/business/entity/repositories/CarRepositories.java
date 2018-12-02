package business.entity.repositories;

import business.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepositories extends JpaRepository<Car,Long> {
  @Query("select c from Car c where c.card = ?1")
  Car findByCard(Long card);
}
