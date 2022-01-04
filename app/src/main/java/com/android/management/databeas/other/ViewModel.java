package com.android.management.databeas.other;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.android.management.model.Branch;
import com.android.management.model.Center;
import com.android.management.model.Episodes;
import com.android.management.model.User;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    Repository repository;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    // TODO : USER Queries

    public long insertUser(User users) {
        return repository.insertUser(users);
    }

    public long updateUser(User users) {
        return repository.updateUser(users);
    }

    public int deleteUser(User users) {
        return repository.deleteUser(users);
    }

    public int deleteUserByName(String name) {
        return repository.deleteUserByName(name);
    }

    public boolean isUserIdExist(String p_id) {
        return repository.isUserIdExist(p_id);
    }

    public boolean isUserEmailExist(String email) {
        return repository.isUserEmailExist(email);
    }

    public User login(String p_id, String password) {
        return repository.login(p_id, password);
    }

    public LiveData<List<User>> getAdmins() {
        return repository.getAdmins();
    }

    public LiveData<List<User>> getManagers() {
        return repository.getManagers();
    }

    public List<String> getManagersName() {
        return repository.getManagersName();
    }

    public List<String> getAdminsName() {
        return repository.getAdminsName();
    }

    public LiveData<List<User>> getStudents() {
        return repository.getStudents();
    }

    public LiveData<List<User>> getStudentsByEpisodes(String episodeName) {
        return repository.getStudentsByEpisodes(episodeName);
    }

    public LiveData<List<User>> getWalletsByEpisodes(String episodeName) {
        return repository.getWalletsByEpisodes(episodeName);
    }

    public LiveData<List<User>> getWallets() {
        return repository.getWallets();
    }

    public User getStudentsByName(String name) {
        return repository.getStudentsByName(name);
    }

    // TODO : Center Queries

    public long insertCenter(Center model) {
        return repository.insertCenter(model);
    }

    public long updateCenter(Center model) {
        return repository.updateCenter(model);
    }

    public int deleteCenter(Center model) {
        return repository.deleteCenter(model);
    }

    public LiveData<List<Center>> getAllCenter() {
        return repository.getAllCenter();
    }

    public List<String> getAllCenterName() {
        return repository.getAllCenterName();
    }

    // TODO : Branch Queries

    public long insertBranch(Branch model) {
        return repository.insertBranch(model);
    }

    public long updateBranch(Branch model) {
        return repository.updateBranch(model);
    }

    public int deleteBranch(Branch model) {
        return repository.deleteBranch(model);
    }

    public LiveData<List<Branch>> getAllBranch() {
        return repository.getAllBranch();
    }

    public List<String> getAllBranchName() {
        return repository.getAllBranchName();
    }

    // TODO : Episodes Queries

    public long insertEpisodes(Episodes model) {
        return repository.insertEpisodes(model);
    }

    public long updateEpisodes(Episodes model) {
        return repository.updateEpisodes(model);
    }

    public int deleteEpisodes(Episodes model) {
        return repository.deleteEpisodes(model);
    }

    public LiveData<List<Episodes>> getAllEpisodes() {
        return repository.getAllEpisodes();
    }

    public LiveData<List<Episodes>> getEpisodesByCenter(String centerName) {
        return repository.getEpisodesByCenter(centerName);
    }

    public LiveData<List<Episodes>> getEpisodesByAdmin(String adminName) {
        return repository.getEpisodesByAdmin(adminName);
    }

    public List<String> getAllEpisodesName() {
        return repository.getAllEpisodesName();
    }

}
