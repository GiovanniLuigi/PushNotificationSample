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

  * Simplesmente abra o arquivo application.properties e substitua spring.profiles.active=dev por spring.profiles.active=production
  * Agora faça o deploy no heroku
  
```shell
    git add .
    git commit -m "Production"
    git push heroku master
```
## Integrar com seu projeto
 
 ### No projeto java
  * Adicione o seu arquivo .p12 na pasta src/main/resources
  
  * Mude as configuração no arquivo application.properties conforme suas credenciais 
  ```
  cert.filename = nomedoseuarquivop12.p12
  cert.pass = suasenha
  bundleId = seubundleid
  ```
  * Suba o projeto pro servidor
 
### No seu projeto iOS

  * Crie uma classe que faz a conexão com seus serviços 
  
```
  open class RestController {
    
    static private let urlString = "https://miapphue12.herokuapp.com/device"
    
    static func createDevice(_ token: String) {
        let url = URL(string: urlString)!
        var request = URLRequest(url: url)
        request.httpMethod = "POST"
        let data = "{\"token\":\"\(token)\" }"
        request.httpBody = data.data(using: .utf8)
        request.addValue("application/json", forHTTPHeaderField: "Content-Type")
        URLSession.shared.dataTask(with: request).resume()
    }
    
  }
 ```
 obs.: urlString = sua url no heroku

  * Chame a função que cadastra o seu token no bd
  
```
    func application(_ application: UIApplication, didRegisterForRemoteNotificationsWithDeviceToken deviceToken: Data) {
        print("SUA TOKEN : \(tokenString(deviceToken))")
        
        RestController.createDevice(tokenString(deviceToken))
    }
```
