package ru.otus.otusxgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class UserRegistrationRequest {
    @JsonProperty("first_name")
    private String name;
    @JsonProperty("second_name")
    private String surname;
    @JsonProperty("birthdate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;
    @JsonProperty("biography")
    private String interests;
    private String city;
    private String password;
}
