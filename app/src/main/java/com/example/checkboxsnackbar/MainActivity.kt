package com.example.checkboxsnackbar

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var inputText: EditText
    private lateinit var outputText: TextView
    private lateinit var saveButton: Button
    private lateinit var delButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputText = findViewById(R.id.inputText)
        outputText = findViewById(R.id.outputText)
        saveButton = findViewById(R.id.saveButton)
        delButton = findViewById(R.id.delButton)

    }

    fun save(view: View) {
        outputText.text = inputText.text
    }

    fun delete(view: View) {
        Snackbar.make(view, "Подтвердите удаление", Snackbar.LENGTH_LONG)
            .setAction("Удалить") {
                outputText.text = ""
                Snackbar.make(view, "Данные удалены", Snackbar.LENGTH_LONG).show()
            }.show()
    }
}