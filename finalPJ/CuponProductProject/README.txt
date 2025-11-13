This is the CuponProductProject prepared for Eclipse (non-Maven).

Instructions:
1. Import the folder finalPJ/CuponProductProject into Eclipse as an Existing Dynamic Web Project or create a new Dynamic Web Project and copy the sources into the project.
2. Configure Tomcat and ensure the JDBC driver for MySQL (mysql-connector-java) is available to Tomcat (put JAR into TOMCAT_HOME/lib or project WEB-INF/lib).
3. Use Navicat Premium 17 to run sql/create_tables_navicat.sql to create database and tables (database: coupon_db).
4. Update the credentials and URL in src/main/webapp/META-INF/context.xml or configure a JNDI resource in Tomcat's context.xml with name "myds" as used by the project.
5. Deploy the project to Tomcat and open index.html to operate.

-- End of files
