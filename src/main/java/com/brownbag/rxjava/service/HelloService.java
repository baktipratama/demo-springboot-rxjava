package com.brownbag.rxjava.service;

import com.brownbag.rxjava.model.HelloResponse;
import org.springframework.stereotype.Service;

/**
 * Created by bakti.pratama on 11/21/2016.
 */
@Service
public class HelloService {

  public HelloResponse hello(String name){
    return new HelloResponse("Hello "+name);
  }

}
