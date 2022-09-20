$("#add").on("click",function(e){
	
	var name=$("#name").val()
	var title=$("#title").val()
	var phone=$("#phone").val()
	var email=$("#email").val()
	var address=$("#address").val()
	var city=$("#city").val()
	var state=$("#state").val()
	var emergencyName=$("#emergencyName").val()
	var emergencyPhone=$("#emergencyPhone").val()
	var relationship=$("#relationship").val()
	var addressObj=""
	if($("#name").val()=="" || $("#name").val()==null)
		name=null
	if($("#title").val()=="" || $("#title").val()==null)
		title=null
	if($("#phone").val()=="" || $("#phone").val()==null)
		phone=null
	if($("#email").val()=="" || $("#email").val()==null)
		email=null
	if($("#address").val()=="" || $("#address").val()==null)
		address=null
	if($("#city").val()=="" || $("#city").val()==null)
		city=null
	if($("#state").val()=="" || $("#state").val()==null)
		state=null
	if($("#emergencyName").val()=="" || $("#emergencyName").val()==null)
		emergencyName=null
	if($("#emergencyPhone").val()=="" || $("#emergencyPhone").val()==null)
		emergencyPhone=null
	if($("#relationship").val()=="" || $("#relationship").val()==null)
		relationship=null
	if(address==null || city==null || state==null){
		addressObj=null
	}
	else{
		addressObj = {
						"address": address,
						"city": city,
						"state": state
					}
	}
	var data = {
				"name":name,
				"title":title,
				"phone":phone,
				"email":email,
				"address":addressObj,
				"emergency":{
								"emergencyName":emergencyName,
								"emergencyPhone":emergencyPhone,
								"relationship":relationship
							}
			  }	
	$.ajax({
		url: "/employee/add",
		type: "POST",
		contentType: 'application/json; charset=utf-8',
		data: JSON.stringify(data),
		success: function(e) {
			if(e.startsWith("Employee")){
				swal("Success",e,"success")
				.then(() => {
						window.location.reload();
					});
			}
			else
				swal("Error",e,"error")			
		}
	})
	
})