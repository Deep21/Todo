package com.todo.domain.repository;

import com.todo.domain.Task;
import java.util.List;
import io.reactivex.Observable;

/**
 * Created by afp on 27/03/18.
 */

public interface TaskRepositoryInterface {

  /**
   * Get task
   */
  Observable<List<Task>> getTasks();

  /**
   * Get single Task
   */
  Observable<Task> getTask(int taskId);

  /**
   * Search task
   */
  Observable<List<Task>> search(String keyword);

  /**
   * @param task
   */
   Observable<Task> post(Task task);

}
