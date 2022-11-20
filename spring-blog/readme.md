A user autentikációt Keycloak szerverrel valósítottam meg.
A szerver itt érhető el
```shell
http://localhost:8080
```
A java alkalmazásom ezért a 8081-es porton érhető el. A 
Keylock szerver a következő paranccsal indítható:
```shell
key/bin/ kc.bat start-dev
```
Project Endpoints:
```shell
http://localhost:8080/realms/BlogRealm/.well-known/openid-configuration
```
```shell
http://localhost:8080/realms/BlogRealm/protocol/saml/descriptor
```
