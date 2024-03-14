package com.example.todonotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todonotes.databinding.ActivityNotesBinding

class NotesActivity : AppCompatActivity(),NoteItemClickListener {

    private lateinit var binding: ActivityNotesBinding
    private lateinit var notes:MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra("userName")

        notes = mutableListOf<String>()

        val helloUserText = String.format("Hello, %s",userName)

        binding.personNameTV.text = helloUserText

        repeat(20){
            notes.add("Note $it")
        }

        val myLayoutManager = LinearLayoutManager(this)
        val notesAdapter = NotesAdapter(notes,this)

        binding.notesList.apply {
            layoutManager = myLayoutManager
            adapter = notesAdapter
//            addItemDecoration(DividerItemDecoration(this@NotesActivity,myLayoutManager.orientation))
        }

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this,"${notes[position]} clicked",Toast.LENGTH_SHORT).show()
    }

    override fun onItemDelete(position: Int) {
        notes.removeAt(position)
        binding.notesList.adapter?.notifyItemRemoved(position)
    }
}