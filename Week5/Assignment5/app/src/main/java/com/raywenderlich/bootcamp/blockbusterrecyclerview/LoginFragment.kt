package com.raywenderlich.bootcamp.blockbusterrecyclerview

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    public  interface  LoginFragmentListener {
        fun hasLoggedIn(value: Boolean)
    }

    private lateinit var listener: LoginFragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is LoginFragmentListener) {
            listener = context as LoginFragmentListener
        } else {
            throw ClassCastException("$context must implement LoginFragmentListener")
        }
    }

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
                listener.hasLoggedIn(true)
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