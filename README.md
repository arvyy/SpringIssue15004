1. Run spring boot application
2. Open localhost:8080/actuator/hawtio/keycloak/enabled
3. Observe it unexpectedly redirects to login page
4. Stop spring boot application, edit Security.java line 18 to be `var useWorkaround = true;`; run application again
5. Open localhost:8080/actuator/hawtio/keycloak/enabled
6. Observe it expectedly returns a json response
