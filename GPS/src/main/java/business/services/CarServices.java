package business.services;

import business.entity.Car;
import business.entity.Unit;
import business.entity.User;
import business.entity.repositories.CarRepositories;
import business.entity.repositories.UnitRepositories;
import business.entity.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarServices {

    @Autowired
    private UnitRepositories unitRepositories;

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private CarRepositories carRepositories;

    public boolean ifregistered(Car car) { return carRepositories.existsById(car.getCard()); }

    public void deleteAllById(Iterator<?> idlist) {
        while(idlist.hasNext()){
            carRepositories.deleteById(Long.valueOf(Long.parseLong((String) idlist.next())));//从String转long再转Long
        }
    }

    public List<Car> findCarsByUser(User user){
        if(user == null) return null;
        ArrayList<Car> list = new ArrayList<Car>(userRepositories.findById(user.getId()).get().getCars());
        Collections.sort(list, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Long.compare(o1.getCard(),o2.getCard());
            }
        });//升序排列
        return list;
    }

}
