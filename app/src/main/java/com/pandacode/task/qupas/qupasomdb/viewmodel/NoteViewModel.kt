package com.pandacode.task.qupas.qupasomdb.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.pandacode.task.qupas.qupasomdb.NoteRepository
import com.pandacode.task.qupas.qupasomdb.db.entity.Movie
import com.pandacode.task.qupas.qupasomdb.db.entity.Note
import com.pandacode.task.qupas.qupasomdb.network.ApiEndpoint


class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: NoteRepository =
        NoteRepository(application)

    private var allNotes: LiveData<List<Note>> = repository.getAllNotes()
    private var movie = MutableLiveData<Movie>()

    init {

    }

    private fun getMovieByTitle(title: String) {
    }

    fun insert(note: Note) {
        repository.insert(note)
    }

    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return allNotes
    }
}