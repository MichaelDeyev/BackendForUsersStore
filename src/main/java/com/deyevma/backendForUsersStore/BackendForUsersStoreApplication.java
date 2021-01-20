package com.deyevma.backendForUsersStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
* Добавление нового пользователя.
Передаем на сервер данныепользователя (имя пользователя, email,phoneNumber и т.д.). Сохраняем информацию в
базе данных. Ответ сервера — уникальный ID нового пользователя
* Получение информации о пользователе.
Передаем на сервер уникальный ID пользователя. Читаем информацию из базы данных. Ответ сервера — данные пользователя
* Изменение статуса пользователя (Online, Away, Offline).
Передаем на сервер уникальный ID пользователя и новый статус. Изменяем статус пользователя. Ответ сервера —
уникальный ID пользователя, новый и предыдущий статус
* Перевод в статус Away должен делаться автоматически через 5 минут после последнего изменения статуса
на online. Таким образом, если “подтверждать” статус online пользователя каждые 5 минут - автоматического перехода в Away не
должно быть
Обязательные требования:
— RESTfull
— Все данные в формате JSON
— Обработка ошибок
 */
@SpringBootApplication(scanBasePackages = "com.deyevma.backendForUsersStore")
public class BackendForUsersStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendForUsersStoreApplication.class, args);
	}

}
