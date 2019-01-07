# ProjectX Docs

### Server Structure
![Alt text](https://github.com/Garyyyyy/projectX/blob/master/Servers%20.png)

### How to Setup
1. Git clone this repo to your local enviroment.

2. Databse Postgres must be installed in local.

3. Config Database info in StudioService/application.properties file. 

4. Please set "spring.jpa.hibernate.ddl-auto=create-drop" at first time you start StudioService, hibernate will help you create DB automatically.  
If you already have DB created and some data in it,  don't want DB drop and create every time when the Service start, Set "spring.jpa.hibernate.ddl-auto=none" in StudioService/application.propertoes.  

5. Start each server in order: ServiceRegistry -> AuthService -> StudioService -> ConfigService -> ZuulService

### API

Sign Up
```
POST: localhost:8762/studio/jpa/user/
{
	"username": "admin",
	"password": "12345",
	"email":"XXXXXXX@gmail.com",
	"role":"Admin"
}
```


Login
```
POST: localhost:8762/auth/
{
	"username": "admin",
	"password": "12345"
}
```
