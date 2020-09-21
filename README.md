# archivar-apprentice-task
Задание JAVA-стажировка.
# Пояснение к реuению.
Мне удалось реализовать REST-методы mo/ data/ iemk/. Однако не удалось реализовать SOAP-клиент, однако пакеты и классы,
с помощью которых я пытался его реализовать, я удалять не стал (для проверяющего)
(пакеты: client, soapwebserviceconfig, SoapController.class).
# Запуск
Приложение запускается на http://localhost:8080/api \
Fly-away скрипты должны создать две БД, одну для Медицинских организаций (archivist.ref_mo).\
Другую - (archivist.patients) для БД, для Пациентов, которую необходимо было создать самостоятельно, для сохранения данных. \
REST методы (Более-внимательно и удобно можно посмотреть используя Swagger http://localhost:8080/swagger-ui.html): \
GET:\
http://localhost:8080/api/mo - возвратит JSON список Медицинских Организаций. \
http://localhost:8080/api/iemk/{snilsId}/{surname} - возвратит сущность Patient согласно указанным Фамилии и Номеру снилс. \
http://localhost:8080/api/iemk/surname/{surname} - возвратит сущность Patient согласно указанной Фамилии. \
http://localhost:8080/api/iemk/snils/{snilsId} - возвратит сущность Patient согласно указанному Номеру снилс. \
POST: \
http://localhost:8080/api/data - добавить сущность Patient согласно указанному JSON.
