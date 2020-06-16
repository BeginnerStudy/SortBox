package com.example.sortbox.sort

import com.example.sortbox.Stock

class MyComparator(var sortType: Int) {

    enum class Type(var value: Int) {
        ASC(1),
        DESC(-1)
    }

    /**
     * 股票代號
     */
    val commKeySort: Comparator<Stock> = Comparator { o1, o2 ->
        when {
            o1.commonKey == null && o2.commonKey == null -> {
                return@Comparator 0
            }
            o1.commonKey == null -> {
                return@Comparator 1
            }
            o2.commonKey == null -> {
                return@Comparator -1
            }
            o1.commonKey == "" && o2.commonKey == "" -> {
                return@Comparator 0
            }
            o1.commonKey == "" -> {
                return@Comparator 1
            }
            o2.commonKey == "" -> {
                return@Comparator -1
            }
            else -> {
                return@Comparator (o2.commonKey ?: "").compareTo(o1.commonKey ?: "") * sortType
            }
        }
    }
    val dealPriceSort: Comparator<Stock> = Comparator { o1, o2 ->
        when {
            o1.dealPrice == null && o2.dealPrice == null -> {
                return@Comparator 0
            }
            o1.dealPrice == null -> {
                return@Comparator 1
            }
            o2.dealPrice == null -> {
                return@Comparator -1
            }
            o1.dealPrice == 0.0 && o2.dealPrice == 0.0 -> {
                return@Comparator 0
            }
            o1.dealPrice == 0.0 -> {
                return@Comparator 1
            }
            o2.dealPrice == 0.0 -> {
                return@Comparator -1
            }
            else -> {
                return@Comparator (o2.dealPrice ?: 0.0).compareTo(o1.dealPrice ?: 0.0) * sortType
            }
        }
    }

    val quoteChangeSort: Comparator<Stock> = Comparator { o1, o2 ->
        when {
            o1.quoteChange == null && o2.quoteChange == null -> {
                return@Comparator 0
            }
            o1.quoteChange == null -> {
                return@Comparator 1
            }
            o2.quoteChange == null -> {
                return@Comparator -1
            }
            o1.quoteChange == 0.0 && o2.quoteChange == 0.0 -> {
                return@Comparator 0
            }
            o1.quoteChange == 0.0 -> {
                return@Comparator 1
            }
            o2.quoteChange == 0.0 -> {
                return@Comparator -1
            }
            else -> {
                return@Comparator (o2.quoteChange ?: 0.0).compareTo(o1.quoteChange ?: 0.0) * sortType
            }
        }
    }

    val newHeightsSort: Comparator<Stock> = Comparator { o1, o2 ->
        var int1 = 0
        var int2 = 0
        if ((o1.newHeights?.length ?: 0) > 1 && o1.newHeights?.last().toString() == "-") {
            int1 = (o1.newHeights ?: return@Comparator 1).removeRange((o1.newHeights?.length ?:1) - 1, (o1.newHeights?.length ?: 1)).toInt() * -1
        } else if (o1.newHeights?.last().toString() == "+") {
            int1 = (o1.newHeights ?: return@Comparator 1).removeRange((o1.newHeights?.length ?:1) - 1, (o1.newHeights?.length ?: 1)).toInt()
        }

        if ((o2.newHeights?.length ?: 0) > 1 && o2.newHeights?.last().toString() == "-") {
            int2 = (o2.newHeights ?: return@Comparator 1).removeRange((o2.newHeights?.length ?:1) - 1, (o2.newHeights?.length ?: 1)).toInt() * -1
        } else if (o2.newHeights?.last().toString() == "+") {
            int2 = (o2.newHeights ?: return@Comparator 1).removeRange((o2.newHeights?.length ?:1) - 1, (o2.newHeights?.length ?: 1)).toInt()
        }
        when {
            o1.newHeights == null && o2.newHeights == null -> {
                return@Comparator 0
            }
            o1.newHeights == null -> {
                return@Comparator 1
            }
            o2.newHeights == null -> {
                return@Comparator -1
            }
            int1 == 0 && int2 == 0 -> {
                return@Comparator 0
            }
            int1 == 0 -> {
                return@Comparator 1
            }
            int2 == 0 -> {
                return@Comparator -1
            }
            else -> {
                return@Comparator int2.compareTo(int1) * sortType
            }
        }
    }

    val avarageSort: Comparator<Stock> = Comparator { o1, o2 ->
        when {
            o1.avarage == null && o2.avarage == null -> {
                return@Comparator 0
            }
            o1.avarage == null -> {
                return@Comparator 1
            }
            o2.avarage == null -> {
                return@Comparator -1
            }
            o1.avarage == 0 && o2.avarage == 0 -> {
                return@Comparator 0
            }
            o1.avarage == 0 -> {
                return@Comparator 1
            }
            o2.avarage == 0 -> {
                return@Comparator -1
            }
            else -> {
                return@Comparator (o2.avarage ?: 0).compareTo(o1.avarage ?: 0) * sortType
            }
        }
    }

}