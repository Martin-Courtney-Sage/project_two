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

	if (questionNum == 0) {
		var div = document.createElement('div');
        question = "how old are you";

        div.className = 'row';

        div.innerHTML = "<p> hey " + answer + ", i'm chattybot. " + question + "?</p>";

        document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box

	} else if (questionNum == 1) {
		var div = document.createElement('div');
       
        div.className = 'row';

        div.innerHTML = "<p> that means you were born in " + (2017 - answer) + ", right?</p>";

        document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
	}

	if (questionNum == 2 && (['yes', 'yup', 'yeah', 'y', 'correct', 'right',].indexOf(answer) >= 0)) {
		var div = document.createElement('div');
		question = "when is your birthday";

        div.className = 'row';

        div.innerHTML = "<p> that's great! " + question + "?</p>";

        document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
	} else if (questionNum == 2 && (['no', 'nope', 'nah', 'n', 'incorrect', 'wrong',].indexOf(answer) >= 0)) {
		var div = document.createElement('div');

        div.className = 'row';

        div.innerHTML = "<p> so, what year where you born?</p>";

        document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
	}

	if (questionNum == 3) {
		var div = document.createElement('div');
		question = "Question four";

        div.className = 'row';

        div.innerHTML = "<p> goodbye.</p>";

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

$(document).keypress(function(e) {
    if (e.which == 13) {
    bot();						//run bot function when enter key pressed
    questionNum++;			    //increase questionNum count by 1
    
    }
});