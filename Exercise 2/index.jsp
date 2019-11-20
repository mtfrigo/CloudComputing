<html>
    <head>
        <title>Hit Counter</title>
    </head>
    <body>
        <%
            Integer hitsCount;
            hitsCount = (Integer)application.getAttribute("hitCounter");

            boolean reset;

            reset = Boolean.parseBoolean(request.getParameter("reset"));
            if(reset || hitsCount == null) {
                hitsCount = 0;
            }
            hitsCount += 1;
            application.setAttribute("hitCounter", hitsCount);
        %>

        <%=hitsCount%>
    </body>
</html>