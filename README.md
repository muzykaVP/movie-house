# 🎥MOVIE HOUSE🎥
A RESTful cinema project, where you can search movies and their sessions, add movie tickets to a shopping cart and purchase them later as a user.
As admin, you can manage data records located in a remote database.

## ✨Features✨
* Register as a user
* Login/logout as a admin/user
* General rights for user and admin:
  * Display all available cinema halls/movie sessions/movies
* User rights:
  * Display your orders/shopping cart
  * Create new order
  * Update shopping cart
* Admin rights:
  * Display user by his email
  * Add new cinema hall/movie session/movie
  * Delete movie sessions
  * Update movie sessions
* User input validations for register/login
* Sensitive data encryption

## 🧬Project structure🧬
### N-tier architecture with Spring
Project built by using N-tier architecture divides application
into logical layers:
* **Frontend Framework**: Frontend framework sends a request to the server it reaches our controller.
* **@RestController**: Separates the UI from the backend logic. The controller has a service component autowired which can help him return the request.
* **@Service**: Interacts with data through an autowired repository and contains the business logic.
* **@Repository**: Interacts with the chosen way to persist data. Another name for this layer is the data access layer.
* **Data tier**: data store/retrieve layer.
### DB structure
![img.png](img.png)
## 👩‍💻Technologies👩‍💻
* Apache Maven
* JDK 17
* MySQL 8
* Tomcat 9
* JPA, Hibernate
* Spring Core, Spring Web, Spring Security

## 🛠Setup guide🛠

First of all fork this repository. Clone it and create new project from version control in IntelliJ IDEA.
####
To run this project locally on your computer, you need to make sure you have the following components installed:
* JDK 17 ([installation guide](https://docs.oracle.com/en/java/javase/17/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A))
* IntelliJ IDEA Ultimate ([download here](https://www.jetbrains.com/idea/download/#section=windows))
* Apache Maven ([download here](https://maven.apache.org/download.cgi), [installation guide](https://maven.apache.org/install.html))
* MySql ([installation guide](https://dev.mysql.com/doc/mysql-installation-excerpt/8.0/en/))
* Tomcat 9 ([installation guide](https://medium.com/@ngotantien/how-to-install-apache-tomcat-9-on-windows-mac-os-x-ubuntu-and-get-started-with-java-servlet-45f959d7ee0a))

### Application configuration
#### Create a new MySQL connection
Using [MySql Workbench](https://dev.mysql.com/downloads/workbench/) create a new connection by following this [guide](https://dev.mysql.com/doc/workbench/en/wb-getting-started-tutorial-create-connection.html).

#### Create a new DB
To create a new DB follow this [guide](https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/How-to-create-a-database-schema-with-the-MySQL-Workbench).
You don't need to create a new tables in DB, Hibernate will do it for you.

#### Connect DB to project
To connect the created database to the project follow this [guide](https://www.jetbrains.com/help/idea/mysql.html).
Fill in the fields with the values that you specified when creating the connection in MySql Workbench.
Also you need to edit fields in file [`db.properties`](src/main/resources/db.properties) according to previously entered values.
```
db.driver= YOUR_DRIVER
db.url= YOUR_DATABASE_URL
db.user= YOUR_USER_NAME
db.password= YOUR_PASSWORD
```

#### Tomcat server setup
For TomCat server setup follow this configuration [guide](https://mkyong.com/intellij/intellij-idea-run-debug-web-application-on-tomcat/).

## 🚀You are ready to go!🚀
To test application functionality with different access rights 
its better to use [Postman](https://www.postman.com/downloads/), 
where you can send API requests to controllers end-points and get responses.
####
You can register as user or log in as default user without registration if you 
enter:
* login: user@mail.com
* password: user1234
####
or log in as admin entering:
* login: admin@mail.com
* password: admin1234
####
**List of available end-points:**
* POST: /register - all
* GET: /cinema-halls - user/admin
* GET: /movie-sessions/available - user/admin
* GET: /movies - user/admin
* POST: /cinema-halls - admin
* POST: /movies - admin
* POST: /movie-sessions - admin
* PUT: /movie-sessions/{id} - admin
* DELETE: /movie-sessions/{id} - admin
* GET: /users/by-email - admin
* GET: /orders - user
* POST: /orders/complete - user
* PUT: /shopping-carts/movie-sessions - user
* GET: /shopping-carts/by-user - user
