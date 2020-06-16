package com.example.sortbox.sort

import android.view.View
import android.widget.TextView
import com.example.sortbox.CenterData
import com.example.sortbox.R

class SortClickListener (private val buttonArray : List<TextView>, private val refreshUiFun: (() -> Unit)) : View.OnClickListener{

    private var currentButton: Int = 0
    private var sortType: Int = 0
    private val model = SortingModel(CenterData.instance.stockList)
    private var sortMethods = model.sortMethods

    override fun onClick(view: View?) {
        if (view == null){
            return
        }
        sortType = if (view.id == currentButton) {
            ++sortType % 2
        } else {
            1
        }
        currentButton = view.id
        buttonArray.forEach {
            it.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.group_3, 0)
        }
        when (sortType){
            SortingModel.SortType.ASC.value -> {
                (view as TextView).setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.mipmap.group_5,0)
            }
            SortingModel.SortType.DESC.value -> {
                (view as TextView).setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.mipmap.group_6,0)
            }
        }
        sortMethods[view.id].invoke(sortType)
        refreshUiFun.invoke()
    }
}