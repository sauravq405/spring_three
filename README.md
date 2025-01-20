## **Optional Info:**
{Valid API URL and request body to create an employee.}
POST: http://localhost:8090/empContext/api/employees

request body:
{
"name": "Saurav Sengupta",
"department": "CE0",
"salary": 7000000000.00
}

```
curl --location 'http://localhost:8090/empContext/api/employees' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Saurav Sengupta",
    "department": "CE0",
    "salary": 70000000.00
}'
```

```
curl -X 'GET' 'http://localhost:8090/empContext/api/employees' -H 'accept: */*'
```

## **Mandatory Info:**

H2-Console is available at:
http://localhost:8090/empContext/h2-console
 
JDB URL to be used in the H2 browser window:
jdbc:h2:mem:testdb

uname:sa ; pwd: (blank) 

The Swagger UI page will then be available at:
http://localhost:8090/empContext/swagger-ui/index.html

OpenAPI description will be available at the following url for json format:
http://localhost:8090/empContext/v3/api-docs

Official Documentation referred: https://springdoc.org/

