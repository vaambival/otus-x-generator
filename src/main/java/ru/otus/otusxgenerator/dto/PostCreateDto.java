package ru.otus.otusxgenerator.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PostCreateDto {
    private UUID author;
    private String text;
}
