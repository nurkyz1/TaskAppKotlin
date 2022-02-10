package com.geektech.taskappkotlin.domain

class DeleteShopItemUseCase (private  val shopListRepository: ShopListRepository) {
    fun deleteShopItem(shopItem: ShopItem){
        shopListRepository.deleteShopItem(shopItem)
    }
}