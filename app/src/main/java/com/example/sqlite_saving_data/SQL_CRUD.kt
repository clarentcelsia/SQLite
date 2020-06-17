package com.example.sqlite_saving_data

import android.provider.BaseColumns
import com.example.sqlite_saving_data.SQLContract.StudentsEntry.TABLE_NAME

class SQL_CRUD {

    //CRUD DATABASE

    object CRUD_STUDENTS {
        //CREATE TABLE tbStudents (id, name, gender, phone)
        const val CREATE_TABLE = "CREATE TABLE ${TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${SQLContract.StudentsEntry.TABLE_COLUMN_NAME} TEXT," +
                "${SQLContract.StudentsEntry.TABLE_COLUMN_GENDER} TEXT," +
                "${SQLContract.StudentsEntry.TABLE_COLUMN_PHONE} TEXT);"

        //DROP TABLE IF EXISTS tbStudents
        const val DROP_TABLE = "DROP TABLE IF EXISTS ${TABLE_NAME}";

        //INSERT INTO tbStudents VALUES (ID, NAME, GENDER, PHONE);
        const val INSERT_TABLE = "INSERT INTO ${TABLE_NAME} VALUES (" +
                "${BaseColumns._ID}, " +
                "${SQLContract.StudentsEntry.TABLE_COLUMN_NAME}, " +
                "${SQLContract.StudentsEntry.TABLE_COLUMN_GENDER}, " +
                "${SQLContract.StudentsEntry.TABLE_COLUMN_PHONE});"

        //SELECT TABLE
        const val SELECT_TABLE = "SELECT * FROM ${TABLE_NAME}"
    }
}