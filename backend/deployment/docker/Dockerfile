FROM gradle:8.14 AS build

WORKDIR /home/gradle/src

COPY --chown=gradle:gradle build.gradle.kts settings.gradle.kts gradle.properties ./
COPY --chown=gradle:gradle gradle ./gradle
RUN gradle dependencies --no-daemon

COPY --chown=gradle:gradle . .
RUN gradle bootJar --no-daemon

FROM eclipse-temurin:21.0.7_6-jre-alpine-3.21

EXPOSE 8080

WORKDIR /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/sncf_connect-api.jar

RUN addgroup -S -g 1000 sncf_connect && \
    adduser -H -S -u 1000 sncf_connect -G sncf_connect && \
    chown sncf_connect:sncf_connect /app/sncf_connect-api.jar

USER sncf_connect

HEALTHCHECK --interval=30s --timeout=3s \
  CMD wget -q --spider http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java","-jar","/app/sncf_connect-api.jar"]