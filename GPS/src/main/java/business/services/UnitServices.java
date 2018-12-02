package business.services;

import business.entity.Unit;
import business.entity.repositories.UnitRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class UnitServices  {

    @Autowired
    private UnitRepositories unitRepositories;

    public boolean ifregistered(Unit unit) {
        return unitRepositories.findUnitByName(unit.getPhone()).size() >= 1;
    }

    public void deleteAllById(Iterator<?> idlist) {
        while(idlist.hasNext()){
            unitRepositories.deleteById(Long.valueOf(Long.parseLong((String) idlist.next())));//从String转long再转Long
        }
    }


}
