package com.geektech.taskappkotlin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.taskappkotlin.R
import com.geektech.taskappkotlin.databinding.ActivityAddShopBinding
import com.geektech.taskappkotlin.domain.ShopItem
import com.geektech.taskappkotlin.presentation.main.MainViewModel

class AddShopActivity : AppCompatActivity() {

    private val binding: ActivityAddShopBinding by viewBinding()
    private  val viewModel:MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_shop)
        initListeners()
    }
    private fun initListeners() {
        binding.addBtn.setOnClickListener{
            addShopItem()
        }
    }

    private fun addShopItem() {
        if (!(!binding.nameShopEt.text!!.isNotEmpty() ||
                    !binding.countShopEt.text!!.isNotEmpty()
                    || !binding.idShopEt.text!!.isNotEmpty())){

            viewModel.addShopItem(
                ShopItem(
                binding.nameShopEt.text.toString(),
                Integer.parseInt(binding.countShopEt.text.toString()),
                false,
                Integer.parseInt(binding.idShopEt.text.toString()))
            )
            finish()
        }
    }

}