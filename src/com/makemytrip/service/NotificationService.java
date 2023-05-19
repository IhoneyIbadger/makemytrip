package com.myapp.service;

import com.myapp.model.User;
import com.myapp.util.NotificationSender;

public class NotificationService {
    private NotificationSender notificationSender;

    public NotificationService() {
        this.notificationSender = new NotificationSender();
    }

    public void sendFlightNotification(User user, String message) {
        notificationSender.sendFlightNotification(user.getEmail(), message);
    }

    public void sendWeatherAlert(User user, String message) {
        notificationSender.sendWeatherAlert(user.getPhoneNumber(), message);
    }

    // Other notification methods...
}
