package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TaskMapperTestSuite {
    @Test
    public void mapToTask() {
        //given
        TaskDto taskDto = new TaskDto(1L, "title", "content");
        TaskMapper taskMapper = new TaskMapper();

        //when
        Task task = taskMapper.mapToTask(taskDto);

        //then
        assertEquals(1, task.getId(), 0);
        assertEquals("title", task.getTitle());
        assertEquals("content", task.getContent());
    }

    @Test
    public void mapToTaskDto() {
        //given
        Task task = new Task(1L, "title", "content");
        TaskMapper taskMapper = new TaskMapper();

        //when
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //then
        assertEquals(1, taskDto.getId(), 0);
        assertEquals("title", taskDto.getTitle());
        assertEquals("content", taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoList() {
        //given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "title", "content"));
        TaskMapper taskMapper = new TaskMapper();

        //when
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //then
        assertEquals(1, taskDtoList.get(0).getId(), 0);
        assertEquals("title", taskDtoList.get(0).getTitle());
        assertEquals("content", taskDtoList.get(0).getContent());
    }
}