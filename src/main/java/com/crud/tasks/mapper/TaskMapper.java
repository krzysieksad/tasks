package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {
    /**
     * Submodule 15.2. mapper TaskDto -> Task.
     *
     * @param taskDto TaskDto
     * @return Task
     */
    public Task mapToTask(final TaskDto taskDto) {
        return new Task(
                taskDto.getId(),
                taskDto.getTitle(),
                taskDto.getContent());
    }

    /**
     * Submodule 15.2. mapper Task -> TaskDto.
     *
     * @param task Task
     * @return TaskDto
     */
    public TaskDto mapToTaskDto(final Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getContent());
    }

    /**
     * Submodule 15.2. mapper for list.
     *
     * @param taskList task list
     * @return List of TaskDto
     */
    public List<TaskDto> mapToTaskDtoList(final List<Task> taskList) {
        return taskList.stream()
                .map(this::mapToTaskDto)
                .collect(Collectors.toList());
    }
}
