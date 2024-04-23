# cs509-midterm

If pull the project into with Hibernate framework, then no need to import the schema.sql file, hibernate will automatically create the table.
Else, load the schema file into MySQL database.

The current connection info to the database is: login: root, password: root. with database name: atm. Change this is application.properties file if needed.
Current admin account in the schema file:
- login: admin
- pass: 12345

What software architecture are you using:
- I follow the Model-View-Controller (MVC) architectural pattern which includes:
    - Model: the application's data that contain the data needs to be displayed or manipulated
    - View: presenting the data to the user (for this project is just the console)
    - Controller: acts between the model and view
    - Service: the additional layer that handles all the business logic.
    - Repository: responsible for connecting to the database and makes all the queries.
