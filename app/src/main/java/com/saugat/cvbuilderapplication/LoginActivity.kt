package com.saugat.cvbuilderapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.saugat.cvbuilderapplication.databinding.ActivityLoginBinding
import com.saugat.cvbuilderapplication.utils.Constants.SHARED_PREF_NAME
import com.saugat.cvbuilderapplication.utils.Constants.IS_LOGGED_IN
import com.saugat.cvbuilderapplication.utils.Constants.USER_EMAIL
import com.saugat.cvbuilderapplication.utils.Constants.USER_NAME
import com.saugat.cvbuilderapplication.utils.Constants.USER_PASSWORD

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences(SHARED_PREF_NAME, 0)
        if (sharedPref.getBoolean(IS_LOGGED_IN, false)) {
            openMainActivity()
        } else {
            initSharedPreference()
        }

        binding.loginButton.setOnClickListener {
            if (validateFields()) {
                if (checkAuthorization()) {
                    val editor = sharedPref.edit()
                    editor.putBoolean(IS_LOGGED_IN, true)
                    editor.apply()

                    openMainActivity()

                }else {
                    Toast.makeText(this,"Email or Password does not match!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initSharedPreference() {
        val sharedPref = getSharedPreferences(SHARED_PREF_NAME, 0)
        val editor = sharedPref.edit()
        editor.putString(USER_EMAIL, "saugatpageni@miu.edu")
        editor.putString(USER_PASSWORD, "saugat")
        editor.putString(USER_NAME, "Saugat Pageni")
        editor.putBoolean(IS_LOGGED_IN, false)
        editor.apply()
    }

    private fun checkAuthorization(): Boolean {
        val sharedPref = getSharedPreferences(SHARED_PREF_NAME,0)
        val email = sharedPref.getString(USER_EMAIL,"")
        val password = sharedPref.getString(USER_PASSWORD,"")

        if (binding.emailEditText.editText?.text.toString().trim() != email ||
            binding.passwordEditText.editText?.text.toString().trim() != password) {
            return false
        }
        return true
    }

    private fun validateFields(): Boolean {
        if (binding.emailEditText.editText?.text!!.isEmpty()) {
            binding.emailEditText.error = "Email cannot be empty"
            binding.emailEditText.requestFocus()
            return false
        } else if (binding.passwordEditText.editText?.text!!.isEmpty()) {
            binding.passwordEditText.error = "Password cannot be empty"
            binding.passwordEditText.requestFocus()
            return false
        }
        return true
    }
}