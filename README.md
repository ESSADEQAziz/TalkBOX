# TalkBOX

TalkBOX is a real-time chat web application built using Java EE technologies, WebSockets, and MySQL.

## Features

- Real-time messaging using WebSockets
- User authentication and session management
- Email verification for account activation
- User profile management
- User status tracking (online/offline status)
- Message history
- Contact management
- Profile image upload and management
- Cookie-based auto-login

## Technology Stack

- **Backend**: Java EE (Servlets, JSP, JSTL)
- **Frontend**: HTML, CSS, JavaScript
- **Database**: MySQL
- **Real-time Communication**: WebSockets (JSR 356)
- **ORM**: Hibernate/JPA
- **Build Tool**: Maven
- **Server**: Apache Tomcat

## Project Structure

- `src/main/java`: Contains servlet controllers
- `src/main/DAO`: Data Access Objects for database operations
- `src/main/DB_Connection`: Database connection management
- `src/main/EndPoint`: WebSocket endpoint for real-time messaging
- `src/main/JPAs`: JPA entity classes
- `src/main/webapp`: Web resources
  - `JSPs`: JSP views
  - `CSS_folder`: Stylesheets
  - `JS_folder`: JavaScript files
  - `Images`: Static image resources
  - `user_images`: User profile images

## Installation and Setup

### Prerequisites

- JDK 17 or higher
- Maven
- MySQL Server
- Apache Tomcat 9+

### Database Setup

1. Create a MySQL database named `talkbox`
2. Use the default credentials or update the connection details in `src/main/DB_Connection/DBconnection.java`

### Build and Deploy

1. Clone the repository
2. Navigate to the project root directory
3. Build the project with Maven:
   ```
   mvn clean package
   ```
4. Deploy the generated WAR file to Tomcat:
   - Copy the WAR file from `target/App_2.war` to Tomcat's webapps directory
   - Or use Maven Tomcat plugin:
     ```
     mvn tomcat7:run
     ```

## Usage

1. Access the application at `http://localhost:8080/App_2/`
2. Create a new account or log in with existing credentials
3. Verify your email address when prompted
4. Start chatting with other users

## Main Components

- **User Authentication**: Handled by `Servlet_1.java` and `Login.jsp`
- **User Registration**: Managed by `Servlet_2.java` and `Create_Account.jsp`
- **Email Verification**: Implemented in `Servlet_3_email_Verification.java`
- **Profile Management**: Controlled by `Servlet_4_Update_infos.java` and `change_infos.jsp`
- **Real-time Messaging**: Implemented using `EndPointServer.java` WebSocket endpoint
- **Data Access**: Managed through various DAO classes (`tuser_DAO.java`, `tstatus_DAO.java`, etc.)


