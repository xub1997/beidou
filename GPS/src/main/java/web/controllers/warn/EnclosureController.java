package web.controllers.warn;

import business.entity.Car;
import business.entity.User;
import business.entity.repositories.CarRepositories;
import business.entity.repositories.EnclosureRepositories;
import business.entity.warn.Enclosure;
import business.entity.warn.EnclosureWarnType;
import business.services.CarServices;
import business.services.EnclosureServices;
import business.util.CacheArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping(path = "warn/enclosure")
public class EnclosureController {

    @Autowired
    private EnclosureServices enclosureServices;

    @Autowired
    private EnclosureRepositories enclosureRepositories;

    @Autowired
    private CarRepositories carRepositories;

    @Autowired
    private CarServices carServices;

    @ModelAttribute(name = "allEnclosures")
    public List<Enclosure> populateEnclosure(){ return enclosureRepositories.findAll();}

    @ModelAttribute(name = "allCars")
    public List<Car> populateCar(){ return carRepositories.findAll();}

    @ModelAttribute(name = "allWarnTypes")
    public List<EnclosureWarnType> populateEnclosureWarnType(){ return Arrays.asList(EnclosureWarnType.ALL);}

    @ModelAttribute(name = "ids") public CacheArray<Long> cacheArray(){return new CacheArray<Long>();}

    @RequestMapping
    public String showEnclosures(Enclosure enclosure){
        return "enclosure";
    }

    @PostMapping(path = "/add")
    public @ResponseBody int add(@RequestBody Enclosure enclosure,HttpSession httpSession){
        if(httpSession.getAttribute("user") == null || !isEnclosureValid(enclosure))return 0;
        enclosure.setUser((User)httpSession.getAttribute("user"));
        enclosure.setAdddate(new Date());
        correctEnclosure(enclosure);
        List<Car> list = new ArrayList();
        for (Car c : enclosure.getCars()){
            Car car = carRepositories.findByCard(c.getCard());
            if(car != null){
                list.add(car);
            }
        }
        enclosure.setCars(new HashSet(list));
        enclosureRepositories.save(enclosure);
        return 1;
    }

    @PostMapping(path = "/delete")
    public String delete(CacheArray<Long> ids){
        enclosureServices.deleteAllById(ids.getList().iterator());
        return "redirect:/warn/enclosure";
    }

    @PostMapping(path = "update")
    public String update(){
        return "";
    }

    private void correctEnclosure(Enclosure enclosure){
        Calendar calendar = Calendar.getInstance();
        Date start = enclosure.getStart();
        Date stop = enclosure.getStop();
        calendar.setTime(start);
        calendar.add(Calendar.HOUR,-8);
        start = calendar.getTime();
        calendar.setTime(stop);
        calendar.add(Calendar.HOUR,-8);
        stop = calendar.getTime();
        enclosure.setStart(start);
        enclosure.setStop(stop);
    }

    private boolean isEnclosureValid(Enclosure enclosure){
        if(enclosure.getName() == null || enclosure.getStart() == null || enclosure.getStop() == null
                || enclosure.getInvalid() == null || enclosure.getValid() == null
                || enclosure.getEnclosuretype() == null || enclosure.getEnclosurewarntype() == null) return false;
        if (enclosure.getStop().compareTo(enclosure.getStart()) < 0 ||
            enclosure.getInvalid().compareTo(enclosure.getValid()) < 0) return false;
        return true;
    }

}
