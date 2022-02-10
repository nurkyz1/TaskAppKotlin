package com.geektech.taskappkotlin.domain

import java.io.Serializable

data class ShopItem (
    var name: String,
    val count: Int,
    var enabled: Boolean,
    var id: Int

    ) : Serializable {
    companion object {
        const val UNDEFINED_ID = -1
    }
}