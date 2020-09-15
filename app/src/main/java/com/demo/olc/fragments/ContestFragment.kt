package com.demo.olc.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.olc.R
import com.demo.olc.viewmodels.ContestViewModel

class ContestFragment : Fragment() {

    companion object {
        fun newInstance() = ContestFragment()
    }

    private lateinit var viewModel: ContestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.contest_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ContestViewModel::class.java)
        // TODO: Use the ViewModel
    }

}