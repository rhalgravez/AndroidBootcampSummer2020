package com.raywenderlich.bootcamp.blockbusterrecyclerview

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), LoginFragment.LoginFragmentListener, MainFragment.MainFragmentListener {

    companion object {
        private const val LOGGED_IN_KEY = "SHARED_PREFS_LOGGED_IN"
        private const val SHARED_PREFS_REPOSITORY = "SHARED_PREFS_REPOSITORY"
    }

    private val mainFragment = MainFragment()
    private val loginFragment = LoginFragment()
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logInValue = getLogIn()
        showFragment(logInValue)
    }

    override fun hasLoggedIn() {
        showFragment(true)
    }

    override fun hasLoggedOut() {
        showFragment(false)
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
        saveLogIn(value)
        fragmentTransaction.commit()
    }

    private fun sharedPrefs() = getSharedPreferences(SHARED_PREFS_REPOSITORY, Context.MODE_PRIVATE)

    private fun saveLogIn(value: Boolean) {
        val editor = sharedPrefs().edit()
        editor.putBoolean(LOGGED_IN_KEY, value).apply()
    }

    private fun getLogIn(): Boolean = sharedPrefs().getBoolean(LOGGED_IN_KEY, false)

}