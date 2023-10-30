package com.SpringBootAPIUsages.SpringBootAPIUsages.ControllerLayer;

import com.SpringBootAPIUsages.SpringBootAPIUsages.ServiceLayer.ServiceLayer;
import com.SpringBootAPIUsages.SpringBootAPIUsages.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ControllerLayer {


    @Autowired
    public ServiceLayer serviceLayerObj;




    //This layer contains the endpoints of API's

    @PostMapping("/addUserViaReqBody")
    public String addUser(@RequestBody UserInfo obj) {

        String ans = serviceLayerObj.addUser(obj);
        return ans;
    }



    @GetMapping("/findAllUsers")
    public List<UserInfo> findAllUsers() {
            List<UserInfo> ansList = serviceLayerObj.getAllUsers();
            return ansList;
    }

    @GetMapping("/getUsers/{greaterAge}/{lessThanAge}")
    public List<UserInfo> getUsers(@PathVariable("greaterAge")int greaterAge, @PathVariable("lessThanAge")int lessThanAge) {

        List<UserInfo> ansList = serviceLayerObj.getFilterAgePeople(lessThanAge,greaterAge);
        return ansList;
    }

    @GetMapping("/findOnlyNames")
    List<String> getNamesOfRegisteredPeople() {

        List<String> finalNames = serviceLayerObj.getNames();

        return finalNames;

    }

}