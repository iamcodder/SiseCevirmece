package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.binding.Bottle
import com.frappeclub.sisecevirmece.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {


    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game)

        binding.bottle = Bottle(this)

    }

    override fun onResume() {
        super.onResume()
        binding.bottleImg.isEnabled = true
    }


}


