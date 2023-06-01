package com.example.notetaking.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.notetaking.MainActivity

import com.example.notetaking.R
import com.example.notetaking.adapter.NoteAdapter
import com.example.notetaking.databinding.FragmentHomeBinding
import com.example.notetaking.databinding.FragmentNewNoteBinding
import com.example.notetaking.room.Note
import com.example.notetaking.viewmodel.NotesViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [new_note.newInstance] factory method to
 * create an instance of this fragment.
 */
class new_note : Fragment(R.layout.fragment_new_note)
{
private lateinit var mView: View
    private var _binding: FragmentNewNoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var notesViewModel: NotesViewModel
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel = (activity as MainActivity).notesViewModel
        mView=view
    }
    private fun  saveNote(view: View) {
        val noteTitle = binding.etNoteTitle.text.toString().trim()
        val noteBody = binding.etNoteBody.text.toString().trim()
        if (noteTitle.isNotEmpty()) {
            val note = Note(0, noteTitle, noteTitle)
            notesViewModel.addNotes(note)
            Toast.makeText(mView.context, "Note Saved Successfully", Toast.LENGTH_LONG).show()
            view.findNavController().navigate(R.id.action_new_note_to_home2)
        } else {
            Toast.makeText(mView.context, "Please enter New Title", Toast.LENGTH_LONG).show()

        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_newnote, menu)
        super.onCreateOptionsMenu(menu,inflater)

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       when(item.itemId){
           R.id.menu_save->{
               saveNote(mView)
           }
       }
        return super.onOptionsItemSelected(item)
    }

}


