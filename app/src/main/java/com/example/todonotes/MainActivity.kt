package com.example.todonotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todonotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.startBtn.setOnClickListener {
            val userName = binding.nameEditText.text.toString()
            val intent = Intent(this,NotesActivity::class.java).apply {
                putExtra("userName",userName)
            }
            startActivity(intent)
        }

    }
}