package com.brownbag.rxjava.service;

import com.brownbag.rxjava.model.HelloResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rx.Completable;
import rx.Single;
import rx.schedulers.Schedulers;

/**
 * Created by bakti.pratama on 11/21/2016.
 */
@Service
public class HelloService {
  Logger LOGGER = LoggerFactory.getLogger(HelloService.class);

  public Single<HelloResponse> hello(String name){
    return Single.create(singleSubscriber -> {
      LOGGER.info("START sayHello Service");
      HelloResponse response = new HelloResponse("Hello "+name);
      callRest().subscribeOn(Schedulers.io()).subscribe();
      LOGGER.info("FINISH sayHello Service");
      singleSubscriber.onSuccess(response);
    });
  }

  public Completable callRest(){
    return Completable.create(subscriber -> {
      LOGGER.info("Process Rest");
      subscriber.onCompleted();
    }
    );
  }
}
