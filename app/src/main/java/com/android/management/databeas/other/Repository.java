package com.android.management.databeas.other;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.android.management.databeas.DAO.CenterDAO;
import com.android.management.databeas.DAO.UserDAO;
import com.android.management.model.Center;
import com.android.management.model.User;

import java.util.List;

public class Repository {

    UserDAO userDAO;
    CenterDAO centerDAO;

    public Repository(Application application) {
        MyDatabase db = MyDatabase.getDatabase(application);
        userDAO = db.userDAO();
        centerDAO = db.centerDAO();
    }

    // TODO : USER Queries

    public long insertUser(User users) {
        return userDAO.insertUser(users);
    }

    public int updateUser(User users) {
        return userDAO.updateUser(users);
    }

    public int deleteUser(User users) {
        return userDAO.deleteUser(users);
    }

    public int deleteUserByName(String name) {
        return userDAO.deleteUserByName(name);
    }

    public boolean isUserIdExist(String p_id) {
        return userDAO.isUserIdExist(p_id);
    }

    public boolean isUserEmailExist(String email) {
        return userDAO.isUserEmailExist(email);
    }

    public User login(String p_id, String password) {
        return userDAO.login(p_id, password);
    }

    public LiveData<List<User>> getAdmins() {
        return userDAO.getAdmins();
    }

    public LiveData<List<User>> getManagers() {
        return userDAO.getManagers();
    }

    public List<String> getManagersName() {
        return userDAO.getManagersName();
    }

    public LiveData<List<User>> getStudents() {
        return userDAO.getStudents();
    }

    public LiveData<List<User>> getWallets() {
        return userDAO.getWallets();
    }

    public User getStudentsByName(String name) {
        return userDAO.getStudentsByName(name);
    }

    // TODO : Center Queries

    public long insertCenter(Center model) {
        return centerDAO.insertCenter(model);
    }

    public int updateCenter(Center model) {
        return centerDAO.updateCenter(model);
    }

    public int deleteCenter(Center model) {
        return centerDAO.deleteCenter(model);
    }

    public LiveData<List<Center>> getAllCenter() {
        return centerDAO.getAllCenter();
    }

    public List<String> getAllCenterName() {
        return centerDAO.getAllCenterName();
    }

}
