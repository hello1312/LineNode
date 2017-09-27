package com.example.lee.linenode

import android.annotation.SuppressLint
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_line_node.view.*

class MainActivity : AppCompatActivity() {
    private var list = arrayListOf<StepBean>()
    private var lineNodeAdapter: LineNodeAdapter<StepBean>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        getData()
        //创建一个继承于抽象类(LineNodeAdapter)的实例
        lineNodeAdapter = object : LineNodeAdapter<StepBean>(this, list) {
            override fun convert(viewHolder: LineNodeViewHolder, t: StepBean) {
                viewHolder.itemView.title_txt.text = t.title
                viewHolder.itemView.time_txt.text = t.time
                viewHolder.itemView.num_txt.text = t.num.toString()
                if (t.num == 1) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        viewHolder.itemView.left_view.background = null
                    }
                }
                if (t.num == 4) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        viewHolder.itemView.right_view.background = null
                    }
                }
                if (t.num < 3) viewHolder.itemView.num_txt.setBackgroundResource(R.drawable.shap_line_number_circle_red)
            }

        }
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        //使用来自主代码集的 R.layout.activity_main,而不是 findViewById(R.id.ln_recycler_view) as Recyclerview
        ln_recycler_view.layoutManager = linearLayoutManager
        ln_recycler_view.adapter = lineNodeAdapter
    }

    private fun getData() {
        for (i in 1..4) {
            list.add(StepBean(i, "2017-9-27\n17:1$i", "步骤$i"))
        }


    }
}
