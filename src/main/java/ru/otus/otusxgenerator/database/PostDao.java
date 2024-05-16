package ru.otus.otusxgenerator.database;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.otusxgenerator.dto.PostCreateDto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@RequiredArgsConstructor
public class PostDao {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void saveAll(List<PostCreateDto> posts) {
        AtomicInteger minusDays = new AtomicInteger(0);
        AtomicInteger counter = new AtomicInteger(0);
        jdbcTemplate.batchUpdate("INSERT INTO otus_x.posts (id, text, author, created, updated) " +
                        "VALUES (?, ?, ?, ?, ?)",
                posts,
                100,
                (ps, arg) -> {
                    ps.setObject(1, UUID.randomUUID());
                    ps.setString(2, arg.getText());
                    ps.setObject(3, arg.getAuthor());
                    LocalDateTime now = LocalDateTime.now(ZoneId.of("UTC"));
                    var count = counter.incrementAndGet();
                    int minus = 0;
                    if (count == 100) {
                        minus = minusDays.incrementAndGet();
                    }
                    now = now.minusDays(minus);
                    ps.setObject(4, now);
                    ps.setObject(5, now);
                });
    }
}
