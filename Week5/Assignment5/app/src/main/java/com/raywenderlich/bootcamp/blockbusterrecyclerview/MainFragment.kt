package com.raywenderlich.bootcamp.blockbusterrecyclerview

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.raywenderlich.bootcamp.blockbusterrecyclerview.model.MoviesDataSource
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    public  interface  MainFragmentListener {
        fun hasLoggedOut()
    }

    private lateinit var listener: MainFragmentListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is LoginFragment.LoginFragmentListener) {
            listener = context as MainFragment.MainFragmentListener
        } else {
            throw ClassCastException("$context must implement MainFragmentListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler_view.layoutManager = GridLayoutManager(activity, 2)
        recycler_view.adapter = MoviesListAdapter(MoviesDataSource.getMoviesList())

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.log_out) {
            listener.hasLoggedOut()
        }
        return true

    }

}