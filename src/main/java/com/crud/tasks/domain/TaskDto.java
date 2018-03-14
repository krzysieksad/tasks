package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TaskDto {
    private Long id;
    private String title;
    private String content;

    /**
     * Create TaskDto.
     *
     * @param id      id
     * @param title   title
     * @param content content
     */
    @JsonCreator
    public TaskDto(@JsonProperty("id") final Long id, @JsonProperty("title") final String title, @JsonProperty("content") final String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
