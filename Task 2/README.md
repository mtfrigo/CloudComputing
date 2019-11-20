## Task 2

* Changing the running port of the application (in this case I prefer to still running on 8080 port)

Go to /opt/tomcat/tomcat9/conf/server.xml
```
<Service name="Catalina">
  <Connector port="8080" protocol="HTTP/1.1" .../>
```

* Activating automatic reload

Go to /opt/tomcat/tomcat9/conf/context.xml
```
<Contextreloadable="true">
```

* Directory listing
Go to /opt/tomcat/tomcat9/conf/web.xml
```
...

<servlet>
  <servlet-name>default</servlet-name>
  <servlet-class>org.apache.catalina.servlets.DefaultServlet</servlet-cla$
  <init-param>
      <param-name>debug</param-name>
      <param-value>0</param-value>
  </init-param>
  <init-param>
      <param-name>listings</param-name>
      <param-value>true</param-value>
  </init-param>
  <load-on-startup>1</load-on-startup>
</servlet>

...
```