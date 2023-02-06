package com.example.learnkotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.learnkotlin.model.Tab


class MainActivity : AppCompatActivity() {
    var num = 0
    private lateinit var textView : TextView
    var tabsPosition = 0
    companion object{
        var tabsList: ArrayList<Tab> = ArrayList()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<TextView>(R.id.textView)
        textView.text = "Hello Text"

        val layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val myList = findViewById<RecyclerView>(R.id.tabsView) as RecyclerView
        myList.layoutManager = layoutManager

//        tabsList.add(Tab("Home", ))
    }

    private inner class TabsAdapter(fa: FragmentManager, lc: Lifecycle) : FragmentStateAdapter(fa, lc) {
        override fun getItemCount(): Int = tabsList.size
        override fun createFragment(positoin: Int): Fragment = tabsList[tabsPosition].fragment
    }

    fun changeTab(url: String, fragment: Fragment){
        MainActivity.tabsList.add(Tab(name = url, fragment = fragment))

    }
}