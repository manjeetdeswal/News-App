package com.mddstudio.kotlin

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.littlemango.stacklayoutmanager.StackLayoutManager
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var adapter: Myadapter
    private var artilcleList = mutableListOf<Article>()

    var pagenumber = 1
    var totalresult = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var container = findViewById<LinearLayout>(R.id.container)
        var newsList = findViewById<RecyclerView>(R.id.newsList)
        val manager = StackLayoutManager(StackLayoutManager.ScrollOrientation.BOTTOM_TO_TOP)
        manager.setPagerMode(true)
        manager.setPagerFlingVelocity(3000)
        manager.setItemChangedListener(object : StackLayoutManager.ItemChangedListener {
            override fun onItemChanged(position: Int) {
                container.setBackgroundColor(Color.parseColor(ColorPick.getColor()))
                Log.d("msg","First visibel item${manager.getFirstVisibleItemPosition()}")
                Log.d("msg","Total  item${manager.itemCount}")
                if (totalresult > manager.itemCount && manager.getFirstVisibleItemPosition() >= manager.itemCount - 5) {
                    pagenumber++
                    getnews()
                }
            }

        })

        adapter = Myadapter(this@MainActivity, artilcleList)
        newsList.adapter = adapter
        newsList.layoutManager = manager

        getnews()

    }

    private fun getnews() {
        val news = NewsSevice.newsindstance.getheadline("in", pagenumber)
        news.enqueue(object : retrofit2.Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {
                    totalresult = news.totalResults
                    artilcleList.addAll(news.articles)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {

                Log.d("fsv", "1st")
            }
        })
    }
}


