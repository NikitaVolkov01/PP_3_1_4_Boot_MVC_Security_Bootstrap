Задание:
1) Перенесите классы и зависимости из предыдущей задачи (PP_3_1_2).
2) Создайте класс Role и свяжите User с ролями так, чтобы юзер мог иметь несколько ролей.
3) Имплементируйте модели Role и User интерфейсами GrantedAuthority и UserDetails соответственно. Измените настройку секьюрности с inMemory на userDetailService.
4) Все CRUD-операции и страницы для них должны быть доступны только пользователю с ролью admin по url: /admin/.
5) Пользователь с ролью user должен иметь доступ только к своей домашней странице /user, где выводятся его данные. Доступ к этой странице должен быть только у пользователей с ролью user и admin. Не забывайте про несколько ролей у пользователя!
6) Настройте logout с любой страницы с использованием возможностей thymeleaf.
7) Настройте LoginSuccessHandler так, чтобы админа после аутентификации направляло на страницу /admin, а юзера на его страницу /user.
8) Добавить Bootstrap

Пользователь с ролью 'user' - Username: user , Password: user.
![image](https://github.com/NikitaVolkov01/PP_3_1_4_Boot_MVC_Security_Bootstrap/assets/63566223/e05e45dd-78f1-4048-9705-f61e778dd199)
Пользователь с ролью 'admin' - Username: admin , Password: admin.
![image](https://github.com/NikitaVolkov01/PP_3_1_4_Boot_MVC_Security_Bootstrap/assets/63566223/b20f50c5-544a-4d1c-84ce-66ba77ea7bba)
![image](https://github.com/NikitaVolkov01/PP_3_1_4_Boot_MVC_Security_Bootstrap/assets/63566223/34cd3058-4a33-429a-a8ac-4bbea92979b3)
Пользователь с ролью 'adminuser' - Username: adminuser , Password: adminuser
![image](https://github.com/NikitaVolkov01/PP_3_1_4_Boot_MVC_Security_Bootstrap/assets/63566223/0a150f29-9bd3-4534-a80f-61f953954f4e)
![image](https://github.com/NikitaVolkov01/PP_3_1_4_Boot_MVC_Security_Bootstrap/assets/63566223/dcade7c4-bc47-4d38-9da6-8d50dad1229c)
