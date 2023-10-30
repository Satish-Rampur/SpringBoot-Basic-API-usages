package com.SpringBootAPIUsages.SpringBootAPIUsages.ServiceLayer;

import com.SpringBootAPIUsages.SpringBootAPIUsages.RepositoryLayer.RepositoryLayer;
import com.SpringBootAPIUsages.SpringBootAPIUsages.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer {


    @Autowired
    private RepositoryLayer repositoryLayerObj;


    public String addUser(UserInfo userInfo){

        String result = repositoryLayerObj.addUserToDb(userInfo);
        return result;
    }

    public List<UserInfo> getAllUsers(){

        List<UserInfo> ansList = repositoryLayerObj.getAllUsers();
        return ansList;
    }


    public List<UserInfo> getFilterAgePeople(int lessAge,int greaterAge) {

        List<UserInfo> allUsers = repositoryLayerObj.getAllUsers();

        //Filtering part

        List<UserInfo> ansList = new ArrayList<>();

        for(UserInfo userInfo:allUsers) {
            if(userInfo.getAge()>=greaterAge && userInfo.getAge()<= lessAge){
                ansList.add(userInfo);
            }
        }
        return ansList;
    }

    public List<String> getNames(){

        List<UserInfo> allUsers = repositoryLayerObj.getAllUsers();

        List<String> namesList = new ArrayList<>();

        for(UserInfo info : allUsers){
            namesList.add(info.getName());
        }
        return namesList;


    }




}