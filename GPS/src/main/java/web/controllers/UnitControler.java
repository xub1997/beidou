package web.controllers;

import business.entity.Unit;
import business.entity.repositories.UnitRepositories;
import business.services.UnitServices;
import business.util.CacheArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import web.conversion.DateConverter;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/unit")
public class UnitControler {

    @Autowired
    private DateConverter converter;

    @Autowired
    private UnitServices unitServices;

    @Autowired
    private UnitRepositories unitRepositories;

    @ModelAttribute(name = "allUnits")
    public List<Unit> populateUnit(){ return unitRepositories.findAll();}

    @ModelAttribute(name = "ids") public CacheArray<Long> cacheArray(){return new CacheArray<Long>();}

    @GetMapping
    public String showUnits(Unit unit){return "unit";}

    @PostMapping(path = "/add")
    public String add(@Valid Unit unit, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "unit";
        }
        if(unitServices.ifregistered(unit)){
            bindingResult.addError(new FieldError("unit","phone","The phone has been registered"));
            return "unit";
        }
        unit.setAdddate(new Date());
        unitRepositories.save(unit);
        return "redirect:/admin/unit";
    }

    @PostMapping(path = "/delete")
    public String delete(CacheArray<Long> ids){
        unitServices.deleteAllById(ids.getList().iterator());
        return "redirect:/admin/unit";
    }


}
