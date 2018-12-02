package web.controllers;

import business.entity.User;
import business.entity.UserType;
import business.entity.repositories.UserRepositories;
import business.services.UserServices;
import business.util.CacheArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(path = "/admin/user")
public class UserContorller implements WebMvcConfigurer{

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepositories userRepositories;

    @ModelAttribute(name = "allUsers")
    public List<User> populateUsers(){return userRepositories.findAll();}

    @ModelAttribute(name = "allUserTypes")
    public List<UserType> populateUsersType(){return Arrays.asList(UserType.ALL);}


    @RequestMapping
    public String showUsers(@ModelAttribute(name = "ids") CacheArray<Long> ids){
        return "user";
    }

    @GetMapping(path = "/add")
    public String showAdduser(final User user){
        return "adduser";
    }

    @PostMapping(path = "/add")
    public String add(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "adduser";
        }
        if (userServices.ifregistered(user)){
            bindingResult.addError(new FieldError("user","psw","the user name has been used"));
            return "adduser";
        }
        userRepositories.save(user);
        return "redirect:/admin/user";
    }

    @PostMapping(path = "/delete")
    public String delete(CacheArray<Long> ids){
        userServices.deleteAllById(ids.getList().iterator());
        return "redirect:/admin/user";
    }

    @GetMapping(path = "/update")
    public String showfrom(final User user){return "psw";}

    @PostMapping(path = "/update")
    public String uptade(CacheArray<String> ids, HttpSession httpSession, BindingResult bindingResult){
        User user1 = (User) httpSession.getAttribute("user");
        if (!ids.getList().get(0).equals(user1.getPsw())){
            return "redirect:/admin/user";
        }
        userRepositories.updatePswById(ids.getList().get(1),user1.getId());
        return "redirect:/admin/user";
    }
}
