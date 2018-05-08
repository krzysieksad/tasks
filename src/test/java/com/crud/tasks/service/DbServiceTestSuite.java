package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTestSuite {
    @InjectMocks
    private DbService dbService;
    @Mock
    private TaskRepository taskRepository;

    @Test
    public void shouldGetAllTasks() {
        //given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(0L, "title", "content"));

        when(taskRepository.findAll()).thenReturn(taskList);

        //when
        List<Task> tasks = dbService.getAllTasks();

        //then
        assertEquals(1, tasks.size());
        assertEquals(0, tasks.get(0).getId(), 0);
        assertEquals("title", tasks.get(0).getTitle());
        assertEquals("content", tasks.get(0).getContent());
    }

    @Test
    public void shouldGetTask() throws TaskNotFoundException {
        //given
        Task task = new Task(2L, "title", "content");

        when(taskRepository.findById(2L)).thenReturn(ofNullable(task));

        //when
        Task newTask = dbService.getTask(2L).orElseThrow(TaskNotFoundException::new);

        //then
        assertEquals(2, newTask.getId(), 0);
        assertEquals("title", newTask.getTitle());
        assertEquals("content", newTask.getContent());
    }

    @Test
    public void shouldSaveTask() {
        //given
        Task task = new Task(8L, "title", "content");

        when(taskRepository.save(task)).thenReturn(task);

        //when
        Task savedTask = dbService.saveTask(task);

        //then
        assertEquals(8, savedTask.getId(), 0);
        assertEquals("title", savedTask.getTitle());
        assertEquals("content", savedTask.getContent());
    }
}