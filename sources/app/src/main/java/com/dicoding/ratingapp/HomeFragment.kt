package com.dicoding.ratingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.ratingapp.home.HomeAdapter
import com.dicoding.ratingapp.model.dummy.HomeModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private var publiklist : ArrayList<HomeModel> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        var adapter = HomeAdapter(publiklist,this)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter
    }

    fun initDataDummy() {
        publiklist = ArrayList()
        publiklist.add(HomeModel("Cherry Healthy","",5f))
        publiklist.add(HomeModel("Burger Tamayo","",4f))
        publiklist.add(HomeModel("Bakhwan Cihuy","",4.5f))}
}