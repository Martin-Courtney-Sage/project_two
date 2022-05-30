
async function LogIn(){

	// get each values from the inputs in the login section [must had an ID]

	let user = document.getElementById("email").value;
	let psw = document.getElementById("passcode").value;


	// fetch all employees and create log of the arrays

	console.log(user + " " + psw);
	const headers = new Headers();
	// headers.set('Authorization',user + ":" + psw);
	const url = "http://127.0.0.1:5000/users"
	const httpresponse = await fetch(url);
	const body = await httpresponse.json()
	console.log(body);


	// loops through the log of employees, checking if the user's email and password comnbination coexist
	// in the same set of information
	let correct = false;
	let info = null;

		for(let l of body){
			if(l.email == user && l.passcode == psw) {
				info = l;
				correct = true;
				console.log(info)
				break;
			}else if(user == '' || psw == '') {
				correct = false;
				info = null;
				console.log(info)
				break;
			}else {
				console.log("Failure");
			}
		}

		console.log(correct);
           if(correct){
			   // saves the information into session [keeps the employee information for the next page]
            sessionStorage.setItem("userID", info.user_id);
            sessionStorage.setItem("firstName", info.first_name);
            sessionStorage.setItem("lastName", info.last_name);
            sessionStorage.setItem("email", info.email);
            sessionStorage.setItem("passcode", info.passcode);
            window.location = "[membership page -- user or admin]";
           } else {
             alert("Please try again - Log in failure");
            console.log("Failure"); 
           }
}



