# Базовый образ с Java 17
FROM eclipse-temurin:17-jdk-alpine

# Информация о владельце
LABEL maintainer="Alex <lasin470@gmail.com>"

# Том для временных файлов
VOLUME /tmp

# Копируем собранный jar-файл в контейнер
COPY target/*.jar app.jar

# Порт, который будет слушать микросервис
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "/app.jar"]