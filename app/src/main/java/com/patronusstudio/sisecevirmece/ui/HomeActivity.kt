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
import com.patronusstudio.sisecevirmece.enums.PlayStoreEnum
import com.patronusstudio.sisecevirmece.enums.SiseSecimiEnum
import com.patronusstudio.sisecevirmece.model.HomeButonModel
import com.patronusstudio.sisecevirmece.util.OyunIslemleri
import com.patronusstudio.sisecevirmece.util.extSayfaGecisi


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: HomeButtonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        val clickedButon = { position: Int ->
            when (position) {
                0 -> this.extSayfaGecisi(SiseDondurmeActivity::class.java)
                1 -> this.extSayfaGecisi(SorulariGoruntuleSecimEkrani::class.java)
                2 -> this.extSayfaGecisi(AyarlarActivity::class.java)
                3 -> this.extSayfaGecisi(FeedbackActivity::class.java)
                4 -> {
                    intent = Intent(Intent.ACTION_VIEW, Uri.parse(PlayStoreEnum.PAKET_ISMI.isim))
                    startActivity(intent)
                }
            }
        }

        val modelListe = ArrayList<HomeButonModel>()
        modelListe.add(
            HomeButonModel(
                getString(R.string.basla),
                getButonIcon(),
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
                Color.parseColor("#A60565B3")
            )
        )

        modelListe.add(
            HomeButonModel(
                getString(R.string.feedback),
                R.drawable.feedback,
                Color.parseColor("#95FF30CB")
            )
        )

        modelListe.add(
            HomeButonModel(
                getString(R.string.bizi_oyla),
                R.drawable.playstore,
                Color.parseColor("#A6039BE5")
            )
        )

        adapter = HomeButtonAdapter(modelListe, clickedButon)
        binding.activityHomeRecycler.adapter = adapter
        binding.activityHomeRecycler.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private fun getButonIcon(): Int {
        val resId = when (OyunIslemleri.siseTuru) {
            SiseSecimiEnum.Gazoz.getSiseId() -> SiseSecimiEnum.Gazoz.getSiseImage()
            SiseSecimiEnum.Kola.getSiseId() -> SiseSecimiEnum.Kola.getSiseImage()
            SiseSecimiEnum.Bira.getSiseId() -> SiseSecimiEnum.Bira.getSiseImage()
            SiseSecimiEnum.Sarap.getSiseId() -> SiseSecimiEnum.Sarap.getSiseImage()
            SiseSecimiEnum.EskiSarap.getSiseId() -> SiseSecimiEnum.EskiSarap.getSiseImage()
            SiseSecimiEnum.Sampanya.getSiseId() -> SiseSecimiEnum.Sampanya.getSiseImage()
            SiseSecimiEnum.Cayci.getSiseId() -> SiseSecimiEnum.Cayci.getSiseImage()
            else -> SiseSecimiEnum.Gazoz.getSiseImage()
        }
        return resId
    }

    override fun onResume() {
        super.onResume()
        val newButonId = getButonIcon()
        adapter.updateButonIcon(newButonId)
    }
}

