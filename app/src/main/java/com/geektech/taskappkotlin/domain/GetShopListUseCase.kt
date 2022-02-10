package com.geektech.taskappkotlin.domain

class GetShopListUseCase (private val shopListRepository: ShopListRepository){
    fun getShopItemList() = shopListRepository.getShopItemList()
}