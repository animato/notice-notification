# Slack Queue Worker
 
전용 큐를 통해 전달 받은 메시지를 Slack으로 전달하는 역할을 하는 서비스 입니다.

## 아키텍처

Slack 전용 큐에 저장된 메시지 데이터를 읽고 Slack API(mock)를 호출하여 메시지를 전송합니다.

![img.png](img.png)


## 실행 방법
```
./gradlew bootRun
```
