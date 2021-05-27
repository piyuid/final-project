package com.dicoding.ratingapp.home.populer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.ratingapp.R
import com.dicoding.ratingapp.home.HomeAdapter
import com.dicoding.ratingapp.model.dummy.HomeModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomePopulerFragment : Fragment(),HomePopulerAdapter.ItemAdapterCallback {

    private  var publiklist : ArrayList<HomeModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_populer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        var adapter = HomePopulerAdapter(publiklist, this)
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter
    }

    fun initDataDummy() {
        publiklist = ArrayList()
        publiklist.add(HomeModel("KelurahanA","",5f))
        publiklist.add(HomeModel("KelurahanB","",4f))
        publiklist.add(HomeModel("KelurahanC","",3.5f))}

    override fun onClick(v: View, data: HomeModel) {
        Toast.makeText(context, "percobaan klik"+ data.title, Toast.LENGTH_SHORT).show()
    }

}