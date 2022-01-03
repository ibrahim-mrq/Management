package com.android.management.databeas.other;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.android.management.model.User;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    Repository repository;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public long insertUser(User users) {
        return repository.insertUser(users);
    }

    public User login(String p_id, String password) {
        return repository.login(p_id, password);
    }

    public void updateUser(User users) {
        repository.updateUser(users);
    }

    public LiveData<List<User>> getManagers() {
        return repository.getManagers();
    }

    public LiveData<List<User>> getAllUser() {
        return repository.getAllUser();
    }

}
