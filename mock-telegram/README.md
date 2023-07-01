# Telegram mock service

단순 로그를 출력하는 메시지 API 가 있는 mock service 입니다.

시스템 상 알람을 받는 최종 소비자 서비스로 간주됩니다.

## 실행 방법
```
./gradlew bootRun
```

## 사용 가능한 API
```
POST /api/chat.postMessage
{
    "channel": "USER_CHANNEL_ID",
    "text" : "[normal] node1 down"
}
```