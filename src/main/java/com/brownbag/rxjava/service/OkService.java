package com.brownbag.rxjava.service;

import rx.Single;

/**
 * Created by bakti.pratama on 12/9/2016.
 */
public class OkService {

  public Single<String> user(){
    //Find Repository
    return Single.just("Ok");
  }

  public Single<Integer> role(String user){
    //Find Repository
    return Single.just(user.length());
  }

  public Single<Integer> role(){
    //Find Repository
    return Single.just(1);
  }

}
