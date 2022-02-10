package com.geektech.taskappkotlin.presentation.main

import androidx.lifecycle.ViewModel
import com.geektech.taskappkotlin.data.ShopListRepositoryImpl
import com.geektech.taskappkotlin.domain.*

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl
    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val getShopItemListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val getShopItemUseCase = GetShopItemUseCase(repository)
    val shopList = getShopItemListUseCase.getShopItemList()

    fun addShopItem(shopItem: ShopItem){
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem){
        editShopItemUseCase.editShopItem(shopItem.copy(enabled =!shopItem.enabled))
    }

    fun getShopItem(shopItemId: Int): ShopItem{
        return getShopItemUseCase.getShopItem(shopItemId)
    }
}