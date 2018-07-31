# alexa-skill-handler-service
This is the new Git repository for alexa-skill-handler-service. This service will cater to all requests and responses coming from Alexa interaction model.

## Sample Request and Responses
	Request Example:
		{
		  "version": "1.0",
		  "session": {
		    "new": true,
		    "sessionId": "session1234",
		    "application": {
		      "applicationId": "amzn1.echo-sdk-ams.app.1234"
		    },
		    "attributes": {},
		    "user": {
		      "userId": null
		    }
		  },
		  "request": {
			  "type": "LaunchRequest",
			  "requestId": "1234",
			  "timestamp": "2013-09-29T18:46:19Z",
			  "dialogState": "string",
			  "locale": "string"
			}
		}
	
	Response Example:
	{
	    "version": "1.0",
	    "response": {
	        "shouldEndSession": false,
	        "outputSpeech": {
	            "type": "PlainText",
	            "text": "Welcome to voicelabs"
	        },
	        "reprompt": {}
	    },
	    "sessionAttributes": {}
	}
	
## Collaborating
To collaborate to `alexa-skill-handler-service`, please [create a fork](https://help.github.com/articles/fork-a-repo/) of this repository. This will create your own copy of the repository so you may follow your own workflow to make changes.

Once you have changes, you should *push* them to your *fork* on GitHub and [create a Pull Request](https://help.github.com/articles/cloning-a-repository/) for review. Be sure to choose the appropriate destination branch for this repository. Often this will be a *release* or *feature* branch.

For long-term collaborating, you should add a remote reference to this repository. A common convention is to name this remote `upstream`. You may do so with the following command.

    git remote add upstream 

Whenever your *local* repository grows behind, you can run `git fetch upstream` to gather information about the new changes or branches in this repository. This way, when you are ready to start new work, you can run the following commands to ensure your *local* branch has the latest changes from the `alexa-skill-handler-service` repository.

    git fetch upstream
    git checkout -b feature-12345 upstream/release-branch

For the most part, the workflow above follows [GitHub Flow](https://guides.github.com/introduction/flow/). Please review their introduction for more details and diagrams.


## Additional Help
There are a few changes between SVN and Git. If you have any questions, feel free to ask for help.
