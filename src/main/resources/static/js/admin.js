// Load AJAX
//window.onload = loadPage();

function loadPage() {
	
	axios({
		method: "GET",
		url: "/category"
	})
	.then(response => {
		console.log(response.data)
	})
	.catch(error => {
		console.log(error)
	});
	
}


// Add new product

// Input define
let p_code = document.getElementById('p_code');
let p_name = document.getElementById('p_name');
let p_price = document.getElementById('p_price');
let p_amount = document.getElementById('p_amount');
let p_image = document.getElementById('p_image');

let add = document.getElementById('add');

add.addEventListener('click', addProduct);

function addProduct() {
	let formData = new FormData();
	
	formData.append("file", p_image.files[0]);
	
	let product = {
			productID: 1,
			productCode: 53121,
			productName: "Đắc Nhân Tâm",
			productPrice: 242.2129
	}
	
	formData.append("product", JSON.stringify(product));
		
	// Send a POST request
	axios({
	  method: 'POST',
	  url: '/addnew',
	  headers: {
		  'Content-Type': 'multipart/form-data'
	  },
	  data: formData,
	  withCredentials: true,
	})
	.then((response) => {
		console.log(response.data)
	})
	.catch((error) => {
		console.log(error)
	})
	;
	
}