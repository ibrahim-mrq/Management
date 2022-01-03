package com.android.management.databeas.other;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.android.management.databeas.DAO.UserDAO;
import com.android.management.model.User;

import java.util.List;

public class Repository {

    UserDAO userDAO;

    public Repository(Application application) {
        MyDatabase db = MyDatabase.getDatabase(application);
        userDAO = db.userDAO();
    }

    public long insertUser(User users) {
        return userDAO.insertUser(users);
    }

    public User login(String p_id, String password) {
        return userDAO.login(p_id, password);
    }

    public void updateUser(User users) {
        userDAO.updateUser(users);
    }

    public LiveData<List<User>> getManagers() {
        return userDAO.getManagers();
    }

    public LiveData<List<User>> getAllUser() {
        return userDAO.getStudents();
    }

}
