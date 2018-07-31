package com.voicelabs.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.SpeechletV2;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

/**
 * This class in an handler class which would cater to all events generated from the alexa device
 * @author anubh
 *
 */
@Component
public class RequestHandler implements SpeechletV2 {
	
    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);    

    /**
     * This method creates a response without any directive
     * @param speech
     * @param intent
     * @return
     */
    public SpeechletResponse getSpeechletResponseWithoutAnyDirective(String speech, boolean shouldSessionEnd, String title, String contentForCard) {
	    SpeechletResponse response = new SpeechletResponse();
	    SimpleCard card = new SimpleCard();
		PlainTextOutputSpeech plainTextOutputSpeech = new PlainTextOutputSpeech();
		plainTextOutputSpeech.setText(speech);
		response.setReprompt(new Reprompt());
	    response.setOutputSpeech(plainTextOutputSpeech);
	    response.setNullableShouldEndSession(shouldSessionEnd);
	    card.setTitle(title);
		card.setContent(contentForCard);
		response.setCard(card);
	    return response;  
	}
    
	public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		logger.debug("Inside On Intent request");
		return getSpeechletResponseWithoutAnyDirective("Hello World",true,"Hello World","Hello World");
	}
	 /**
	  * This method is invoked when the skill is launched
	  */
	public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
		logger.debug("Inside launch request");
		return getSpeechletResponseWithoutAnyDirective("Hello World",true,"Hello World","Hello World");
	}
	public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {

	}
	public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {

	}
}