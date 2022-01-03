package com.android.management.databeas.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.android.management.model.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert()
    long insertUser(User user);

    @Update
    int updateUser(User user);

    @Delete
    int deleteUser(User user);

    @Query("SELECT EXISTS(SELECT * FROM User WHERE p_id = :p_id)")
    Boolean isUserIdExist(String p_id);

    @Query("SELECT EXISTS(SELECT * FROM User WHERE email = :email)")
    Boolean isUserEmailExist(String email);

    @Query("delete from User where fullName = :fullName")
    int deleteUserByName(String fullName);

    @Query("select fullName from User where validity = \"Manager\" order by fullName asc ")
    List<String> getManagersName();

    @Query("select * from User where validity = \"Manager\" order by fullName asc ")
    LiveData<List<User>> getManagers();

    @Query("select * from User where validity = \"Admin\" order by fullName asc ")
    LiveData<List<User>> getAdmins();

    @Query("select * from User where validity = \"Wallet\" order by fullName asc ")
    LiveData<List<User>> getWallets();

    @Query("select * from User where validity = \"Student\" order by fullName asc ")
    LiveData<List<User>> getStudents();

    @Query("select * from User where fullName like '%' ||:fullName ||'%'")
    User getStudentsByName(String fullName);

    @Query("select * from User where p_id = :p_id AND password = :password ")
    User login(String p_id, String password);

    // مجموع الارقام الي بالعمود ل مستخدم
    @Query("select sum(id) from User where id = :id ")
    double getRate(int id);

}
