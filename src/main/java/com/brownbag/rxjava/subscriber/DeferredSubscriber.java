package com.brownbag.rxjava.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Subscriber;

/**
 * Created by bakti.pratama on 11/21/2016.
 */
public class DeferredSubscriber<T> extends Subscriber<T> {
  Logger LOGGER = LoggerFactory.getLogger(DeferredSubscriber.class);

  private DeferredResult<T> result;

  public DeferredSubscriber(DeferredResult<T> result) {
    this.result = result;
  }

  @Override
  public void onCompleted() {
    LOGGER.info("Suscriber Completed");
  }

  @Override
  public void onError(Throwable e) {
    LOGGER.info("Suscriber Error");
    result.setErrorResult(e);
  }

  @Override
  public void onNext(T o) {
    LOGGER.info("Suscriber Success");
    result.setResult(o);
  }
}
