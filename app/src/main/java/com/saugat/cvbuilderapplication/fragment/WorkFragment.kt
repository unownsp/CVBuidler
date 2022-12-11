package com.saugat.cvbuilderapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.saugat.cvbuilderapplication.adapter.WorkAdapter
import com.saugat.cvbuilderapplication.databinding.FragmentWorkBinding
import com.saugat.cvbuilderapplication.pojo.Work

class WorkFragment : Fragment() {
    private var _binding: FragmentWorkBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = WorkAdapter(Work.getWorkList())
        binding.workRecyclerView.adapter = adapter
    }

    companion object {

        @JvmStatic
        fun newInstance() = WorkFragment()
    }
}