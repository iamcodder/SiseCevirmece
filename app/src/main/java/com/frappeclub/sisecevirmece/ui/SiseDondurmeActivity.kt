package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.binding.SiseDondurme
import com.frappeclub.sisecevirmece.databinding.ActivitySiseDondurmeBinding
import com.frappeclub.sisecevirmece.interfaces.TimerCallBack
import com.frappeclub.sisecevirmece.util.CustomTimer
import com.frappeclub.sisecevirmece.util.extSayfaGecisi

class SiseDondurmeActivity : AppCompatActivity(), TimerCallBack {


    private lateinit var binding: ActivitySiseDondurmeBinding
    private lateinit var customTimer: CustomTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sise_dondurme)
        customTimer = CustomTimer()
        binding.sise = SiseDondurme()
        binding.customTimer = customTimer

    }

    override fun onResume() {
        super.onResume()
        binding.bottleImg.isEnabled = true
    }

    override fun onFinishTimer() {
        customTimer.sayacDurdur()
        this.extSayfaGecisi(SecimEkraniActivity::class.java)
    }


}


