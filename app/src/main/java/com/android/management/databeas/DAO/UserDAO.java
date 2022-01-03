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

    @Insert(onConflict = OnConflictStrategy.FAIL)
    long insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("delete from User where fullName = :fullName")
    void deleteUserByName(String fullName);

    @Query("select * from User where validity = \"Manager\" order by fullName asc ")
    LiveData<List<User>> getManagers();

    @Query("select * from User where validity = \"Admin\" order by fullName asc ")
    LiveData<List<User>> getAdmins();

    @Query("select * from User where validity = \"Wallet\" order by fullName asc ")
    LiveData<List<User>> getWallets();

    @Query("select * from User where validity = \"Student\" order by fullName asc ")
    LiveData<List<User>> getStudents();

    @Query("select * from User where fullName like '%' ||:fullName ||'%'")
    LiveData<List<User>> getStudentsByName(String fullName);

    @Query("select * from User where p_id = :p_id AND password = :password ")
    User login(String p_id, String password);

    @Query("select * from User where id =:id AND validity = 3 ")
    User studentsById(String id);

    // مجموع الارقام الي بالعمود ل مستخدم
    @Query("select sum(id) from User where id = :id ")
    double getRate(int id);

}
