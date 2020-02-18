# spring-services
**Конфигурация**
В случае, если kafka уже запущен, нужно указать параметры сервера для consumer и producer.
Для этого необходимо:\
 1.) изменить значения `.server` в следующих файлах:
___
##Запуск приложения
Для запуска нужно выполнить команды в терминале:

**1.) Запуск Kafka-server**\
`$ curl -sSL https://raw.githubusercontent.com/bitnami/bitnami-docker-kafka/master/docker-compose.yml > docker-compose.yml`
`$ docker-compose up -d`
По умолчанию используется порт 9092(для zookeeper: 2181)

 **2.) Producer**\
`$ java -jar producer/build/libs/producer-0.0.1-SNAPSHOT.jar`
По умолчанию указан адрес localhost:8081.
Для изменения нужно отредактировать настройку `server.port=8081` в файле /home/denis/IdeaProjects/spring-services/producer/src/main/resources/application.properties

 **3.) Consumer**\
`$ java -jar consumer/build/libs/consumer-0.0.1-SNAPSHOT.jar`
___

# Тестирование
`$ curl http://localhost:8081/test/94433b5a-31ab-469e-a80d-7f77d8445683`

