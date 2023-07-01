package com.dsyang.noticenotification.app.alert;

import com.dsyang.noticenotification.app.user.Contact;
import com.dsyang.noticenotification.app.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AlertService {

    final UserService userService;
    private final RabbitTemplate rabbitTemplate;

    /**
     * 알림 발송
     */
    public int sendAlert(List<String> target, String severity, String message) {
        Message text = new Message(severity, message);
        Set<Contact> users = userService.getTargetContact(target);

        for (Contact contact : users) {
            String type = contact.getType();
            String token = contact.getToken();
            String channel = contact.getChannel();
            QueueData data = new QueueData(token, channel, text.getFormattedMessage());

            if (type.equals("slack")) {
                rabbitTemplate.convertAndSend("notification-exchange", "queueSlack", data);
            } else if (type.equals("telegram")) {
                rabbitTemplate.convertAndSend("notification-exchange", "queueTelegram", data);
            }
        }

        return users.size();
    }
}
