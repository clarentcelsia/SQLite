package com.example.sqlite_saving_data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqlite_saving_data.SQLite_Helper.Companion.TABLE_COLUMN_GENDER
import com.example.sqlite_saving_data.SQLite_Helper.Companion.TABLE_COLUMN_NAME
import com.example.sqlite_saving_data.SQLite_Helper.Companion.TABLE_COLUMN_PHONE
import com.example.sqlite_saving_data.adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_detail.*
import java.lang.NullPointerException

class Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //IMPORT SQL HELPER
        val db = SQLite_Helper(this)
        val listStudents = db.getStudents(this)

        //SET RECYCLER
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(this)
        val listAdapter = ListAdapter(listStudents)
        recycler.adapter = listAdapter


//

    }

}


//mutableListOf = ArrayList<>

//var contentName: String = ""
//        var contentGender: String = ""
//        var contentPhone: String = ""

//        cursor!!.moveToFirst()
//        contentName += cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_NAME)) + System.lineSeparator()
//        contentGender += cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_GENDER)) + System.lineSeparator()
//        contentPhone += cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_PHONE)) + System.lineSeparator()
//        while (cursor.moveToNext()) {
//            try {
//                contentName += cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_NAME)) + System.lineSeparator()
//                contentGender += cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_GENDER)) + System.lineSeparator()
//                contentPhone += cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_PHONE)) + System.lineSeparator()
//
//            } catch (e: NullPointerException) {
//                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
//            }
//        }

//        tvDetail_Nm.append(contentName)
//        tvDetail_Nm.append("\n")
//        tvDetail_Gn.append(contentGender)
//        tvDetail_Gn.append("\n")
//        tvDetail_ph.append(contentPhone)
//        tvDetail_ph.append("\n")

