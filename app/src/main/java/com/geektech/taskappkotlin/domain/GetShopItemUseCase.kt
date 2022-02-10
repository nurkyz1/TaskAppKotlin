package com.geektech.taskappkotlin.domain

class GetShopItemUseCase (private  val shopListRepository: ShopListRepository) {
    fun getShopItem(shopItemId: Int) = shopListRepository.getShopItem(shopItemId)
}