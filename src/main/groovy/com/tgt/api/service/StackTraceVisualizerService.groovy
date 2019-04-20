package com.tgt.api.service

import com.tgt.api.dto.User
import com.tgt.api.repository.UserRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

import java.sql.Timestamp

/**
 * Created by z001t7s on 2/21/17.
 */
@Service
@Slf4j
class StackTraceVisualizerService {

    @Autowired
    UserRepository repository;


    void save(User user)
    {
        repository.save(user)
    }


    List<String> get(String appId )
    {
        List<User> users=  repository.getUserByAppId(appId)
        log.info(' No of Stack traces : ' +users.size())
        List<String> list =  new ArrayList<String>()
        for (User user: users)
        {
            list.add(user.stackTrace)
        }
        list
    }


    List<String> getHourBasedStacks(String appId, Timestamp oldTimestamp, Timestamp currentTimeStamp)
    {

        List<User> userList= repository.getHourBasedStacks(appId,oldTimestamp,currentTimeStamp )

        List<String> stackTraceList = new ArrayList<String>()
        for(User user : userList)
        {
            stackTraceList.add(user.getStackTrace())
        }
        stackTraceList

    }

    Set<String> getAllAppId(){
       List<User> userList = repository.findAll()
        Set<String> appIdList = new HashSet<String>()
        for(User user : userList)
        {
            appIdList.add(user.getAppId())
        }
        appIdList
    }
}
