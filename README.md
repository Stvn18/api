# API
Test Rest API for Masterdevel

## Requirements

### Download and Install JDK 8 and Add JAVA_HOME Environment Variable

* [Download JDK 8 installer](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
* Add or Update the `JAVA_HOME` variable to JDK install folder

### Download and Install Maven and add MAVEN_HOME and M2_HOME Environment Variables
* [Download Maven ZIP](https://maven.apache.org/download.cgi)
* Extract the file to a location, for example `E:\apache-maven-3.6.3`
* Set the `M2_HOME` and `MAVEN_HOME` variable to maven installation folder
* Update the `PATH` variable with `(maven installation folder)\bin` directory

### Verify Maven installation

Open your terminal and type this command
```mvn --version```
This should show the version information of maven installed.

### Run Tests

Open your terminal and navigate to the root folder of the project and run the command
```mvn clean install```

### Run API

Open your terminal and navigate to the root folder of the project and run the command
```mvn spring-boot:run```
