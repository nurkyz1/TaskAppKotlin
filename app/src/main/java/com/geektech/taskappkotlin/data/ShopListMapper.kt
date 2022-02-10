package com.geektech.taskappkotlin.data

import com.geektech.taskappkotlin.domain.ShopItem

class ShopListMapper {
    fun mapEntityToDBModel(shopItem: ShopItem) = ShopItemDBModel(
        id = shopItem.id,
        name = shopItem.name,
        enabled = shopItem.enabled,
        count = shopItem.count
    )

    fun mapDBModelToEntity(shopItemDB: ShopItemDBModel) = ShopItem(
        id = shopItemDB.id,
        name = shopItemDB.name,
        enabled = shopItemDB.enabled,
        count = shopItemDB.count
    )

    fun mapListDBToListEntity(list: List<ShopItemDBModel>) = list.map {
        mapDBModelToEntity(it)
    }
}