package com.jitterpig.chipper;

import com.jitterpig.chipper.resources.SmsResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 *
 */
public class ChipperService extends Service<ChipperConfiguration> {

  public static void main(String[] args) throws Exception {
    new ChipperService().run(args);
  }

  @Override
  public void initialize(Bootstrap<ChipperConfiguration> bootstrap) {
    bootstrap.setName("Chipper");
  }

  @Override
  public void run(ChipperConfiguration configuration, Environment environment) throws Exception {
    environment.addResource(new SmsResource());
  }
}
