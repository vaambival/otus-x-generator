package ru.otus.otusxgenerator.beans;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.otus.otusxgenerator.config.FeignConfig;
import ru.otus.otusxgenerator.dto.UserRegistrationRequest;

import java.util.UUID;

@FeignClient(name = "otus-x", url = "${application.otus-x}", configuration = FeignConfig.class)
public interface OtusXClient {

    @PostMapping(value = "/user/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    UUID register(@RequestBody UserRegistrationRequest request);
}
