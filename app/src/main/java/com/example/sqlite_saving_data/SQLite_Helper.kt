package com.example.sqlite_saving_data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.sqlite_saving_data.SQLContract.StudentsEntry.DB_NAME
import com.example.sqlite_saving_data.SQLContract.StudentsEntry.TABLE_COLUMN_GENDER
import com.example.sqlite_saving_data.SQLContract.StudentsEntry.TABLE_COLUMN_ID
import com.example.sqlite_saving_data.SQLContract.StudentsEntry.TABLE_COLUMN_NAME
import com.example.sqlite_saving_data.SQLContract.StudentsEntry.TABLE_COLUMN_PHONE
import com.example.sqlite_saving_data.SQLContract.StudentsEntry.TABLE_NAME
import com.example.sqlite_saving_data.SQL_CRUD.CRUD_STUDENTS.CREATE_TABLE
import com.example.sqlite_saving_data.SQL_CRUD.CRUD_STUDENTS.DROP_TABLE
import com.example.sqlite_saving_data.SQL_CRUD.CRUD_STUDENTS.SELECT_TABLE

//CREATE DATABASE

//CLASS SQLITE BRINGS CONTEXT AND EXTENDS OPEN_SQLite_HELPER
class SQLite_Helper (context : Context) : SQLiteOpenHelper(
    context,
    SQLContract.StudentsEntry.DB_NAME,
    null,
    SQLContract.StudentsEntry.DB_VERSION){

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL(CREATE_TABLE)
        }else {
            System.out.println("DATABASE IS NULL")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVer: Int, newVer: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        if (db != null) {
            db.execSQL(DROP_TABLE)
            onCreate(db)
        }else {
            System.out.println("DATABASE IS NULL")
        }
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    //INSERT RECORD
    fun insertSudents (student: Student){

        //WRITABLE DATABASE
        val db = this.writableDatabase

        //RECORD VALUES
        val record = ContentValues().apply {
            put(TABLE_COLUMN_NAME, student.name)
            put(TABLE_COLUMN_GENDER, student.gender)
            put(TABLE_COLUMN_PHONE, student.phone)
        }

        //INSERT VALUES
        db.insert(TABLE_NAME, null, record)
        //CLOSE DB
        db.close()
    }

    //READ INFORMATION FROM DB
    fun getStudents(context:Context) : ArrayList<Student>{
        //ACCESS DB READABLE
        val db = this.readableDatabase
        val cursor = db.rawQuery(SELECT_TABLE, null)

        val students = ArrayList<Student>()
        if(cursor.count == 0){
            Toast.makeText(context, "Null", Toast.LENGTH_SHORT).show()
        }else {
            while (cursor.moveToNext()) {
                //CREATE NEW STUDENTS DATA (LOOPING)
                val studs = Student()
                studs.name = cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_NAME))
                studs.gender = cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_GENDER))
                studs.phone = cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_PHONE))

                students.add(studs)
            }
        }

        cursor.close()
        return students
    }

    companion object{
        //JIKA TERJADI PERUBAHAN SKEMA DATABASE
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "dbStudents"
        const val TABLE_NAME = "tbStudents"
        const val TABLE_COLUMN_ID = "ID"
        const val TABLE_COLUMN_NAME = "Name"
        const val TABLE_COLUMN_GENDER = "Gender"
        const val TABLE_COLUMN_PHONE = "Phone"
    }

}

//fun = function = void
// ? = VARIBLE CAN BE FILLED WITH NULL

//INSERT RECORD :
//The first argument for insert() is simply the table name.
//
//The second argument tells the framework what to do in the event that the ContentValues is empty
// (i.e., you did not put any values). If you specify the name of a column,
// the framework inserts a row and sets the value of that column to null. If you specify null,
// like in this code sample, the framework does not insert a row when there are no values.
//
//The insert() methods returns the ID for the newly created row,
//or it will return -1 if there was an error inserting the data.
//This can happen if you have a conflict with pre-existing data in the database.