package com.voicelabs.configuration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.amazon.speech.Sdk;
import com.amazon.speech.speechlet.servlet.SpeechletServlet;
import com.voicelabs.handler.RequestHandler;

/**
 * This class is the servlet class which acts as a front controller, All the requests coming from the alexa devices
 *  would be processed by this servlet
 * @author anubhav
 *
 */
@Configuration
@Configurable
@WebServlet("/v1/voicelabs/handler")
public class ApplicationSpeechServlet extends SpeechletServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(ApplicationSpeechServlet.class);    

	@Autowired
	private RequestHandler requestHandler;

	/**
	 * Disabling signature verification for development 
	 */
	 static { 
		 setSignatureValidation();
	 } 	
	
	private static void setSignatureValidation() {
		Boolean checkSignature = false;
	 	logger.info("Configuring the Signature Validation");	 
        //checkSignature = Boolean.parseBoolean(System.getenv(Constants.APP_SIGNATURE_VALIDATION));
	 	logger.info("Signature Validation Check in Environment is {}", checkSignature);
        if(checkSignature) {
			System.setProperty(Sdk.DISABLE_REQUEST_SIGNATURE_CHECK_SYSTEM_PROPERTY, "false"); 
			System.setProperty(Sdk.SUPPORTED_APPLICATION_IDS_SYSTEM_PROPERTY, ""); 
			System.setProperty(Sdk.TIMESTAMP_TOLERANCE_SYSTEM_PROPERTY, "150");
        }else {
			System.setProperty(Sdk.DISABLE_REQUEST_SIGNATURE_CHECK_SYSTEM_PROPERTY, "true"); 
        }
	 	logger.info("Signature Validation Configured");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	    this.setSpeechlet(requestHandler);
	}
}