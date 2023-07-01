package com.example.workerslack;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "mock-slack", url = "${slack.host}")
public interface MockSlackClient {

    @RequestMapping(method = RequestMethod.POST, value = "/api/chat.postMessage", produces = "application/json")
    void sendSlack(@RequestHeader String token, @RequestBody ApiRequest request);
}
