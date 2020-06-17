package com.example.sqlite_saving_data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlite_saving_data.SQLite_Helper.Companion.TABLE_COLUMN_GENDER
import com.example.sqlite_saving_data.SQLite_Helper.Companion.TABLE_COLUMN_NAME
import com.example.sqlite_saving_data.SQLite_Helper.Companion.TABLE_COLUMN_PHONE
import kotlinx.android.synthetic.main.activity_detail.*
import java.lang.NullPointerException

class Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //IMPORT SQL HELPER
        val db = SQLite_Helper(this)
        val cursor = db.getStudents()

        //SET VALUES
        var contentName: String = ""
        var contentGender: String = ""
        var contentPhone: String = ""

        cursor!!.moveToFirst()
        contentName += cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_NAME)) + System.lineSeparator()
        contentGender += cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_GENDER)) + System.lineSeparator()
        contentPhone += cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_PHONE)) + System.lineSeparator()
        while (cursor.moveToNext()) {
            try {
                contentName += cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_NAME)) + System.lineSeparator()
                contentGender += cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_GENDER)) + System.lineSeparator()
                contentPhone += cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_PHONE)) + System.lineSeparator()

            } catch (e: NullPointerException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }

        tvDetail_Nm.append(contentName)
        tvDetail_Nm.append("\n")
        tvDetail_Gn.append(contentGender)
        tvDetail_Gn.append("\n")
        tvDetail_ph.append(contentPhone)
        tvDetail_ph.append("\n")
        cursor.close()

    }

}


//mutableListOf = ArrayList<>

//NOTE
//tableRow = TableRow(this)
//        val itemIds = mutableListOf<String>()
//        with(cursor) {
//            while (this!!.moveToNext()) {
//                val itemId = getString(getColumnIndex(BaseColumns._ID))
//                itemIds.add(itemId)
//            }
//        }

//SET TABLE ROW
//        val layoutparams: TableLayout.LayoutParams = TableLayout.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT
//        )
//
//        val rowparams: TableRow.LayoutParams = TableRow.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT
//        )

//        tableLayout!!.layoutParams = layoutparams
//        tableRow!!.layoutParams = rowparams

// SET ROW VALUE (TITLE)
//        val tvId = TextView(this) //TextView tvId = new TextView(this)
//        tvId.setText("ID"); tvId.setTextColor(Color.WHITE); tableRow!!.addView(tvId)
//
//        val tvName = TextView(this)
//        tvName.setText("Name"); tvName.setTextColor(Color.WHITE); tableRow!!.addView(tvName)
//
//        val tvGender = TextView(this)
//        tvGender.setText("Gender"); tvGender.setTextColor(Color.WHITE); tableRow!!.addView(tvGender)
//
//        val tvPhone = TextView(this)
//        tvPhone.setText("Phone"); tvPhone.setTextColor(Color.WHITE); tableRow!!.addView(tvPhone)
//
//        tableLayout!!.addView(tableRow)
//
//
//        cursor!!.moveToFirst()
//        var tableRow1 = TableRow(this)
////        tableRow1.layoutParams = rowparams
//
//        val tvId1 = TextView(this) //TextView tvId = new TextView(this)
//        tvId1.setText(cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_ID)))
//        tvId1.setTextColor(Color.WHITE); tableRow1.addView(tvId1)
//        val tvName1 = TextView(this)
//        tvName1.setText(cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_NAME)))
//        tvName1.setTextColor(Color.WHITE); tableRow1.addView(tvName1)
//        val tvGender1 = TextView(this)
//        tvGender1.setText(cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_GENDER)))
//        tvGender1.setTextColor(Color.WHITE); tableRow1.addView(tvGender1)
//        val tvPhone1 = TextView(this)
//        tvPhone1.setText(cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_PHONE)))
//        tvPhone1.setTextColor(Color.WHITE); tableRow1.addView(tvPhone1)
//
//        tableLayout!!.addView(tableRow1)
//
//        while (cursor.moveToNext()) {
//            val tvId2 = TextView(this) //TextView tvId = new TextView(this)
//            tvId2.setText(cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_ID)))
//            tvId2.setTextColor(Color.WHITE); tableRow1.addView(tvId2)
//            val tvName2 = TextView(this)
//            tvName2.setText(cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_NAME)))
//            tvName2.setTextColor(Color.WHITE); tableRow1.addView(tvName2)
//            val tvGender2 = TextView(this)
//            tvGender2.setText(cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_GENDER)))
//            tvGender2.setTextColor(Color.WHITE); tableRow1.addView(tvGender2)
//            val tvPhone2 = TextView(this)
//            tvPhone2.setText(cursor.getString(cursor.getColumnIndex(TABLE_COLUMN_PHONE)))
//            tvPhone2.setTextColor(Color.WHITE); tableRow1.addView(tvPhone2)
//
//            tableLayout!!.addView(tableRow1)
//        }