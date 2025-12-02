package com.example.finalproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.google.android.material.textfield.TextInputEditText

class AddIdeaFragment : Fragment() {

    private val viewModel: AddIdeaViewModel by viewModels {
        AddIdeaViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_idea, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categories = arrayOf("Business", "Technology", "Creative", "Personal")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, categories)
        val categoryDropDown = view.findViewById<AutoCompleteTextView>(R.id.category_dropdown_auto_complete)
        categoryDropDown.setAdapter(adapter)

        val titleEditText = view.findViewById<TextInputEditText>(R.id.title_input_edit_text)
        val descriptionEditText = view.findViewById<TextInputEditText>(R.id.description_input_edit_text)

        view.findViewById<Button>(R.id.save_button).setOnClickListener {
            val title = titleEditText.text.toString()
            val category = categoryDropDown.text.toString()
            val description = descriptionEditText.text.toString()

            if (title.isBlank() || category.isBlank() || description.isBlank()) {
                Toast.makeText(context, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.saveIdea(title, category, description)
                findNavController().navigate(R.id.homeFragment)
            }
        }
    }
}
