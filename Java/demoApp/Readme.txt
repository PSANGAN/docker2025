C:\PGS\GitHub\VersionCntrl\demoApp>mvnw.cmd clean package -DskipTests
C:\PGS\GitHub\VersionCntrl\demoApp>docker build -t hello-spring:1.0 .
C:\PGS\GitHub\VersionCntrl\demoApp>docker run --rm -p 8080:8080 hello-spring:1.0