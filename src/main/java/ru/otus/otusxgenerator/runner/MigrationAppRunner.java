package ru.otus.otusxgenerator.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.otus.otusxgenerator.beans.CsvToUserMapper;
import ru.otus.otusxgenerator.beans.OtusXClient;
import ru.otus.otusxgenerator.database.OtusDao;
import ru.otus.otusxgenerator.dto.UserRegistrationRequest;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MigrationAppRunner implements ApplicationRunner {
    private final CsvToUserMapper mapper;
    private final OtusXClient client;
    private final OtusDao otusDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<UserRegistrationRequest> requests = mapper.getUsers();
        otusDao.saveAll(requests);
    }
}
