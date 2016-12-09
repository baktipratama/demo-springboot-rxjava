package com.brownbag.rxjava.service;

import com.brownbag.rxjava.model.HelloResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Completable;
import rx.Single;
import rx.functions.Func1;

/**
 * Created by bakti.pratama on 11/21/2016.
 */
@Service
public class HelloService {
  Logger LOGGER = LoggerFactory.getLogger(HelloService.class);

  @Autowired
  OkService okService;

  public Single<HelloResponse> hello(String name) {
    return okService.user().map(hasilFindOk -> new HelloResponse(hasilFindOk)
    );
  }

  public Single<Integer> getRole(String name) {
    return okService.user().flatMap(new Func1<String, Single<? extends Integer>>() {
      @Override
      public Single<? extends Integer> call(String user) {
        return okService.role(user);
      }
    });
  }

  public Single<Integer> getRoleLamda(String name) {
    return okService.user().flatMap(user -> okService.role(user));
  }

  public Single<HelloResponse> helloFlatMap(String name) {
    //HelloResponse(user+" "+role)
    //10s, 9s
    return okService.user().flatMap(
        user -> okService.role().map(
            role -> new HelloResponse(user + " " + role))
    );
  }

  public Single<HelloResponse> helloFlatMapFromCompletable(String name) {
    //HelloResponse(user+" "+role)
    //10s, 9s
    return okService.user().flatMap(
        user -> callRest().toSingle(
            () -> new HelloResponse(""))
    );
  }

  public Single<HelloResponse> helloZip(String name) {
    //HelloResponse(user+" "+role)
    //10s, 9s
    return Single.zip(okService.user(), okService.role(),
        (user, role) -> new HelloResponse(user + " " + role));
  }

  public Completable callRest() {
    return Completable.create(subscriber -> {
          LOGGER.info("Process Rest");
          subscriber.onCompleted();
        }
    );
  }

}
