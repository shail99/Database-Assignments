<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assignment 5</title>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
</head>
<body>
		<h1>JPA JWS Assignment</h1>
		<script>
		$(function()
				{
					//alert("Hello from JQuery");
					
					var site = 
					{
						id: 7,
						name: "Site shailesh",
						latitude: 12.13,
						longitude: 93.34
					};
					
					//createSite(site);					
					//removeSite(5);
					updateSite(7,site);
				});
		
		function updateSite(id, site)
		{
			$.ajax(
			{
				url: "api/site/"+id,
				data: JSON.stringify(site),
				type: "put",
				dataType: "json",
				contentType: "application/json",
				success: function(response) {
					console.log(response);
				},
				error: function(response) {
					console.log(response);
				}
			});
		}
		
		function removeSite(id)
		{
			$.ajax(
			{
				url: "api/site/"+id,
				type: "delete",
				dataType: "json",
				contentType: "application/json",
				success: function(response) {
					console.log(response);
				},
				error: function(response) {
					console.log(response);
				}
			});
		}
		
		function createSite(site)
		{
			$.ajax(
			{
				url: "api/site",
				data: JSON.stringify(site),
				type: "post",
				dataType: "json",
				contentType: "application/json",
				success: function(response) {
					console.log(response);
				},
				error: function(response) {
					console.log(response);
				}
			});
		}
		
		</script>
</body>
</html>