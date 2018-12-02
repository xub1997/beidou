package web.controllers;

import business.entity.*;
import business.entity.repositories.CarRepositories;
import business.entity.repositories.CarStopPosRepositories;
import business.entity.repositories.UnitRepositories;
import business.services.CarServices;
import business.util.CacheArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "admin/car")
public class CarController {

    @Autowired
    private CarServices carServices;

    @Autowired
    private UnitRepositories unitRepositories;

    @Autowired
    private CarRepositories carRepositories;

    @Autowired
    private CarStopPosRepositories carStopPosRepositories;

    @ModelAttribute(name = "allCarTypes")
    public List<CarType> populateCarTypes(){return Arrays.asList(CarType.ALL);}

    @ModelAttribute(name = "allProtocol")
    public List<Protocol> populateProtocol(){return Arrays.asList(Protocol.All);}

    @ModelAttribute(name = "allCarStatus")
    public List<CarStatus> populateCarStatus(){return Arrays.asList(CarStatus.ALL);}

    @ModelAttribute(name = "allCars")
    public List<Car> populateCar(){
        /*
        User user = (User)httpSession.getAttribute("user");
        if (user == null) return null;
        if(user.getUserType().getName().equals("ADMIN"))
            return carRepositories.findAll();
        else return carServices.findCarsByUser(user);
        */
        return carRepositories.findAll();
    }

    @ModelAttribute(name = "allUnits")
    public List<Unit> populateUnit(){ return unitRepositories.findAll();}

    @ModelAttribute(name = "ids") public CacheArray<Long> cacheArray(){return new CacheArray<Long>();}

    @RequestMapping
    public String showCars(Car car){ return "car";}

    @PostMapping(path = "/add")
    public String add(@Valid Car car, BindingResult bindingResult,HttpSession session){
        if(bindingResult.hasErrors()){
            return "car";
        }
        if(carServices.ifregistered(car)){
            bindingResult.addError(new FieldError("car","card","the idcard had been registy"));
            return "car";
        }
        car.setAdddate(new Date());
        car.setUser((User)session.getAttribute("user"));
        CarStopPos carStopPos = new CarStopPos(car);
        carStopPos.setPosition(new Position("113.471395","23.1041"));
        car.setCarStopPos(carStopPos);
        carRepositories.save(car);
        return "redirect:/admin/car";
    }

    @PostMapping(path = "/delete")
    public String delete(CacheArray<Long> ids){
        carServices.deleteAllById(ids.getList().iterator());
        return "redirect:/admin/car";
    }
}
