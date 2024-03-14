package com.example.todonotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todonotes.databinding.NotesItemLayoutBinding

class NotesAdapter(private val toDoList: MutableList<String>,private val noteItemClickListener:NoteItemClickListener) :
    Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(val binding: NotesItemLayoutBinding) : ViewHolder(binding.root) {
        fun bind(note: String) {
            binding.noteTextView.text = note
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding =
            NotesItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = toDoList[position]
        holder.bind(note)
        holder.binding.root.setOnClickListener {
            noteItemClickListener.onItemClick(position)
        }
        holder.binding.deleteNoteBtn.setOnClickListener {
            noteItemClickListener.onItemDelete(position)
        }
    }
}