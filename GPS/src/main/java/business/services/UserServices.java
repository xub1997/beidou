package business.services;

import business.entity.User;
import business.entity.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepositories userRepositories;

    public boolean ifexists(User user){
        List<User> users = userRepositories.findUserByNameAndPsw(user.getName(), user.getPsw());
        return users.size() == 1;
    }

    public boolean ifregistered(User user){
        return userRepositories.findUserByName(user.getName()).size() >= 1;
    }

    public void deleteAllById(Iterator<? extends Object> idlist){
        while(idlist.hasNext()){
            userRepositories.deleteById(Long.valueOf(Long.parseLong((String) idlist.next())));//从String转long再转Long
        }
    }

    public User findSoleUserByName(String name) throws Exception {
        List<User> list = userRepositories.findUserByName(name);
        if (list.size() > 1){
            throw new Exception(list.size()+" users have the same name,Please clear them");
        }
        if(list.size() <= 0){
            throw new Exception(list.size()+" can not find user which name: "+ name);
        }
        return list.get(0);
    }

}
