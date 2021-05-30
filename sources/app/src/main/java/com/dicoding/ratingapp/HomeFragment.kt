package com.dicoding.ratingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.ratingapp.home.HomeAdapter
import com.dicoding.ratingapp.home.SectionPagerAdapter
import com.dicoding.ratingapp.model.dummy.HomeModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(),HomeAdapter.ItemAdapterCallback {

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
        val adapter = HomeAdapter(publiklist,this)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter

        val sectionPagerAdapter = SectionPagerAdapter (
            childFragmentManager
        )
        viewPager.adapter = sectionPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    fun initDataDummy() {
        publiklist = ArrayList()
        publiklist.add(HomeModel("KelurahanA","",5f))
        publiklist.add(HomeModel("KelurahanB","",4f))
        publiklist.add(HomeModel("KelurahanC","",3.5f))}

    override fun onClick(v: View, data: HomeModel) {
        TODO("Not yet implemented")
    }
}