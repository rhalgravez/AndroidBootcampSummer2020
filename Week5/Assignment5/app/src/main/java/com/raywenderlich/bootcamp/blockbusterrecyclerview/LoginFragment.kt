package com.raywenderlich.bootcamp.blockbusterrecyclerview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*




class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button.setOnClickListener {
            if (editTextUsername.text.length >= 3 && editTextPassword.text.length >= 4) {
                Log.d("LOGIN_FRAGMENT", "The username and password is valid")
            } else {
                showError()
            }
        }
    }

    private fun showError() {
        val snackbar = Snackbar.make(button, "Username or password incorrect. Please try again", Snackbar.LENGTH_LONG)
        snackbar.show()
    }
}