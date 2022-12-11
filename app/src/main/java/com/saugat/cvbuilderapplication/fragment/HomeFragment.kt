package com.saugat.cvbuilderapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.saugat.cvbuilderapplication.databinding.FragmentHomeBinding
import com.saugat.cvbuilderapplication.utils.Constants.SHARED_PREF_NAME
import com.saugat.cvbuilderapplication.utils.Constants.USER_EMAIL
import com.saugat.cvbuilderapplication.utils.Constants.USER_NAME

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        initUserData()
    }

    private fun initViews(view: View) {

        binding.floatingAddButton.setOnClickListener {
            Snackbar.make(view, "Add Additional fields on home page", Snackbar.LENGTH_LONG).show()
        }

    }

    private fun initUserData() {
        val sharedPref = requireActivity().getSharedPreferences(SHARED_PREF_NAME, 0)
        val userName = sharedPref.getString(USER_NAME, "")
        val userEmail = sharedPref.getString(USER_EMAIL, "")

        binding.userNameTextView.text = userName
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}