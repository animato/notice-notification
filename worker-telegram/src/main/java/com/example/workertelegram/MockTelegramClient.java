package com.example.workertelegram;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "mock-slack", url = "${telegram.host}")
public interface MockTelegramClient {

    @RequestMapping(method = RequestMethod.POST, value = "/api/chat.postMessage", produces = "application/json")
    void sendTelegram(@RequestHeader String token, @RequestBody ApiRequest request);
}
