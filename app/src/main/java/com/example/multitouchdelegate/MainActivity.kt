package com.example.multitouchdelegate

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = Adapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun handleClickButton(button: Button) {
        Toast.makeText(this, button.text, Toast.LENGTH_SHORT).show()
    }
}