package business.entity.repositories;

import business.entity.warn.Enclosure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EnclosureRepositories extends JpaRepository<Enclosure,Long> {
    @Query(value = "select * from Enclosure e where e.valid <= ?1 and e.invalid >= ?1 and time_format(e.start,'%H.%i.%s') <= time_format(?1,'%H.%i.%s') and time_format(e.stop,'%H.%i.%s') >= time_format(?1,'%H.%i.%s')",nativeQuery = true)
    List<Enclosure> findAllByValidAndInvalid(Date date);
}
