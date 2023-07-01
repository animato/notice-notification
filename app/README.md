# 메인 서비스

## 사용 가능한 API
IntelliJ 에서는 app.http 파일을 통해 직접 실행해 볼 수 있습니다.

### 유저 생성
```
POST localhost:8080/v1/user/create
Content-Type: application/json

{
  "name": "test_user2",
  "contact": {
    "type": "telegram",
    "token": "token",
    "channel": "channel"
  }
}
```


### 그룹 생성
```
POST localhost:8080/v1/group/create
Content-Type: application/json

{
  "name": "test_group"
}
```

### 그룹 가입
```
POST localhost:8080/v1/group/join
Content-Type: application/json

{
  "nickname": "test_user",
  "group_name": "test_group"
}
```

### 그룹 탈퇴
```
POST localhost:8080/v1/group/leave
Content-Type: application/json

{
  "nickname": "test_user",
  "group_name": "test_group"
}
```

### 알람 발송
```
POST http://localhost:8080/v1/alerts
Content-Type: application/json

{
  "target": [ "@test_user", "@@team1", "@all" ],
  "severity": "normal",
  "message" : "node1 down"
}
```

## 실행 방법
```
./gradlew bootRun
```