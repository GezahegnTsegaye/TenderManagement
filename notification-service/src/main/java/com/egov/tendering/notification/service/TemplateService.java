package com.egov.tendering.notification.service;

import com.egov.tendering.notification.dal.model.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class TemplateService {

    private final TemplateEngine templateEngine;

    public String processTemplate(String templateName, Notification notification) {
        try {
            log.debug("Processing template: {} for notification: {}", templateName, notification.getId());

            Context context = new Context();

            // Add notification details to the context
            Map<String, Object> variables = new HashMap<>();
            variables.put("notification", notification);
            variables.put("subject", notification.getSubject());
            variables.put("message", notification.getMessage());
            variables.put("entityId", notification.getEntityId());
            variables.put("type", notification.getType());

            context.setVariables(variables);

            // Process the template
            String result = templateEngine.process(templateName, context);
            if (result == null || result.isEmpty()) {
                log.warn("Template processing resulted in empty content for template: {}", templateName);
                // Fallback to the raw message if template processing fails
                return notification.getMessage();
            }

            return result;
        } catch (Exception e) {
            log.error("Failed to process template: {} for notification: {}", templateName, notification.getId(), e);
            // Fallback to the raw message if template processing fails
            return notification.getMessage();
        }
    }
}