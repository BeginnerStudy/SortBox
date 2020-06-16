package com.example.sortbox

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class StockAdapter(list: List<Stock>) : RecyclerView.Adapter<StockAdapter.MyViewHolder>() {

    private var stockList: MutableList<Stock> = list.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return MyViewHolder(inflater.inflate(R.layout.stock_item, parent ,false))
    }

    override fun getItemCount(): Int {
        return stockList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val stock = stockList[position]
        holder.onBind(stock,position)
    }

    fun calculateItemChange(stockListBySort : List<Stock>){
        val updateDiffResult = DiffUtil.calculateDiff(MyDiffUtilCallBack(stockList, stockListBySort))
        updateDiffResult.dispatchUpdatesTo(this)

        this.stockList = stockListBySort.toMutableList()
    }

    class MyViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {
        private val t1 : TextView = view.findViewById(R.id.t1)
        private val t2 : TextView = view.findViewById(R.id.t2)
        private val t3 : TextView = view.findViewById(R.id.t3)
        private val t4 : TextView = view.findViewById(R.id.t4)
        private val t5 : TextView = view.findViewById(R.id.t5)
        private val itemBackground : LinearLayout = view.findViewById(R.id.itemBackground)

        fun onBind(stock: Stock, position: Int) {
            setBackgroundColorBaseOnPosition(position)
            t1.text = stock.commonKey
            t2.text = stock.dealPrice.toString()
            t3.text = stock.quoteChange.toString()
            t4.text = stock.newHeights
            t5.text = stock.avarage.toString()
        }

        private fun setBackgroundColorBaseOnPosition(position: Int) {
            if (position % 2 == 0) {
                itemBackground.setBackgroundColor(ContextCompat.getColor(view.context, R.color.JJA_Row1Color))
            } else {
                itemBackground.setBackgroundColor(ContextCompat.getColor(view.context, R.color.JJA_Row2Color))
            }
        }
    }
}


