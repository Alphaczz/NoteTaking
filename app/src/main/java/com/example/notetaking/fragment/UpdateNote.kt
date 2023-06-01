package com.example.notetaking.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

import com.example.notetaking.R
import com.example.notetaking.adapter.NoteAdapter
import com.example.notetaking.databinding.FragmentHomeBinding
import com.example.notetaking.databinding.FragmentUpdateNoteBinding
import com.example.notetaking.room.Note
import com.example.notetaking.viewmodel.NotesViewModel
import androidx.navigation.fragment.navArgs
import com.example.notetaking.MainActivity

/**
 * A simple [Fragment] subclass.
 * Use the [updateNote.newInstance] factory method to
 * create an instance of this fragment.
 */
class updateNote : Fragment(R.layout.fragment_update_note) {
    // TODO: Rename and change types of parameters

    private var _binding: FragmentUpdateNoteBinding? = null
    private lateinit var currentNote: Note
    private val binding get() = _binding!!
    private lateinit var notesViewModel: NotesViewModel
    private val args: updateNoteArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentUpdateNoteBinding.inflate(inflater,container,false)
        return  binding.root   }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel=(activity as MainActivity).notesViewModel
        currentNote=args.notes !!
        binding.etNoteTitleUpdate.setText(currentNote.noteTitle)
        binding.etNoteBodyUpdate.setText(currentNote.noteBody)
        binding.fabDone.setOnClickListener{
            val title=binding.etNoteTitleUpdate.text.toString().trim()
            val body=binding.etNoteBodyUpdate.text.toString().trim()
            if(title.isNotEmpty())
            {
                val note=Note(currentNote.id,title,body)
                notesViewModel.updateNotes(note)
                view.findNavController().navigate(R.id.action_updateNote_to_home2)

            }
            else{
                Toast.makeText(context, "Please enter New Title", Toast.LENGTH_LONG).show()

            }


        }



    }
    private  fun deleteNote()
    {
 AlertDialog.Builder(activity).apply {
     setTitle("Delete Note")
     setMessage("Are you Sure ?")
     setPositiveButton("Delete") { _, _ ->
         notesViewModel.deleteNotes(currentNote)
         view?.findNavController()?.navigate(
             R.id.action_updateNote_to_home2
         )
     }
     setNegativeButton("cancel",null)
 }.create().show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_update,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_delete->{
                deleteNote()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }


}