
<html lang="en">
<head>
	<script src="scripts/jquery.js"></script>
	<script src="scripts/jquery.validate.js"></script>
	<script>
	$(function() {
		$("#login").validate()
	});
	</script>
</head>

<body>

		<form action="http://www.yahoo.com" id="login">

				email:
						<input id="email" name="email" class="text required email" type="text">
				<br>		
				password:	
             <input name="password" type="password" class="text required" id="password" minlength="4" maxlength="20">
				<br>
				     <input type="submit" class="button" value="Login...">
			
		
		</form>

</body>
</html>
