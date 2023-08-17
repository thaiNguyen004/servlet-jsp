# Tomcat 10.1.11 
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
A TLD file that contains two tag elements 
    <?xml version="1.0" encoding="UTF-8" ?>
    <taglib version="2.0" xmlns="http://java.sun.com/xml/ns/j2ee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee
            web-jsptaglibrary_2_0.xsd">
    <tlib-version>1.0</tlib-version>
    
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
</tag

### properties of <tag>
*tag/name*                       The name of the tag
*tag/tagclass*                   Path of the Tag class
*tag/bodycontent*                Determine whether tag is a body-containing [value: JSP] tag or a self-closing tag [value: empty or no need to write]
*tag/attribute*                  Only for tags with attributes
*tag/attribute/name*             The name of the attribute
*tag/attribute/required*         validate
*tag/attribute/rtexprvalue*      Specifies whether value of attribute is determined from runtime expression. If so, the type element can be any datatype
                                 , otherwise the type is a string
*tag/attribute/type*             Only need to write if rtexprvalue is true


### url 
#### src/main/webapp/WEB-INF/tld_name.tld

### taglib directive
<%@ taglib prefix="ex" uri="/WEB-INF/tld_name.tld" %>







