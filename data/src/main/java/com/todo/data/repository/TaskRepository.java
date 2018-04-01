package com.todo.data.repository;

import com.todo.domain.Task;
import com.todo.domain.repository.TaskRepositoryInterface;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by afp on 27/03/18.
 */

public class TaskRepository implements TaskRepositoryInterface {

  @Inject
  public TaskRepository() {
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
  public Observable<Task> post(Task task) {
    return null;
  }
}


