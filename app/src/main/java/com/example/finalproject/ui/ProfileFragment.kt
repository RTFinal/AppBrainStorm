package com.example.finalproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.finalproject.R

class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.username_text).text = viewModel.username
        view.findViewById<TextView>(R.id.ideas_count_text).text = "${viewModel.totalIdeas}\nIdeas"
        view.findViewById<TextView>(R.id.followers_count_text).text = "${viewModel.followers}\nFollowers"
        view.findViewById<TextView>(R.id.following_count_text).text = "${viewModel.following}\nFollowing"
        view.findViewById<TextView>(R.id.bio_text).text = viewModel.bio
    }
}
