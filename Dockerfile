# Use an official Java runtime as a base image
FROM openjdk:17-jdk-alpine

# set the mysql
#ENV  SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/productService\
#     SPRING_DATASOURCE_USERNAME: root\
#     SPRING_DATASOURCE_PASSWORD: techbankRootPsw

# Set the working directory inside the container
WORKDIR /app

#create folder in root dir
#RUN mkdir p productService

# Copy the JAR file into the container
COPY target/product-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application we used both RUN and ENTRYPOIN
#ENTRYPOINT ["java", "-jar", "app.jar"]
CMD ["java", "-jar", "app.jar"]