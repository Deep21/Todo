package com.todo.data.repository;

import com.todo.data.datasource.TaskDataStoreInterface;
import com.todo.domain.Task;
import com.todo.domain.repository.TaskRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by afp on 27/03/18.
 */

public class TaskRepository implements TaskRepositoryInterface {

  private TaskDataStoreInterface taskDataStoreInterface;

    /**
     * Dagger will inject here the implemented class of TaskDataStoreInterface
     * @param taskDataStoreInterface
     */
  @Inject
  public TaskRepository(TaskDataStoreInterface taskDataStoreInterface) {
    this.taskDataStoreInterface = taskDataStoreInterface;
  }


    @Override
    public Observable<List<Task>> getTasks() {
        return taskDataStoreInterface.getList().map(tasks -> {
          List<Task> tasksDomain = new ArrayList<>();
          for (com.todo.data.entity.Task task : tasks) {
            Task taskD = new Task();
              tasksDomain.add(taskD);
          }
          return tasksDomain;
        });
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


