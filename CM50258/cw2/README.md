# CM50258 CW2

## Introduction
This project is a Java application that tackles various programming challenges, organized into four sections (q1, q2, q3, q4) within the `com.yourdomain` package. The project is set up to allow for easy compilation and testing with Maven, with an optional Docker setup for those preferring a containerized development environment.

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven
- Docker (optional, for containerized development environment)

### Building and Testing with Maven
To compile the project and run tests, use the Makefile:

```bash
make
```

This command invokes Maven to compile the source files and execute the unit tests.

```console
$ make
mvn compile test
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------------< com.yourdomain:cw2 >-------------------------
[INFO] Building cw2 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ cw2 ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /cw2/src/main/resources
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ cw2 ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ cw2 ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /cw2/src/main/resources
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ cw2 ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ cw2 ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 3 resources from src/test/resources to target/test-classes
[INFO] 
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ cw2 ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- surefire:3.1.2:test (default-test) @ cw2 ---
[INFO] Using auto detected provider org.apache.maven.surefire.junit4.JUnit4Provider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.yourdomain.q1.RedactorTest
[INFO] Tests run: 13, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.160 s -- in com.yourdomain.q1.RedactorTest
[INFO] Running com.yourdomain.q2.SortedLinkedListTest
[INFO] Tests run: 24, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.162 s -- in com.yourdomain.q2.SortedLinkedListTest
[INFO] Running com.yourdomain.q3.CustomSortTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 s -- in com.yourdomain.q3.CustomSortTest
[INFO] Running com.yourdomain.q4.VigenereCipherTest
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 s -- in com.yourdomain.q4.VigenereCipherTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 55, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.240 s
[INFO] Finished at: 2024-02-12T11:29:11Z
[INFO] ------------------------------------------------------------------------
```

### Optional: Using Docker for Development
For those who prefer a Docker-based development environment, a convenience script `docker-dev.sh` is provided. This script simplifies the process of setting up, starting, or connecting to a Docker container named `CM50258_cw2_dev` tailored for development.

To use the Docker environment, ensure Docker is installed, then run:

```bash
./docker-dev.sh
```

This will check if the container exists and is running:
- If the container is running, it connects you to it.
- If the container exists but is stopped, it starts the container and then connects.
- If the container does not exist, it creates and starts a new container, mounts the current working directory, and sets it as the working directory inside the container.

Ensure the script is executable:

```bash
chmod +x docker-dev.sh
```

This Docker setup is completely optional. If you have Java and Maven installed on your machine, you can directly use Maven commands for building and testing the project.

## Project Structure
- `src/main/java/com/yourdomain`: Contains the source code, divided into sections for different challenges.
- `src/test/java/com/yourdomain`: Contains unit tests for each section to ensure correctness.
- `src/main/resources/com/yourdomain/q4`: Includes resources for specific challenges, like files needed for encryption/decryption tasks.
- `Makefile`: Simplifies the build and clean process.
- `pom.xml`: Maven configuration file.
- `docker-dev.sh`: Optional script for setting up a Docker-based development environment.

## Cleaning Up
To clean up Maven-generated files and directories:

```bash
make clean
```