package com.example.sortbox

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sortbox.sort.SortClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val titles = listOf("標的","成交價","漲跌","新高","均量")
    private var buttonList : MutableList<TextView> = mutableListOf()

    private val sortClick  = SortClickListener(buttonList, ::refreshUi)
    private var adapter : StockAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titles.forEachIndexed { index, it ->
            linearLayout.addView(setContentView(index, it))
        }
        
        init()
    }

    private fun refreshUi(){
        if (adapter == null){
            return
        }
        val newList = CenterData.instance.stockList.toList()
        adapter?.calculateItemChange(newList)
    }

    private fun init() {
        CenterData.instance.stockList.add(Stock("2506", 25.6, 0.0, "120+", 5899))
        CenterData.instance.stockList.add(Stock("9969", 130.5, 9.9, "-", 35669))
        CenterData.instance.stockList.add(Stock("9853", 65.4, 9.9, "-", 57))
        CenterData.instance.stockList.add(Stock("1255", 70.9, 9.5, "20+", 464))
        CenterData.instance.stockList.add(Stock("TW0023", 31.0, 6.5, "-", 33))
        CenterData.instance.stockList.add(Stock("956213", 50.3, 3.5, "20-", 54654))
        CenterData.instance.stockList.add(Stock("7522", 9.1, -5.6, "20-", 6546))
        CenterData.instance.stockList.add(Stock("5666", 4.5, -0.5, "-", 513))
        CenterData.instance.stockList.add(Stock("4489", 89.0, 0.0, "120-", 13))
        CenterData.instance.stockList.add(Stock("AC9959", 303.5, 2.5, "120+", 996))

        val initList = CenterData.instance.stockList.toList()
        adapter = StockAdapter(initList)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        recyclerview.adapter = adapter
    }

    private fun setContentView(id : Int, title : String) : RelativeLayout{
        val relativeLayout = RelativeLayout(this)
        relativeLayout.apply {
            this.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.colorPrimaryDark))
            this.gravity = Gravity.CENTER
            this.layoutParams = LinearLayout.LayoutParams(0, 150, 1f)
        }
        val textView = TextView(this)
        textView.apply {
            this.setTextColor(Color.WHITE)
            this.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.colorPrimaryDark))
            this.text = title
            this.gravity = Gravity.CENTER
            this.textSize = 16f
            this.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            this.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.mipmap.group_3,0)
            this.compoundDrawablePadding = 3
            this.id = id
            this.setOnClickListener(sortClick)
        }
        relativeLayout.addView(textView)
        buttonList.add(textView)
        return relativeLayout
    }
}
