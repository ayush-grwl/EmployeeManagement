$(document).ready(function(){
	
	getData($("#limitSelect").val())
	
})

function getData(limit){
	
	$.ajax({
		url: "/employee/list/"+limit,
		type: "GET",
		dataType:"json",
		success: function(e) {
			var output=""
			for(var i=0;i<e.length;i++){
				var name=e[i].emergency.emergencyName
				var phone=e[i].emergency.emergencyPhone
				var relationship=e[i].emergency.relationship
				if(name==null || name=="")
					name="-"
				if(phone==null || phone=="")
					phone="-"
				if(relationship==null || relationship=="")
					relationship="-"
				output += "<tr>"+
							"<td>"+(i+1)+"</td>"+
							"<td>"+e[i].name+"</td>"+
							"<td>"+e[i].title+"</td>"+
							"<td>"+e[i].phone+"</td>"+
							"<td>"+e[i].email+"</td>"+
							"<td>"+e[i].address.address+"</td>"+
							"<td>"+e[i].address.city+"</td>"+
							"<td>"+e[i].address.state+"</td>"+
							"<td>"+name+"</td>"+
							"<td>"+phone+"</td>"+
							"<td>"+relationship+"</td>"+
						  "</tr>"
			}	
			$("#tbody").html(output)		
		}
	})
	
}

function limitChange(){
	
	getData($("#limitSelect").val())
	
}