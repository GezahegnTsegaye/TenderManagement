package com.egov.tendering.notification.config;


import com.egov.tendering.notification.dal.model.Notification;
import com.egov.tendering.notification.dal.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Utility class for security-related checks in the notification service.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class SecurityUtil {

    private final NotificationRepository notificationRepository;

    /**
     * Checks if the current authenticated user is the same as the specified user ID.
     *
     * @param userId The user ID to check against the current authenticated user
     * @return true if the current user matches the specified user ID, false otherwise
     */
    public boolean isCurrentUser(String userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }

        String currentUsername = authentication.getName();
        return userId.equals(currentUsername);
    }

    /**
     * Checks if the current authenticated user can access the specified notification.
     * A user can access a notification if they are the recipient of the notification.
     *
     * @param notificationId The ID of the notification to check access for
     * @return true if the current user can access the notification, false otherwise
     */
    public boolean canAccessNotification(String notificationId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }

        String currentUsername = authentication.getName();
        Optional<Notification> notificationOpt = notificationRepository.findById(notificationId);

        if (notificationOpt.isEmpty()) {
            return false;
        }

        Notification notification = notificationOpt.get();
        return notification.getRecipients().contains(currentUsername);
    }
}