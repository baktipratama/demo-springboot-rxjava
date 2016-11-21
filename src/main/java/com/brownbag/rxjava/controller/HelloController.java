package com.brownbag.rxjava.controller;

import com.brownbag.rxjava.model.HelloResponse;
import com.brownbag.rxjava.service.HelloService;
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

  @Autowired
  HelloService helloService;

  @GetMapping("/{name}")
  public HelloResponse sayHello(@PathVariable String name){
    return helloService.hello(name);
  }

}
