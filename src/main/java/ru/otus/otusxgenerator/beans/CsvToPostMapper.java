package ru.otus.otusxgenerator.beans;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import ru.otus.otusxgenerator.dto.PostCreateDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CsvToPostMapper {
    public List<PostCreateDto> getPosts() throws IOException {
        var stream = new ClassPathResource("/csv/posts.txt").getInputStream();
        List<PostCreateDto> requests = new ArrayList<>();
        try (var reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                var request = new PostCreateDto();
                request.setText(line.substring(0, 140));
                request.setAuthor(author());
                requests.add(request);
            }
        }
        return requests;
    }

    private UUID author() {
        if (Math.random() < .1) {
            return UUID.fromString("d6b7c0a3-3269-46d1-a375-c0a4435305d6");
        } else if (Math.random() < .2) {
            return UUID.fromString("76f5ba9d-e263-462e-bf2d-999160483f65");
        } else if (Math.random() < .9) {
            return UUID.fromString("e92426c2-52d8-4594-8cb6-3108b22c8488");
        } else {
            return UUID.fromString("43bad578-96d1-4900-a056-2df7da008adf");
        }
    }
}
