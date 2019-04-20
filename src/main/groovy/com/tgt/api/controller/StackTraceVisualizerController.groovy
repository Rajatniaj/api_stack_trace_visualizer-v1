package com.tgt.api.controller;

import com.tgt.api.dto.User;
import com.tgt.api.service.StackTraceVisualizerService
import com.tgt.api.util.StackTraceVisualizerUtil
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType
import java.sql.Timestamp

/**
 * Created by z001t7s on 2/20/17.
 */

@RestController
@RequestMapping('stacktrace')
@Slf4j
 class StackTraceVisualizerController {

    @Autowired
    StackTraceVisualizerService visualizerService


    @Produces(MediaType.TEXT_HTML)
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity get(@RequestParam Map<String, String> queryParameters

    ) {

        String userId=   queryParameters.get('userID')
        String appId = queryParameters.get('appId')

      String graphHtml =  StackTraceVisualizerUtil.generateFlameGraph(visualizerService.get(appId),'src/main/resources/folded_stacks')


        return  ResponseEntity.ok().body(graphHtml)

    }

    @RequestMapping(method=RequestMethod.POST)
    ResponseEntity postStackTraces(@RequestBody User user) {
        user.setDate(new Date())
        user.setTimestamp(new Timestamp(System.currentTimeMillis()))
        visualizerService.save(user)

        return new ResponseEntity(HttpStatus.CREATED)
    }

    @RequestMapping(value="/appId", method=RequestMethod.GET)
    Set<String> getAllAppId()
    {
        visualizerService.getAllAppId()
    }

    @RequestMapping(value="/appId/timeInHour", method=RequestMethod.GET)
    String getHourBasedFlamegraph(@RequestParam Map<String, String> queryParameters)
    {
        String time = queryParameters.get('time_in_hour')
        long olderTime = System.currentTimeMillis() - Integer.valueOf(time)*60*60*1000;

        List<String> allStacks =  visualizerService.getHourBasedStacks(queryParameters.get('appId') ,new Timestamp(olderTime),new Timestamp(System.currentTimeMillis()))

        String graphHtml =  StackTraceVisualizerUtil.generateFlameGraph(allStacks,'src/main/resources/folded_stacks')
        return  ResponseEntity.ok().body(graphHtml)

    }

 }