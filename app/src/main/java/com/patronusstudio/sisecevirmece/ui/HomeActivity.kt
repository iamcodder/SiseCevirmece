package com.patronusstudio.sisecevirmece.ui

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.adapter.HomeButtonAdapter
import com.patronusstudio.sisecevirmece.databinding.ActivityHomeBinding
import com.patronusstudio.sisecevirmece.enums.PlayStore
import com.patronusstudio.sisecevirmece.model.HomeButonModel
import com.patronusstudio.sisecevirmece.util.extSayfaGecisi


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

//        this extStatusBarColor "#000000ff"


        val clickedButon = { position: Int ->
            when (position) {
                0 -> this.extSayfaGecisi(SiseDondurmeActivity::class.java)
                1 -> this.extSayfaGecisi(SorulariGoruntuleSecimEkrani::class.java)
                2 -> this.extSayfaGecisi(AyarlarActivity::class.java)
                3 -> {
                    intent = Intent(Intent.ACTION_VIEW, Uri.parse(PlayStore.PAKET_ISMI.isim))
                    startActivity(intent)
                }
            }
        }

        val modelListe = ArrayList<HomeButonModel>()
        modelListe.add(
            HomeButonModel(
                getString(R.string.basla),
                R.drawable.beer,
                Color.parseColor("#A67CB342")
            )
        )
        modelListe.add(
            HomeButonModel(
                getString(R.string.sorular),
                R.drawable.answer,
                Color.parseColor("#A6D81B60")
            )
        )
        modelListe.add(
            HomeButonModel(
                getString(R.string.ayarlar),
                R.drawable.settings,
                Color.parseColor("#A6FB8C00")
            )
        )
        modelListe.add(
            HomeButonModel(
                getString(R.string.bizi_oyla),
                R.drawable.playstore,
                Color.parseColor("#A6039BE5")
            )
        )

        val adapter = HomeButtonAdapter(modelListe, clickedButon)
        binding.activityHomeRecycler.adapter = adapter
        binding.activityHomeRecycler.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

}
