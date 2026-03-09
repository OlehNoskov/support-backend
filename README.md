# Support Application Backend

Set up MongoDB:
- docker exec -it support-mongo-db bash
- mongosh -u admin -p password --authenticationDatabase admin
- support-backend
- create a new user with readWrite permissions on the support-backend database:
```
  db.createUser({
  user: "admin",
  pwd: "password",
  roles: [
    { role: "readWrite", db: "support-backend" }
  ]
})
```
- verify the user was created successfully:
```
  db.getUsers()
```
- exit the MongoDB shell and the container:

Set up the Keycloak server:
- Go to localhost:9090
- Authenticate with admin:password
- Create a new realm called `support-app`
- Create a new client called `support-backend` with the following settings:
- All settings are default except: Web origins -> `localhost:8080/*`
- Create a new user called `admin` in the support-app realm with the following settings:
- Create a new role called `ROLE_ADMIN`, `ROLE_SUPPORT`, and `ROLE_USER` in the support-backend client
- Create realm roles with the same names as the client roles and assign them to the user
- Assign the client roles to the users
- Obtaining the token for the users using Postman

https://medium.com/@iaravinda33/integrating-keycloak-authentication-with-spring-boot-a-complete-guide-98df2c8d244a