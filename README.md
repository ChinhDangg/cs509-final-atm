# cs509-final

If pull the project into with Hibernate framework, then no need to import the schema.sql file, hibernate will automatically create the table.
Else, load the schema file into MySQL database.

The current connection info to the database is: login: root, password: root. with database name: atm. Change this is application.properties file if needed.
Current admin account in the schema file:
- login: admin
- pass: 12345

<br>
<br>

#### The class diagrams and design drawing are in the "Diagram" directory

### What software architecture are you using:
- I follow the Model-View-Controller (MVC) architectural pattern which includes:
    - Model: the application's data that contain the data needs to be displayed or manipulated
    - View: presenting the data to the user (for this project is just the console)
    - Controller: acts between the model and view
    - Service: the additional layer that handles all the business logic.
    - Repository: responsible for connecting to the database and makes all the queries.

<br>
<br>
 
#### Virtual Machines
##### Pros:
- Provide software isolation at the hardware level which also increase security
- Allows multiple operating systems on same machine which also allows cross-platform development and testing
##### Cons:
- Use shared resources from the same machine which can slow down the system
- Requires a full copy of an additional operating system which needs high storage
- Running multiple virtual machines need good - strong hardware

#### Docker
##### Pros:
- More efficient than VMs as it share the host OS to run isolated processes.
- Using less resources and faster boot up time than VMs
- Using docker as the platform itself meaning any machine that can run docker can also run the docker containers, images and applications. No conflict with operating system or need dependencies troubleshooting.
- Docker uses containers which are scalable, easier to deploy and manage in production environment
- Docker is free for small and moderate business
##### Cons:
- Containers can have vulnerabilites which can affect the OS kernel
- Not all applications are supported for containerization
- Working with containers might be more difficult than working with a friendly GUI Operating System

#### Plain Old Computers
##### Pros:
- No need virtualization which allows direct performance for application
- Direct control over the hardware and software environment
- Simple to use in term of setup for small-scale application
##### Cons:
- Expensive and time consuming for scaling application
- Can only run operating system at one time

<br>
<br>

#### I use github actions for CI/CD server. Github actions will run and build the project everytime the main branch get pushed:
- Installing MySQL and adding all setups as the application will fail if it couldn't connect to the defined database
- Build the application with Maven
- Run all the tests with Maven
- Generate JavaDocs and create an artifact of the documentation in Github actions for user to download as a zip folder
- Run the test converage defined in the Maven pom.xml file
- Upload the test coverage to CodeCov
