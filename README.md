# spring_boot_app_systemctl_install
This illustrate a spring boot app that starts when the server starts; Optionally, it will invoke certain docker container. 

## Pre-requisites

> Java 11
> Maven 3

Note: for some reasons, when debugging in VSCode, one needs to clean and spring-boot:run before being able to debug in VSCode. 

## How to test

### Testing REST Functionality

1. Make sure the maven profile is "dev" (by adding "-P dev" without quotes in command line)
2. Run the Test(s) in MyRestControllerTests.java (recommend to use an IDE such as Eclipse or VSCode). 

## Maven Profiles

Maven Profiles to Spring Profiles
dev -> dev, web
