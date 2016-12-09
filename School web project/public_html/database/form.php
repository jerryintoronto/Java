

<div style = 'text-align: center'>


<h3>Database Installation </h3><br>

		<form  action="<?php echo $_SERVER['PHP_SELF'] ?>" method="POST" name="installdb">
		
				Database Hostname <br>
				<input type="text" name="inputHOSTNAME" placeholder="Localhost?"><br>
				
				Database Name<br>
				<input type="text" name="inputDBNAME" placeholder="Anything in WAMP"><br>

				Database Username<br>
				<input type="text" name="inputDBUSERNAME" placeholder="root?"><br>

				DB Password<br>
				<input type="password" name="inputDBPASSWORD" placeholder="Database Password"><br>

				<br>
				<button id="submit" name="submit" type="submit">Create!</button>
		
		</form>
		<br><button onclick='location.href="../index.php"'>Back</button>
</div>