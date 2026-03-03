# ---- Stage 1: Build ----
# Use a full JDK to compile the project
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

# Copy Maven wrapper and root pom first (Docker caches this layer if unchanged)
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Copy the parent pom and this module's pom
COPY discovery-server/pom.xml discovery-server/

# Download dependencies (cached separately from source code)
RUN ./mvnw dependency:go-offline -pl discovery-server -am

# Copy source code and build the jar
COPY discovery-server/src discovery-server/src
RUN ./mvnw package -pl discovery-server -am -DskipTests

# ---- Stage 2: Run ----
# Use a slim JRE (no compiler) — much smaller final image
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=builder /app/discovery-server/target/*.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "app.jar"]
