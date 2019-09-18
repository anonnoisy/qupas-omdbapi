package com.pandacode.task.qupas.qupasomdb

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.pandacode.task.qupas.qupasomdb.db.NoteDatabase
import com.pandacode.task.qupas.qupasomdb.db.dao.NoteDao
import com.pandacode.task.qupas.qupasomdb.db.entity.Note

class NoteRepository(application: Application) {

    private var noteDao: NoteDao

    private var allNotes: LiveData<List<Note>>

    init {
        val database: NoteDatabase = NoteDatabase.getInstance(
            application.applicationContext
        )!!
        noteDao = database.noteDao()
        allNotes = noteDao.getAllNotes()
    }

    fun insert(note: Note) {
        val insertNoteAsyncTask = InsertNoteAsyncTask(noteDao).execute(note)
    }

    fun deleteAllNotes() {
        val deleteAllNotesAsyncTask = DeleteAllNotesAsyncTask(
            noteDao
        ).execute()
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return allNotes
    }

    private class InsertNoteAsyncTask(noteDao: NoteDao) : AsyncTask<Note, Unit, Unit>() {
        val noteDao = noteDao

        override fun doInBackground(vararg p0: Note?) {
            noteDao.insert(p0[0]!!)
        }
    }


    private class DeleteAllNotesAsyncTask(val noteDao: NoteDao) : AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg p0: Unit?) {
            noteDao.deleteAllNotes()
        }
    }

}