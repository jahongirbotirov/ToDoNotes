package com.example.todonotes

interface NoteItemClickListener {
    fun onItemClick(position:Int)
    fun onItemDelete(position:Int)
}