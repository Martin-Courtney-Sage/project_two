var questionNum = 0;                            // keep count of question, used for IF condition.
var question = "<p> Hi welcome! How can I help you?</p>";	// first question

var output = document.getElementById('output');	// store id="output" in output variable
output.innerHTML = "<h4>" + question + "</h4>"; 

function bot() {
	var answer = document.getElementById("usermsg").value;
	var input = document.getElementById('input');
	var div = document.createElement('div');

	div.className = 'rowTwo';

	div.innerHTML = " " + document.getElementById("usermsg").value;
    document.getElementById('input').appendChild(div); // output response



	// create an array of tasks to complete and navigate
	// cycle through the array to see if the input the user submitted is in there
	// clarify if that is what they want
	// proceed with task

	if (questionNum == 0) {
		var div = document.createElement('div');
        question = "How can I help you today?";

        div.className = 'row';

		// fname is the stored information from the login

        div.innerHTML = "<p> hey " + fname + ", . " + question + "?</p>";

        document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box

	} else if (questionNum == 1) {
		var div = document.createElement('div');
       
        div.className = 'row';

        div.innerHTML = "<p> So you are looking to " + keyword + ", right?</p>";

        document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
	}

	if (questionNum == 2 && (['yes', 'yup', 'yeah', 'y', 'correct', 'right',].indexOf(answer) >= 0)) {
		var div = document.createElement('div');
		question = "Great! Let me help you navigate there";

		// links and window.location changes

        div.className = 'row';

        div.innerHTML = "<p>Is there anything else I can help you with " + question + "?</p>";

        document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
	} else if (questionNum == 2 && (['no', 'nope', 'nah', 'n', 'incorrect', 'wrong',].indexOf(answer) >= 0)) {
		var div = document.createElement('div');

        div.className = 'row';

        div.innerHTML = "<p> so, what were you looking to do...[examples] ?</p>";

        document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
	}

	else if (questionNum == 4) {
		var div = document.createElement('div');
		question = "Question five";

        div.innerHTML = "<h2>thanks for chatting!</h2>";

        document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
	}
}

// figure out on click of send button -- right now its just when key enter is pressed

$(document).keypress(function(e) {
    if (e.which == 13) {
    			    //increase questionNum count by 1
    }
});