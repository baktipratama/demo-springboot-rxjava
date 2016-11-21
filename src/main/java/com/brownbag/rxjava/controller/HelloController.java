package com.brownbag.rxjava.controller;

import com.brownbag.rxjava.model.HelloResponse;
import com.brownbag.rxjava.service.HelloService;
import com.brownbag.rxjava.subscriber.DeferredSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Subscriber;
import rx.schedulers.Schedulers;

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
  public DeferredResult<HelloResponse> sayHello(@PathVariable String name){
    LOGGER.info("START sayHello Controller");
    DeferredResult<HelloResponse> result = new DeferredResult<>();
    helloService.hello(name).subscribeOn(Schedulers.io()).observeOn(Schedulers.computation()).subscribe(new DeferredSubscriber<>(result));
    LOGGER.info("FINISH sayHello Controller");
    return result;
  }

}
