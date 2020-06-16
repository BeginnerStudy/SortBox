package com.example.sortbox

class CenterData {

    companion object{
        /**
         * 為一個體 (模擬某個資料中心)
         */
        val instance: CenterData by lazy { CenterData() }
    }

    val stockList = mutableListOf<Stock>()
}