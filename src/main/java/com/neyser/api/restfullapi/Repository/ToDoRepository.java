package com.neyser.api.restfullapi.Repository;

import com.neyser.api.restfullapi.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Task, Long> {
}
