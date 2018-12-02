package business.entity.repositories;

import business.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UnitRepositories extends JpaRepository<Unit,Long> {
    @Query("select u from Unit u where u.phone = ?1")
    List<Unit> findUnitByName(String name);

}
