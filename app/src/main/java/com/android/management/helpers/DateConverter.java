package com.android.management.helpers;

import androidx.room.TypeConverter;

import java.util.Date;


public class DateConverter {

    @TypeConverter
    private static Date toDate(Long milliseconds) {
        return milliseconds == null ? null : new Date(milliseconds);
    }

    @TypeConverter
    private static Long fromDate(Date date) {
        return date == null ? null : date.getTime();
    }

}
