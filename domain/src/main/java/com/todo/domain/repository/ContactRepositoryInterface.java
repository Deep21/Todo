package com.todo.domain.repository;

import com.todo.domain.Contact;
import java.util.List;
import io.reactivex.Observable;

/**
 * Created by afp on 27/03/18.
 */

public interface ContactRepositoryInterface {

  /**
   * Get task
   */
  Observable<List<Contact>> getTasks();

  /**
   * Get single Contact
   */
  Observable<Contact> getTask(int taskId);

  /**
   * Search task
   */
  Observable<List<Contact>> search(String keyword);

  /**
   * @param task
   */
   Observable<Contact> post(Contact task);

}
