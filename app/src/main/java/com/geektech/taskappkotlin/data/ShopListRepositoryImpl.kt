package com.geektech.taskappkotlin.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.geektech.taskappkotlin.domain.ShopItem
import com.geektech.taskappkotlin.domain.ShopListRepository
import com.geektech.taskappkotlin.presentation.App

object ShopListRepositoryImpl:ShopListRepository {
    private val mapper = ShopListMapper()

    /*init {
        for (i in 0 until 100){
            val item = ShopItem ("Name $i", i, false, i)
            addShopItem(item)
        }
    }*/

    override fun addShopItem(shopItem: ShopItem) {
        App.appDatabase.shopItemDao().insertShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        App.appDatabase.shopItemDao().deleteShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override fun getShopItemList(): LiveData<List<ShopItem>> = Transformations.map(
        App.appDatabase.shopItemDao().getShopList()
    ){
        mapper.mapListDBToListEntity(it)
    }

    override fun editShopItem(shopItem: ShopItem) {
        App.appDatabase.shopItemDao().editShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return mapper.mapDBModelToEntity(App.appDatabase.shopItemDao().getShopItem(shopItemId))
    }
}