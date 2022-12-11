package com.saugat.cvbuilderapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.saugat.cvbuilderapplication.adapter.CertificateAdapter
import com.saugat.cvbuilderapplication.adapter.EducationAdapter
import com.saugat.cvbuilderapplication.databinding.FragmentAboutMeBinding
import com.saugat.cvbuilderapplication.pojo.Certification
import com.saugat.cvbuilderapplication.pojo.Education

class AboutMeFragment : Fragment() {
    private var _binding: FragmentAboutMeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutMeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEducation()
        initCertification()
    }

    private fun initEducation() {
        val adapter = EducationAdapter(Education.getEducationList())
        binding.educationRecyclerView.adapter = adapter
    }

    private fun initCertification() {
        val adapter = CertificateAdapter(Certification.getCertificateList())
        binding.certificationRecyclerView.adapter = adapter
    }

    companion object {
        fun newInstance() = AboutMeFragment()
    }
}