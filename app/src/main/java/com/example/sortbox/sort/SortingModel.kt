package com.example.sortbox.sort

import com.example.sortbox.Stock
import java.util.*

class SortingModel(private val stocks: List<Stock>) {

    private val sortASC = MyComparator(MyComparator.Type.ASC.value)
    private val sortDESC = MyComparator(MyComparator.Type.DESC.value)

    enum class SortType(var value: Int) {
        ASC(1),
        DESC(0)
    }
    val sortMethods = listOf(::sortByCommKey,::sortByDealPrice, ::sortByQuoteChange,
        ::sortByNewHeights, ::sortByAvarageSort)

    private fun sortByCommKey(sortType: Int) {
        if (sortType == SortType.ASC.value) {
            Collections.sort(stocks, sortASC.commKeySort)
        } else {
            Collections.sort(stocks, sortDESC.commKeySort)
        }
    }

    private fun sortByDealPrice(sortType: Int) {
        if (sortType == SortType.ASC.value) {
            Collections.sort(stocks, sortASC.dealPriceSort)
        } else {
            Collections.sort(stocks, sortDESC.dealPriceSort)
        }
    }

    private fun sortByQuoteChange(sortType: Int) {
        if (sortType == SortType.ASC.value) {
            Collections.sort(stocks, sortASC.quoteChangeSort)
        } else {
            Collections.sort(stocks, sortDESC.quoteChangeSort)
        }
    }

    private fun sortByNewHeights(sortType: Int) {
        if (sortType == SortType.ASC.value) {
            Collections.sort(stocks, sortASC.newHeightsSort)
        } else {
            Collections.sort(stocks, sortDESC.newHeightsSort)
        }
    }

    private fun sortByAvarageSort(sortType: Int) {
        if (sortType == SortType.ASC.value) {
            Collections.sort(stocks, sortASC.avarageSort)
        } else {
            Collections.sort(stocks, sortDESC.avarageSort)
        }
    }
}