package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.databinding.ActivitySoruEkleBinding
import com.frappeclub.sisecevirmece.util.extStatusBarColor

class SoruEkleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySoruEkleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_soru_ekle)

        this extStatusBarColor "#01A555"

        binding.btnSoruKaydet.setOnClickListener {

            // val girilenMetin = binding.textInputLayout.edxGirilenSoru.text

        }


    }
}
