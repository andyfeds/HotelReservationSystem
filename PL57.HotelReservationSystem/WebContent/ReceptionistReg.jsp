<html>
<head>
<title> registration </title>
</head>

<body>
<form action="ReceptionistReg" method="post" >
	<div>
		<div>
			<div>FIRST NAME</div>
			<div><input type="text" name="First_Name" maxlength="30"/>
			(max 30 characters a-z and A-Z)
			</div>
		</div>
		
		<div>
			<div>LAST NAME</div>
			<div><input type="text" name="Last_Name" maxlength="30"/>
			(max 30 characters a-z and A-Z)
			</div>
		</div>
		
		<div>
			<div>DATE OF BIRTH</div>
			<div><input type="text" name="dob" maxlength="30"/>
			(max 30 characters a-z and A-Z)
			</div>
		</div>
		
		<div>
			<div>EMAIL ID</div>
			<div><input type="text" name="Email_Id" maxlength="100" /></div>
		</div>
		
		<div>
			<div>PASSWORD</div>
			<div><input type="text" name="Password" maxlength="100" /></div>
		</div>
		
		<div>
			<div>CONFIRM PASSWORD</div>
			<div><input type="text" name="C_Password" maxlength="100" /></div>
		</div>
		
		<div>
			<div>MOBILE NUMBER</div>
			<div><input type="text" name="Mobile_Number" maxlength="10" />
			(10 digit number)
			</div>
		</div>

		<div>
			<div>GENDER</div>
			<div>
				Male <input type="radio" name="Gender" value="M" />
				Female <input type="radio" name="Gender" value="F" />
			</div>
		</div>
		
		<div>
			<div>ADDRESS</div>
			<div><textarea name="Address" rows="4" cols="30"></textarea></div>
		</div>
		
		<div>
			<div>CITY</div>
			<div><input type="text" name="City" maxlength="30" /></div>
		</div>
		
		<div>
			<div>PIN CODE</div>
			<div><input type="text" name="Pin_Code" maxlength="6" />
			(6 digit number)
			</div>
		</div>
		
		<div>
			<div>STATE</div>
			<div><input type="text" name="State" maxlength="30" />
			(max 30 characters a-z and A-Z)
			</div>
		</div>
		
		<div>
			<div>COUNTRY</div>
			<div><input type="text" name="Country" value="India" readonly="readonly" /></div>
		</div>
		
		<div>
			<input type="submit" value="Submit">
			<input type="reset" value="Reset">
		</div>
	</div>
	</form>
</body>
</html>
