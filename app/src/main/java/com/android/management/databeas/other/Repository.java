package com.android.management.databeas.other;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.android.management.databeas.DAO.BranchDAO;
import com.android.management.databeas.DAO.CenterDAO;
import com.android.management.databeas.DAO.EpisodesDAO;
import com.android.management.databeas.DAO.UserDAO;
import com.android.management.model.Branch;
import com.android.management.model.Center;
import com.android.management.model.Episodes;
import com.android.management.model.User;

import java.util.List;

public class Repository {

    UserDAO userDAO;
    CenterDAO centerDAO;
    BranchDAO branchDAO;
    EpisodesDAO episodesDAO;

    public Repository(Application application) {
        MyDatabase db = MyDatabase.getDatabase(application);
        userDAO = db.userDAO();
        centerDAO = db.centerDAO();
        branchDAO = db.branchDAO();
        episodesDAO = db.episodesDAO();
    }

    // TODO : USER Queries

    public long insertUser(User users) {
        return userDAO.insertUser(users);
    }

    public long updateUser(User users) {
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

    public List<String> getAdminsName() {
        return userDAO.getAdminsName();
    }

    public LiveData<List<User>> getStudents() {
        return userDAO.getStudents();
    }

    public LiveData<List<User>> getStudentsByEpisodes(String episodeName) {
        return userDAO.getStudentsByEpisodes(episodeName);
    }

    public LiveData<List<User>> getWalletsByEpisodes(String episodeName) {
        return userDAO.getWalletsByEpisodes(episodeName);
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

    public long updateCenter(Center model) {
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

    // TODO : Branch Queries

    public long insertBranch(Branch model) {
        return branchDAO.insertBranch(model);
    }

    public long updateBranch(Branch model) {
        return branchDAO.updateBranch(model);
    }

    public int deleteBranch(Branch model) {
        return branchDAO.deleteBranch(model);
    }

    public LiveData<List<Branch>> getAllBranch() {
        return branchDAO.getAllBranch();
    }

    public List<String> getAllBranchName() {
        return branchDAO.getAllBranchName();
    }

    // TODO : Episodes Queries

    public long insertEpisodes(Episodes model) {
        return episodesDAO.insertEpisodes(model);
    }

    public long updateEpisodes(Episodes model) {
        return episodesDAO.updateEpisodes(model);
    }

    public int deleteEpisodes(Episodes model) {
        return episodesDAO.deleteEpisodes(model);
    }

    public LiveData<List<Episodes>> getAllEpisodes() {
        return episodesDAO.getAllEpisodes();
    }

    public LiveData<List<Episodes>> getEpisodesByCenter(String centerName) {
        return episodesDAO.getEpisodesByCenter(centerName);
    }

    public LiveData<List<Episodes>> getEpisodesByAdmin(String adminName) {
        return episodesDAO.getEpisodesByAdmin(adminName);
    }

    public List<String> getAllEpisodesName() {
        return episodesDAO.getAllEpisodesName();
    }
}
