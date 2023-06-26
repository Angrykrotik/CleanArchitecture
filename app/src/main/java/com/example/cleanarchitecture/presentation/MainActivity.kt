package com.example.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.cleanarchitecture.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dataText = findViewById<TextView>(R.id.tv_user_data)
        val getButton = findViewById<Button>(R.id.btn_get_user)
        val dataEditView = findViewById<EditText>(R.id.et_user)
        val saveButton = findViewById<Button>(R.id.btn_save_user)

        viewModel.resultLive.observe(this) {
            dataText.text = it
        }

        getButton.setOnClickListener {
            viewModel.load()
        }

        saveButton.setOnClickListener {
            val text = dataEditView.text.toString()
            viewModel.save(text)
        }
    }
}