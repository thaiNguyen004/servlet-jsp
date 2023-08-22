# Tomcat 
**10.1.12**
https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.12/bin/apache-tomcat-10.1.12-windows-x64.zip

# Servlet

### /api [servlet-api 6.0.0]
<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>6.0.0</version>
    <scope>provided</scope>
</dependency>

### /jsp [jsp.api 3.1.1]
<!-- https://mvnrepository.com/artifact/jakarta.servlet.jsp/jakarta.servlet.jsp-api -->
<dependency>
    <groupId>jakarta.servlet.jsp</groupId>
    <artifactId>jakarta.servlet.jsp-api</artifactId>
    <version>3.1.1</version>
    <scope>provided</scope>
</dependency>

### /jstl
<dependency>
    <groupId>org.glassfish.web</groupId>
    <artifactId>jakarta.servlet.jsp.jstl</artifactId>
    <version>3.0.1</version>
</dependency>
<dependency>
    <groupId>jakarta.servlet.jsp.jstl</groupId>
    <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
    <version>2.0.0</version>
</dependency>


# SQL

### /mysql connector/J
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>

### port MySQL = 3306


# Custom tag (Tag Library Descriptor)

### pattern
<?xml version="1.0" encoding="UTF-8"?>
<taglib version="2.1" xmlns="http://java.sun.com/xml/ns/javaee" 
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
        xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
                http://java.sun.com/xml/ns/javaee/web-jsptaglibrary_2_1.xsd">
  <tlib-version>1.0</tlib-version>
  <short-name>newtag_library</short-name>
  <uri>/WEB-INF/tlds/newtag_library</uri>
  
</taglib>

### example
<short-name>murach</short-name>
<uri>/WEB-INF/murach.tld</uri>
<info>A custom tag library developed by
    Mike Murach and Associates</info>
<tag>
    <name>ifWeekday</name>
    <tagclass>murach.tags.IfWeekdayTag</tagclass>
    <bodycontent>JSP</bodycontent>
</tag>

### properties of <tag>
1. **tag/name**                       The name of the tag
2. **tag/tagclass**                   Path of the Tag class
3. **tag/bodycontent**                Determine whether tag is a body-containing [value: JSP] tag or a self-closing tag [value: empty or no need to write]
4. **tag/attribute**                  Only for tags with attributes
5. **tag/attribute/name**             The name of the attribute
6. **tag/attribute/required**         validate
7. **tag/attribute/rtexprvalue**      Specifies whether value of attribute is determined from runtime expression. If so, the type element can be any datatype, otherwise the type is a string
8. **tag/attribute/type**             Only need to write if rtexprvalue is true


### url 
#### src/main/webapp/WEB-INF/tld_name.tld

### taglib directive
<%@ taglib prefix="ex" uri="/WEB-INF/tld_name.tld" %>


# JavaEmail

### maven
<dependency>
    <groupId>jakarta.mail</groupId>
    <artifactId>jakarta.mail-api</artifactId>
    <version>2.1.1</version>
</dependency>

### pattern
// 1 - get a mail session
Properties props = new Properties();
props.put("mail.smtp.host", "smtp.office365.com");
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.port", 587);
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.quitwait", "false");
Session session = Session.getInstance(props, new Authenticator() {
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("nguyennt2004@outlook.com",
                "Ntph33935@");
    }
});
session.setDebug(true);

// 2 - create a message
...

// 3 - address the message
Address fromAddress = new InternetAddress(from);
Address toAddress = new InternetAddress(to);
message.setFrom(fromAddress);
message.setRecipient(Message.RecipientType.CC, toAddress);

// 4 - send the message
Transport.send(message);


# SSL/TLS

### How to configure a Testing Environment for SSL (tomcat)
**Step 1** 
CMD: "%JAVA_HOME%\bin\keytool" -genkey -alias tomcat -keyalg RSA

**Step 2** 
Configure file server.xml trong thư mục conf của Tomcat
<Connector protocol="org.apache.coyote.http11.Http11NioProtocol" port="8443"
            maxThreads="150" SSLEnabled="true" 
                    maxParameterCount="1000"> 
    <UpgradeProtocol className="org.apache.coyote.http2.Http2Protocol" />
    <SSLHostConfig>
            <Certificate
            certificateKeystoreFile="C:/Users/nguye/.keystore"
            certificateKeystorePassword="changeit"
            type="RSA"/>
    </SSLHostConfig>
</Connector>

