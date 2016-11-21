package com.brownbag.rxjava.model;

/**
 * Created by bakti.pratama on 11/21/2016.
 */
public class HelloResponse {
  String message;

  public HelloResponse(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
