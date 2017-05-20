# PushNotificationSample

## Rodar local
  * Instalar maven com auxílio do brew:
```shell
    brew install maven
```
  * Na pasta do projeto executar o comando para rodar o servidor:
```shell
    mvn spring-boot:run
```
  
* Baixe o projeto exemplo : https://github.com/GiovanniLuigi/NotificationExampleProject e execute no seu iPhone, no log deve ficar printado o token do seu aparelho
  
* Crie um Device no servidor : http://localhost:8080/swagger-ui.html#!/device-controller/createDeviceUsingPOST
```
obs.: O json deve conter token, mas não precisa do id. Ex.: {"token":"suatoken"}
Clique em "try it out!" no canto esquerdo inferior.
```
* Envie uma notificação para todos os devices cadastrados : http://localhost:8080/swagger-ui.html#!/notification-controller/sendToALlUsingPOST

```
Ex.: 
{
"alertBody":"HUE3",
"soundFileName":"notes_of_the_optimistic.caf",
"alertTitle":"Batman",
"badgeNumber":25
}
```
## Rodar no Heroku

 * Crie uma conta no Heroku : https://www.heroku.com/

 * Instale Heroku na sua máquina e faça o login
  
```shell
    brew install heroku-toolbelt
    heroku update
    heroku login
```
  * Crie um app no Heroku

```shell
    git remote rm heroku
    heroku create nomedoseuapp
```
  * Faça o deploy de seu app no Heroku
```shell
    git push heroku master
```

Agora acesse https://nomedoseuapp.herokuapp.com/swagger-ui.html e pode brincar!
 
#### Adicionar banco de dados no Heroku

## Integrar com seu projeto
