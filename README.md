# FinalHomework

Проект тестирования сайта https://opensource-demo.orangehrmlive.com/

В проекте реалезованы тесты для проверки:

Логина\разлогина, так же используя JSCкрипт.
Проверка на ввод рандомных данных, защита от нессанкцианированного входа.
Проверка функционала сайта: создание претензий, создание новых сотрудников в базе сайта, создание постов в Buzz.

Запуск тестов производится с класса TestRunner, в нём можно выбрать какие именно тесты запустить и запустить паралельно.
так же запуск тестов можно осуществить командами mvn clean test (запуск всех тестовых методов паралельно)
Так же тестовые классы можно запустить отдельно:
mvn clean test -Dtest=LoginTest -запуск LoginTest.java
mvn clean test -Dtest=BuzzTest-запуск BuzzTest.java
mvn clean test -Dtest=ClaimTest -запуск ClaimTest.java
mvn clean test -Dtest=DashboardTest -запуск DashboardTest.java
mvn clean test -Dtest=PimTest -запуск PimTest.java
mvn clean test -Dtest=RandomTest -запуск RandomTest.java

Команда mvn allure:serve генерирует отчёт Allure и открывает его
Команда mvn allure:report создаёт отчёт 