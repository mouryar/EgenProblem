# EgenProblem

To clean the packare  ```mvn clean package```


To run the application ```mvn spring-boot:run```


**Metrics API**

To get all metrics available ```GET - http://localhost:8080/api/metrics```

To get all metrics available ```GET - http://localhost:8080/api/metrics/startDate/endDate```

To add a new metric          ```POST - http://localhost:8080/api/metrics```

Sample Data: 
```
{
  "timeStamp": "1458062848734", 
  "value": "153"
}
```

**Alerts API**

To get all alerts available ```GET - http://localhost:8080/api/alerts```

To get all alerts available ```GET - http://localhost:8080/api/alerts/startDate/endDate```
  



