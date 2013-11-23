package com.jitterpig.chipper.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;


/**
 *
 */
@Path("/sms")
@Produces(APPLICATION_XML)
public class SmsResource {

  private final Logger _logger = LoggerFactory.getLogger(SmsResource.class);

  @POST
  @Consumes(APPLICATION_FORM_URLENCODED)
  public String incomingMessage(@Context HttpHeaders hh, MultivaluedMap<String, String> formParams) throws Exception {
    MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
    _logger.info("Headers: " + headerParams.toString());
    _logger.info("Form Params: " + formParams.toString());

    _logger.info("Sent from: " + formParams.getFirst("From"));
    _logger.info("Body: " + formParams.getFirst("Body"));

    String messageFormat = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
                             + "<Response>"
                             + "<Message>%s</Message>"
                             + "</Response>";
    String response = "Chip Count is now 23, Reading total is now 95min, 87pg";

    return String.format(messageFormat, response);
  }
}
