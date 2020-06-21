package com.example.sqlite_saving_data

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var etName : TextInputEditText? = null
    private var etGender : TextInputEditText? = null
    private var etPhone : TextInputEditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etGender = findViewById(R.id.etGender)
        etPhone = findViewById(R.id.etTelp)

    }

    fun Save(view: View) {
        val submit = SQLite_Helper(this)

        val names = etName?.text.toString()
        val genders = etGender?.text.toString()
        val phones = etPhone?.text.toString()

        val students = Student()
        students.id = BaseColumns._ID
        students.name = names
        students.gender = genders
        students.phone = phones

        submit.insertSudents(students)
        createSnackbar(fabAdd)
    }

    fun createSnackbar(view : View){
        val snack = Snackbar.make(view, "Data saved successfully", Snackbar.LENGTH_LONG)
            .setAction("See profile", View.OnClickListener {
                val intent = Intent(this, Details::class.java).apply {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                }
                startActivity(intent)
            })
            .setActionTextColor(Color.YELLOW)
            .setTextColor(Color.WHITE)

        val snackbarGround = snack.view
        snackbarGround.setBackgroundColor(Color.DKGRAY)

        snack.show()
    }

}
