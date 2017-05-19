# PushNotificationSample

1.Instalar maven com auxílio do brew:

brew install maven

2.Na pasta do projeto executar o comando para rodar o servidor (está configurado para porta 8080):

mvn spring-boot:run

3.A documentação gerada pode ser acessada pela url : http://localhost:8080/swagger-ui.html

4.Para configurar o banco de dados descomente os valores no arquivo application.properties
-obs: Ele é grátis e lento hue

5.Adicione o .p12 na pasta src/main/resources

6.No arquivo application.properties configure o nome do arquivo de .p12, sua senha e o bundleId da sua aplicação.
