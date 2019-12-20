window.onload = loginAction();

function loginAction() {
    let login_btn = document.getElementById('login-btn');
    login_btn.addEventListener('click', login);

    function login() {
        let email = document.getElementById('email');
        let password = document.getElementById('password');

        let url = '/login';

        let AuthRequest = {
            email: email.value,
            password: password.value
        }

        console.table(AuthRequest);

//        fetch(url,{
//                method: 'POST',
//                headers: {
//                    'Content-Type': 'application/json;charset=utf-8'
//                  },
//                body: JSON.stringify(AuthRequest)
//            })
//            .then((data) => {
//                console.log(data);
//            })
//            .catch((error) => {
//                console.log(error);
//            })
        
     // Send a POST request
        axios({
          method: 'post',
          url: url,
          headers: {'Content-Type': 'application/json'},
          data: AuthRequest
        })
        .then((response) => {
        	console.log(response.data)
        })
        .catch((error) => {
        	console.log(error)
        });
            

    }

}

function validateInput() {

}