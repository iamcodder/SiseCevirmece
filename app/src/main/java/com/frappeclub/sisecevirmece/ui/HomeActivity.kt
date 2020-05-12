package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.databinding.ActivityHomeBinding
import com.frappeclub.sisecevirmece.mock.Questions
import com.frappeclub.sisecevirmece.util.extSayfaGecisi

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val TAG = this.javaClass.simpleName

//    private lateinit var model: SorularDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        Questions.listeEkleDogruluk()
        Questions.listeEkleCesaret()

//        model = Room.databaseBuilder(
//            applicationContext,
//            SorularDatabase::class.java,
//            "Sorular.db"
//        )
//            .allowMainThreadQueries()
//            .build()
//        model.dogrulukDao().insert(DogrulukModel(soru = "123", sorulduMu = false))



        binding.imgBeer.setOnClickListener {
            this.extSayfaGecisi(SiseDondurmeActivity::class.java)
        }

        binding.imgSoru.setOnClickListener {
        }
        binding.imgAyarlar.setOnClickListener {
        }
        binding.imgStore.setOnClickListener {
        }

    }

}
