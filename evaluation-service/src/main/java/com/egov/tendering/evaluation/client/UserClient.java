package com.egov.tendering.evaluation.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "${app.feign.user-service}")
public interface UserClient {

    /**
     * Gets a username by user ID
     *
     * @param userId The user ID
     * @return The username
     */
    @GetMapping("/api/users/{userId}/username")
    String getUsernameById(@PathVariable Long userId);
}