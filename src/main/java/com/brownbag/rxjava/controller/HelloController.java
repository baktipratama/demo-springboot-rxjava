package com.brownbag.rxjava.controller;

import com.brownbag.rxjava.model.HelloResponse;
import com.brownbag.rxjava.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bakti.pratama on 11/21/2016.
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
  Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

  @Autowired
  HelloService helloService;

  @GetMapping("/{name}")
  public HelloResponse sayHello(@PathVariable String name){
    LOGGER.info("START sayHello Controller");
    HelloResponse response =helloService.hello(name);
    LOGGER.info("FINISH sayHello Controller");
    return response;
  }

}
