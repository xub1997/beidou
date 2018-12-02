package business.entity.repositories;

import business.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface UserRepositories extends JpaRepository<User,Long> {

    @Query("select u from User u where u.name = ?1 and u.psw = ?2")
    List<User> findUserByNameAndPsw(String name,String psw);

    @Query("select u from User u where u.name = ?1")
    List<User> findUserByName(String name);

    @Query("update User u set u.psw = ?1 where u.id = ?2")
    void updatePswById(String psw,Long id);

}
