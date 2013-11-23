package com.jitterpig.chipper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 */
public class ChipperConfiguration extends Configuration {

  @NotEmpty
  @JsonProperty
  private String twilioApiKey;
}
