package com.geektech.taskappkotlin.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.taskappkotlin.R
import com.geektech.taskappkotlin.domain.ShopItem
import com.geektech.taskappkotlin.presentation.ShopItemDiffCallback
import java.lang.RuntimeException

class ShopItemListAdapter : ListAdapter<ShopItem, ShopItemListAdapter.ShopItemViewHolder>(
    ShopItemDiffCallback()
) {

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when (viewType){
            LAYOUT_ITEM_ENABLED -> R.layout.item_shop_disabled
            LAYOUT_ITEM_DISABLED -> R.layout.item_shop_enabled
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        return ShopItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layout,
                parent,
                false
            ))
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        holder.onBind(getItem(holder.absoluteAdapterPosition))
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).enabled){
            LAYOUT_ITEM_ENABLED
        } else LAYOUT_ITEM_DISABLED
    }

    inner class ShopItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvCount: TextView = itemView.findViewById(R.id.tv_count)

        fun onBind(shopItem: ShopItem){
            itemView.setOnLongClickListener{
                onShopItemLongClickListener?.invoke(shopItem)
                true
            }
            itemView.setOnClickListener{
                onShopItemClickListener?.invoke(shopItem)
            }
            tvName.text = shopItem.name
            tvCount.text = shopItem.count.toString()
        }
    }

    companion object{
        const val LAYOUT_ITEM_ENABLED = 1
        const val LAYOUT_ITEM_DISABLED = 0
    }
}