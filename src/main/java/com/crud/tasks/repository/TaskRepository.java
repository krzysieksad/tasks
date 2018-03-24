package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Override
    List<Task> findAll();

    @Override
    Task save(final Task task);

    //@Override
    Optional<Task> findById(final Long id);

    @Transactional
    void deleteById(final Long id);
}
