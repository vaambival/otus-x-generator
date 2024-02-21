# Подготовка к запуску

Приложение запишет в БД данные из [form.csv](src/main/resources/csv/form.csv). Там 1 млн записей.
Для старта приложения необходимо в файле [application.properties](src/main/resources/application.properties)
следует указать настройки по подключению к БД:
* url - строка-ссылка для подключения к БД
* username - имя пользователя БД
* password - пароль для подключения к БД

## Настройка JAVA

Для запуска приложения необходимо использовать OpenJDK-21 (Oracle OpenJDK version 21.0.2).
Найти можно [здесь](https://jdk.java.net/21/).
Для запуска следует запустить команду [из корня проекта](.):
```
./mvnw spring-boot:run
```