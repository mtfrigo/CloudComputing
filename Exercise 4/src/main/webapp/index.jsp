<html>
<head>
    <title>Reading Cookies</title>
</head>

<body>
<p>Content of database-cart: ${cart}</p>

<!-- TODO: Task 5 - Show the cart items from cookies -->

    
<%
    for (Cookie cookie: request.getCookies()) {
        out.print("Name: " + cookie.getName() + " ,");
        out.print("Value: " + cookie.getValue() + "</br>");
    }
%>


<form action = "/set" method = "POST">
    Item to add: <input type = "text" name = "item"><br />
    <input type = "submit" value = "Submit" />
</form>

</body>

</html>