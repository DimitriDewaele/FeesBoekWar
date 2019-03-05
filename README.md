# FeesBoek
FeesBoek test application for Java EE7 with maven, hibernate.

* First started as a NetBeans project.
* Later evolved to an IntelliJ project.

## Create Database
First create the database:

* src/main/resources/sql/createFeesboek-MSSQL.sql
* src/main/resources/sql/createFeesboek-MySQL.sql
* src/main/resources/sql/createFeesboek-Oracle.sql

Make sure you can acces the DB with a user/password.

## Define JNDI data source

Create the JNDI data source in the application server.

Reference >> Hibernate >> persistence.xml

`<jta-data-source>java:/jboss/datasources/FeesboekDS</jta-data-source>`

jta-data-source = The JNDI name of where the javax.sql.DataSource is located. When running without a JNDI available Datasource, you must specify JDBC connections with Hibernate specific properties (see below)

## Application Servers
Application Context:
[http://localhost:8080/FeesBoekWar/](http://localhost:8080/FeesBoekWar/)

###WildFly
Add datasource: standalone.xml (or standalone-full.xml)
Make sure:
* The DB is created on MSSQL
* Username + password is correct
* DatabaseName is set
* SQL driver is available on wildfly

Configuration:

    <datasource jndi-name="java:/jboss/datasources/FeesboekDS" pool-name="be.feesboek.PU">
        <connection-url>jdbc:sqlserver://localhost:1433;databaseName=feesboekDB</connection-url>
        <driver>sqlserver</driver>
        <security>
            <user-name>sa</user-name>
            <password>!234Hjkl</password>
        </security>
        <validation>
            <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mssql.MSSQLValidConnectionChecker"/>
        </validation>
    </datasource>

### GlassFish

Define the JNDI datasource in the admin console.

## Run the application
				
### GlassFish Server

* Public: localhost:8080
* Admin Console: localhost:4848

## Remarks:

there is also a problem with the JMS messages.

It seems to run from NetBeans, but not from IntelliJ
Some classes are put into comment, because of deployment problems:
`be.feesboek.webmassage`