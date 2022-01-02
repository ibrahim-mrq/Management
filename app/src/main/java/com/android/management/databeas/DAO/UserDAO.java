package com.android.management.databeas.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.android.management.model.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void insertUser(User... user);

    @Update
    void updateUser(User user);

    @Delete
    boolean deleteUser(User user);

    @Query("delete from User where id = :id")
    boolean deleteUserById(int id);

    @Query("select * from User where validity = 0 order by fullName asc ")
    List<User> getManagers();

    @Query("select * from User where validity = 1 order by fullName asc ")
    List<User> getAdmins();

    @Query("select * from User where validity = 2 order by fullName asc ")
    List<User> getWallets();

    @Query("select * from User where validity = 3 order by fullName asc ")
    LiveData<List<User>> getStudents();

    @Query("select * from User where fullName like '%' ||:fullName ||'%'")
    List<User> getStudentsByName(String fullName);

    @Query("select * from User where email = :email AND password = :password ")
    User login(String email, String password);

    @Query("INSERT INTO User VALUES(:user)")
    User register(User user);

    @Query("select * from User where id =:id AND validity = 3 ")
    User studentsById(int id);

    // مجموع الارقام الي بالعمود ل مستخدم
    @Query("select sum(id) from User where id = :id ")
    double getRate(int id);

}
