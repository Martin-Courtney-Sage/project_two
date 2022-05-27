var questionNum = 0;                            // keep count of question, used for IF condition.
var question = "<p> Hi welcome!</p>";	// first question

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
        var questionOne = "How can I help you today?";

        div.className = 'row';

		// fname is the stored information from the login

        div.innerHTML = "<p>" + questionOne + "</p>";

        document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
	} 
	
	if (questionNum == 1 && (['account', 'accounts',].indexOf(answer) >= 0)) {
		var div = document.createElement('div');
       
        div.className = 'row';

        div.innerHTML = "<p> So you are looking for " + answer + ", right?</p>";
		document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
		questionNum = 2
	} else if (questionNum == 2 && (['yes', 'yup', 'yeah', 'y', 'correct', 'right',].indexOf(answer) >= 0)){
			var div = document.createElement('div');
			question = "Let me help you navigate there: ";
			div.className = 'row';

			div.innerHTML = "<p> "+ question + "<a href='user-profile.html'>please check out Account page</a>" + "</p>";
	
			document.getElementById('output').appendChild(div); // output response 
			document.getElementById("usermsg").value = ""; // clear text box
	} else  if (questionNum == 2 && (['no', 'nope', 'nah', 'n', 'incorrect', 'wrong',].indexOf(answer) >= 0)){
		var div = document.createElement('div');

        div.className = 'row';

        div.innerHTML = "<p> so, what were you looking to do...?</p>";

        document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
	} 

	if (questionNum == 1 && (['deposit', 'withdraw', 'withdrawal', 'transfer', 'funds', 'balance',].indexOf(answer) >= 0)) {
		var div = document.createElement('div');
       
        div.className = 'row';

        div.innerHTML = "<p> So you are looking for " + answer + ", right?</p>";
		document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
		questionNum = 3
	} else if (questionNum == 3 && (['yes', 'yup', 'yeah', 'y', 'correct', 'right',].indexOf(answer) >= 0)){
			var div = document.createElement('div');
			question = "Let me help you navigate there: ";
			div.className = 'row';

			div.innerHTML = "<p> "+ question + "<a href='user-profile.html'>That can be done in your Profile page</a>" + "</p>";
	
			document.getElementById('output').appendChild(div); // output response 
			document.getElementById("usermsg").value = ""; // clear text box
	} else  if (questionNum == 3 && (['no', 'nope', 'nah', 'n', 'incorrect', 'wrong',].indexOf(answer) >= 0)){
		var div = document.createElement('div');

        div.className = 'row';

        div.innerHTML = "<p> so, what were you looking to do...?</p>";

        document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
	}

	if (questionNum == 1 && (['request', 'credit', 'job', 'loan', 'requests', 'credit request', 'job request', 'loan request'].indexOf(answer) >= 0)) {
		var div = document.createElement('div');
       
        div.className = 'row';

        div.innerHTML = "<p> So you are looking for " + answer + ", right?</p>";
		document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
		questionNum = 4
	} else if (questionNum == 4 && (['yes', 'yup', 'yeah', 'y', 'correct', 'right',].indexOf(answer) >= 0)){
			var div = document.createElement('div');
			question = "Let me help you navigate there: ";
			div.className = 'row';

			div.innerHTML = "<p> "+ question + "<a href='request-page.html'>please check out Request page</a>" + "</p>";
	
			document.getElementById('output').appendChild(div); // output response 
			document.getElementById("usermsg").value = ""; // clear text box
	} else  if (questionNum == 4 && (['no', 'nope', 'nah', 'n', 'incorrect', 'wrong',].indexOf(answer) >= 0)){
		var div = document.createElement('div');

        div.className = 'row';

        div.innerHTML = "<p> so, what were you looking to do...?</p>";

        document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
	}

	if (questionNum == 1 && (['help', 'login', 'home', 'user',].indexOf(answer) >= 0)) {
		var div = document.createElement('div');
       
        div.className = 'row';

        div.innerHTML = "<p> So you are looking for " + answer + ", right?</p>";
		document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
		questionNum = 5
	} else if (questionNum == 5 && (['yes', 'yup', 'yeah', 'y', 'correct', 'right',].indexOf(answer) >= 0)){
			var div = document.createElement('div');
			question = "Let me help you navigate there: ";
			div.className = 'row';

			div.innerHTML = "<p> "+ question + "<a href='help.html'>please check out the Help page</a>" + "</p>";
	
			document.getElementById('output').appendChild(div); // output response 
			document.getElementById("usermsg").value = ""; // clear text box
	} else  if (questionNum == 5 && (['no', 'nope', 'nah', 'n', 'incorrect', 'wrong',].indexOf(answer) >= 0)){
		var div = document.createElement('div');

        div.className = 'row';

        div.innerHTML = "<p> so, what were you looking to do...?</p>";

        document.getElementById('output').appendChild(div); // output response 
		document.getElementById("usermsg").value = ""; // clear text box
	}

}

// press enter to submit in pure javascript