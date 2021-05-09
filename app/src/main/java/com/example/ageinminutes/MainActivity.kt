package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.ageinminutes.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnDatePicker.setOnClickListener {view ->
            clickDatePicker(view)
            Toast.makeText(this, "Button works", Toast.LENGTH_LONG).show()
        }
    }

    fun clickDatePicker(view: View) {

        val myCalendar = Calendar.getInstance()
        val selectedYear = myCalendar.get(Calendar.YEAR)
        val selectedMonth = myCalendar.get(Calendar.MONTH)
        val selectedDayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)
        val tvSelectedDate : TextView = findViewById(R.id.tvSelectedDate) as TextView

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                datePicker, i, i2, i3 ->
                Toast.makeText(this, "The chosen year is $selectedYear, the month is $selectedMonth and the day is $selectedDayOfMonth"
                , Toast.LENGTH_LONG).show()

                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                tvSelectedDate.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

        },
            selectedYear,
            selectedMonth,
            selectedDayOfMonth).show()
    }
}