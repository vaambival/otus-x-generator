package ru.otus.otusxgenerator.database;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.otusxgenerator.dto.UserRegistrationRequest;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OtusDao {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void saveAll(List<UserRegistrationRequest> requests) {
        jdbcTemplate.batchUpdate("INSERT INTO otus_x.authors (surname, name, birthDate, city, password) " +
                        "VALUES (?, ?, ?, ?, ?)",
                requests,
                100,
                (ps, arg) -> {
                    ps.setString(1, arg.getSurname());
                    ps.setString(2, arg.getName());
                    ps.setObject(3, arg.getBirthDate());
                    ps.setString(4, arg.getCity());
                    ps.setString(5, arg.getPassword());
                });
    }
}
