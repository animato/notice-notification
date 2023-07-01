package com.example.workertelegram;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Receiver {
    final MockTelegramClient telegramClient;

    @RabbitListener(queues = {"queue-telegram"})
    public void receiveMessage(QueueData data) {
        System.out.println("Received");
        String token = data.getToken();
        ApiRequest request = new ApiRequest(data.getChannel(), data.getText());
        telegramClient.sendTelegram(token, request);
    }
}
