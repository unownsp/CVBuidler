package com.saugat.cvbuilderapplication.fragment

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.saugat.cvbuilderapplication.R
import com.saugat.cvbuilderapplication.WebPageActivity
import com.saugat.cvbuilderapplication.databinding.FragmentContactBinding

class ContactFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mobileLl.setOnClickListener(this)
        binding.emailLl.setOnClickListener(this)
        binding.linkedinLl.setOnClickListener(this)
        binding.githubLl.setOnClickListener(this)
        binding.resumeLl.setOnClickListener(this)
    }
    private fun onMobileClicked() {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+16418192321"))
        context?.startActivity(intent)
    }

    private fun onEmailClicked() {
        sendEmail()
    }

    private fun onLinkedInClicked() {
        openWebUrl(getString(R.string.linkedin_profile))
    }

    private fun onGithubClicked() {
        openWebUrl(getString(R.string.github_profile))
    }

    private fun onResumeClicked() {

    }

    private fun openWebUrl(url: String) {
        val intent = Intent(requireActivity(), WebPageActivity::class.java)
        intent.putExtra("url", url)
        requireContext().startActivity(intent)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.mobile_ll -> onMobileClicked()
            R.id.email_ll -> onEmailClicked()
            R.id.linkedin_ll -> onLinkedInClicked()
            R.id.github_ll -> onGithubClicked()
            R.id.resume_ll -> onResumeClicked()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContactFragment()
    }


    private fun sendEmail() {
        val isAppInstalled: Boolean = isAppAvailable("com.google.android.gm")
        if (isAppInstalled) {
            val myIntent = Intent(Intent.ACTION_SEND)
            myIntent.data = (Uri.parse("mailto:" + getString(R.string.email)))
            myIntent.type = "text/plain"
            myIntent.setPackage("com.google.android.gm")
            myIntent.putExtra(Intent.EXTRA_EMAIL, getString(R.string.email))
            startActivity(Intent.createChooser(myIntent, "Share with"))
        } else {
            Toast.makeText(requireContext(), "App not Installed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isAppAvailable(appName: String?): Boolean {
        return try {
            requireContext().packageManager.getPackageInfo(appName!!, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }
}