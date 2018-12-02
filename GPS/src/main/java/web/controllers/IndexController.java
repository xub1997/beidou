package web.controllers;

import business.entity.Car;
import business.entity.User;
import business.entity.repositories.CarRepositories;
import business.services.CarServices;
import business.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
public class IndexController {

    private User user;

   @Autowired
   private UserServices userServices;

   @Autowired
   private CarServices carServices;

   @ModelAttribute(name = "allUserCars")
   public List<Car> populateUserCars(){return carServices.findCarsByUser(user);}

    @RequestMapping(path = "/index")
    public String indexPage(HttpSession httpSession){
        if (httpSession.getAttribute("user") == null) return "redirect:/login";
        else this.user = (User)httpSession.getAttribute("user");
        return "index";
    }

    @GetMapping(path = {"/","/login"})
    public String loginUser(User user){
        return "login";
    }

    @PostMapping(path = "/login", params = "login")
    public String checkUser(@Valid User user, BindingResult bindResult, HttpSession httpSession) throws Exception {
        if(bindResult.hasErrors()){
            return "login";
        }
        if(!userServices.ifexists(user)){
            bindResult.addError(new FieldError("user","psw","loginname or password error"));
            return "login";
        }
        httpSession.setMaxInactiveInterval(1800);//半小时过期
        httpSession.setAttribute("user",userServices.findSoleUserByName(user.getName()));
        return "index";
    }

    @RequestMapping(path = "/logout")
    public String removeUser(HttpSession httpSession, @SessionAttribute User user){
        httpSession.removeAttribute("user");
        httpSession.invalidate();
        return "redirect:/login";
    }

}
