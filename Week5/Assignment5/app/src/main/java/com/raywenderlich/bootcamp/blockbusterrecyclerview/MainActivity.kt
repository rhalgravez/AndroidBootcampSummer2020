package com.raywenderlich.bootcamp.blockbusterrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.raywenderlich.bootcamp.blockbusterrecyclerview.model.MoviesDataSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginFragment.LoginFragmentListener {

    private var loggedIn = false

    private val mainFragment = MainFragment()
    private val loginFragment = LoginFragment()
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment(loggedIn)
    }

    override fun hasLoggedIn(value: Boolean) {
        loggedIn = value
        showFragment(loggedIn)
    }

    private fun showFragment(value: Boolean) {
        val fragmentTransaction = fragmentManager.beginTransaction()

        if (value == true) {
            fragmentTransaction.remove(loginFragment)
            fragmentTransaction.replace(R.id.fragment_container, mainFragment)
        } else {
            fragmentTransaction.remove(mainFragment)
            fragmentTransaction.replace(R.id.fragment_container, loginFragment)
        }

        fragmentTransaction.commit()
    }
}