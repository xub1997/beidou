package business.entity.repositories;

import business.entity.Car;
import business.entity.CarStopPos;
import business.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CarStopPosRepositories extends JpaRepository<CarStopPos,Long>{
    @Transactional
    @Modifying
    @Query("update CarStopPos set position.lat = ?2,position.lon = ?1 where car=?3")
    void queryCarStopPosByCar(String lon,String lat, Car car);

    @Query("select c from CarStopPos c where c.car.card = ?1")
    CarStopPos findCarStopPosByCar_Card(Long card);

}
