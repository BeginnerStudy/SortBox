package com.example.sortbox

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtilCallBack(var stockList: MutableList<Stock>, var stockListBySort: List<Stock>) :
    DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldStock = stockList[oldItemPosition]
        val newStock = stockListBySort[newItemPosition]
        return oldStock == newStock
    }

    override fun getOldListSize(): Int {
        return stockList.size
    }

    override fun getNewListSize(): Int {
        return stockListBySort.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldStock = stockList[oldItemPosition]
        val newStock = stockListBySort[newItemPosition]
        return oldStock == newStock
    }

}
