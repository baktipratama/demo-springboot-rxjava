package com.brownbag.rxjava.service;

import com.brownbag.rxjava.model.HelloResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by bakti.pratama on 11/21/2016.
 */
@Service
public class HelloService {
  Logger LOGGER = LoggerFactory.getLogger(HelloService.class);

  public HelloResponse hello(String name){
    LOGGER.info("START sayHello Service");
    HelloResponse response = new HelloResponse("Hello "+name);
    LOGGER.info("FINISH sayHello Service");
    return response;
  }

}
