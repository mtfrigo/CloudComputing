# Cloud Computing Winter semester 19/20

## Tomcat 9

* The operation system is Ubuntu 18.04 *

* Installing

First of all:

`sudo apt update`

And then install the OpenJDK package

`sudo apt install default-jdk`

* Create Tomcat user

`sudo useradd -r -m -U -d /opt/tomcat -s /bin/false tomcat`

* Download and extract tar

Go to https://tomcat.apache.org/download-90.cgi and download the tar.gz

Then `sudo tar xf /path/to/file -C /opt/tomcat`

Rename the folder to tomcat9

* Create symbolic link

`sudo ln -s /opt/tomcat/tomcat9 /opt/tomcat/tomcat9`

* Changes directory ownership

`sudo chown -RH tomcat:/opt/tomcat/tomcat9`

`sudo sh -c 'chmod +x /opt/tomcat/latest/bin/*.sh'`

* Create systemctl file

`sudo nano /etc/systemd/system/tomcat.service`

```
[Unit]
Description=Tomcat 9 servlet container
After=network.target

[Service]
Type=forking

User=tomcat
Group=tomcat

Environment="JAVA_HOME=/usr/lib/jvm/default-java"
Environment="JAVA_OPTS=-Djava.security.egd=file:///dev/urandom -Djava.awt.headless=true"

Environment="CATALINA_BASE=/opt/tomcat/tomcat9"
Environment="CATALINA_HOME=/opt/tomcat/tomcat9"
Environment="CATALINA_PID=/opt/tomcat/tomcat9/temp/tomcat.pid"
Environment="CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC"

ExecStart=/opt/tomcat/tomcat9/bin/startup.sh
ExecStop=/opt/tomcat/tomcat9/bin/shutdown.sh

[Install]
WantedBy=multi-user.target
```

```
sudo systemctl daemon-reload
sudo systemctl start tomcat
sudo systemctl status tomcat
```
If there are no errors enable the Tomcat service

`sudo systemctl enable tomcat`

* Adjust the Firewall

`sudo ufw allow 8080/tcp`
`sudo ufw allow 80/tcp`

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
servlet... default... listings-set to true
```
