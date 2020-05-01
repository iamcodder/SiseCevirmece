package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frappeclub.sisecevirmece.databinding.ActivityHomeBinding
import com.frappeclub.sisecevirmece.mock.Questions
import com.frappeclub.sisecevirmece.util.extSayfaGecisi

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Questions.listeEkleDogruluk()
        Questions.listeEkleCesaret()

        binding.imgBeer.setOnClickListener {
            this.extSayfaGecisi(GameActivity::class.java)
        }
    }
}
