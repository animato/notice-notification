package com.example.workerslack;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Receiver {
    final MockSlackClient slackClient;

    @RabbitListener(queues = {"queue-slack"})
    public void receiveMessage(QueueData data) {
        System.out.println("Received");
        String token = data.getToken();
        ApiRequest request = new ApiRequest(data.getChannel(), data.getText());
        slackClient.sendSlack(token, request);
    }
}
