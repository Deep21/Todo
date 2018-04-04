package com.todo.data.repository;

import com.todo.data.datasource.TaskDataStoreInterface;
import com.todo.domain.Task;
import com.todo.domain.repository.TaskRepositoryInterface;

import java.util.List;
import javax.inject.Inject;
import io.reactivex.Observable;

/**
 * Created by afp on 27/03/18.
 */

public class TaskRepository implements TaskRepositoryInterface {

  private TaskDataStoreInterface taskDataStoreInterface;

    /**
     * We're injecting the implemented class of TaskDataStoreInterface
     * @param taskDataStoreInterface
     */
  @Inject
  public TaskRepository(TaskDataStoreInterface taskDataStoreInterface) {
    this.taskDataStoreInterface = taskDataStoreInterface;
  }


    @Override
    public Observable<List<Task>> getTasks() {
        return null;
    }

    @Override
    public Observable<Task> getTask(int taskId) {
        return null;
    }

    @Override
    public Observable<List<Task>> search(String keyword) {
        return null;
    }

    @Override
    public Observable<Task> post(com.todo.domain.Task task) {
        return null;
    }
}


