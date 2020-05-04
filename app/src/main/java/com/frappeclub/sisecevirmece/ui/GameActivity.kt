package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.binding.SiseDondurme
import com.frappeclub.sisecevirmece.databinding.ActivityGameBinding
import com.frappeclub.sisecevirmece.util.extSayfaGecisi

class GameActivity : AppCompatActivity() {


    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game)

        val donmeBitinceYap = {
            this.extSayfaGecisi(DogrulukCesaretActivity::class.java)
        }

        binding.sise = SiseDondurme(donmeBitinceYap)

    }

    override fun onResume() {
        super.onResume()
        binding.bottleImg.isEnabled = true
    }


}


