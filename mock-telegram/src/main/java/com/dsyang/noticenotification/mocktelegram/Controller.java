package com.dsyang.noticenotification.mocktelegram;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {
    @PostMapping("/api/chat.postMessage")
    public void postMessage(@RequestBody Request request) {
        log.info("{} {}", request.channel, request.text);
    }

    @Value
    public static class Request {
        String channel;
        String text;
    }
}
