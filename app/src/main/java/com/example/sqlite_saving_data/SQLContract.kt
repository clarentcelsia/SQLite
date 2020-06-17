package com.example.sqlite_saving_data

import android.provider.BaseColumns

class SQLContract {
    //STORING GLOBAL VARIABLE

    //INIT STUDENT implements BASE COLUMNS
    object StudentsEntry : BaseColumns {
        const val DB_NAME = "dbStudents";
        const val DB_VERSION = 1;
        const val TABLE_NAME = "tbStudents";
        const val TABLE_COLUMN_ID = "ID";
        const val TABLE_COLUMN_NAME = "Name";
        const val TABLE_COLUMN_GENDER = "Gender";
        const val TABLE_COLUMN_PHONE = "Phone";
    }

    //Object DosenEntry
}


//CONST VAL = FINAL {VARIABLE} CAN BE USED IN OBJECT ONLY