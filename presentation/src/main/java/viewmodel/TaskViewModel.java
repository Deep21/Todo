package viewmodel;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.todo.domain.interactor.TaskRetrieveInteractor;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by Samfisher on 22/11/2017.
 */

public class TaskViewModel extends ViewModel {

  private static final String TAG = "TaskViewModel";
  private TaskRetrieveInteractor taskInteractor;
  private MutableLiveData<Resource<Throwable>> error = new MutableLiveData<>();
  private MediatorLiveData<Resource> contactsListMediatorLiveData;


  @Inject
  public TaskViewModel(TaskRetrieveInteractor taskInteractor) {
    this.taskInteractor = taskInteractor;
  }

  public void loadTasks() {
      Log.d("TaskViewModel", taskInteractor + "");
  }

}
