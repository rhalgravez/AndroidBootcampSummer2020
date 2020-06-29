package com.raywenderlich.bootcamp.blockbusterrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.raywenderlich.bootcamp.blockbusterrecyclerview.model.MoviesDataSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = MainFragment()
        val loginFragment = LoginFragment()
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.fragment_container, loginFragment).commit()
    }
}