package com.SpringBootAPIUsages.SpringBootAPIUsages.RepositoryLayer;

import com.SpringBootAPIUsages.SpringBootAPIUsages.UserInfo;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public
class RepositoryLayer {

    Map<Integer, UserInfo> userInfoDb = new HashMap<>();

    public String addUserToDb(UserInfo obj) {

        int key = obj.getUserId();
        userInfoDb.put(key,obj);

        return "The user has been added via Postman Object";
    }


    public List<UserInfo> getAllUsers(){

        //Getting the values (Objects) and creating a list out of them
        return userInfoDb.values().stream().toList();

    }


}