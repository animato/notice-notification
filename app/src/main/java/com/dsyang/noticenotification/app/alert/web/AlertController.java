package com.dsyang.noticenotification.app.alert.web;

import com.dsyang.noticenotification.app.alert.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AlertController {
    final AlertService alertService;

    @PostMapping("/v1/alerts")
    public AlertResponse alerts(@RequestBody AlertRequest request) {
        int count = alertService.sendAlert(request.getTarget(), request.getSeverity(), request.getMessage());
        return new AlertResponse(count);
    }
}
