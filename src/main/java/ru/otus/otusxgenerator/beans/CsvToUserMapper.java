package ru.otus.otusxgenerator.beans;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import ru.otus.otusxgenerator.dto.UserRegistrationRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvToUserMapper {
    public List<UserRegistrationRequest> getUsers() throws IOException {
        var stream = new ClassPathResource("/csv/form.csv").getInputStream();
        List<UserRegistrationRequest> requests = new ArrayList<>();
        try (var reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                var values = line.split(",");
                var request = new UserRegistrationRequest();
                var names = values[0].split(" ");
                request.setSurname(names[0]);
                request.setName(names[1]);
                request.setBirthDate(LocalDate.parse(values[1], DateTimeFormatter.ISO_LOCAL_DATE));
                request.setCity(values[2]);
                request.setPassword(RandomStringUtils.randomAlphabetic(5) + "1");
                requests.add(request);
            }
        }
        return requests;
    }
}
