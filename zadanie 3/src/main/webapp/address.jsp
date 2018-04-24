<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="parameters" class="domain.LoanParameters" scope="session"/>
	<jsp:useBean id="loan" class="domain.LoanApplication" scope="session"/>
	<jsp:useBean id="loanService" class="services.LoanService" scope="application"/>
	<jsp:useBean id="person" class="domain.Person" scope="session"/>
	
	<jsp:setProperty property="*" name="parameters"/>
	<jsp:setProperty property="*" name="person"/>
	
	Numer wniosku: ${loan.number}<br/>
	Wnioskowana kwota: ${parameters.amount}<br/>
	Osoba: ${person.surname}  ${person.firstName}
	
	<form action="success.jsp">
		<label>Kod pocztowy: <input type = "text" id = "zipCode" name = "zipCode"/></label></br>
		<label>Miasto: <input type = "text" id = "city" name = "city"/></label></br>
		<label>Ulica: <input type = "text" id = "street" name = "street"/></label></br>
		<label>Nr domu: <input type = "text" id = "houseNumber" name = "houseNumber"/></label></br>
		<label>Nr lokalu: <input type = "text" id = "localNumber" name = "localNumber"/></label></br>
		
		<input type = "submit" value = "nastepny krok"/>
	</form>
</body>
</html>