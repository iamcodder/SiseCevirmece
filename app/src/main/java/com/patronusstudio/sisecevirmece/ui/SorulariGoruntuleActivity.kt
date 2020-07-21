package com.patronusstudio.sisecevirmece.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.florent37.viewtooltip.ViewTooltip
import com.patronusstudio.sisecevirmece.R
import com.patronusstudio.sisecevirmece.abstracts.CesaretDatabase
import com.patronusstudio.sisecevirmece.abstracts.DogrulukDatabase
import com.patronusstudio.sisecevirmece.adapter.SorularAdapter
import com.patronusstudio.sisecevirmece.binding.SorulariGoruntuleOnClickBinding
import com.patronusstudio.sisecevirmece.databinding.ActivitySorulariGoruntuleBinding
import com.patronusstudio.sisecevirmece.enums.DogrulukCesaretEnum
import com.patronusstudio.sisecevirmece.model.CesaretModel
import com.patronusstudio.sisecevirmece.model.DogrulukModel
import com.patronusstudio.sisecevirmece.util.OyunIslemleri
import com.patronusstudio.sisecevirmece.util.SharedVeriSaklama
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import jp.wasabeef.recyclerview.animators.FlipInBottomXAnimator


class SorulariGoruntuleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySorulariGoruntuleBinding
    private var dogrulukListesi: List<DogrulukModel> = listOf()
    private var cesaretListesi: List<CesaretModel> = listOf()
    private lateinit var mAdapter: SorularAdapter
    private var getBooleanIntent = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sorulari_goruntule)

        getBooleanIntent = intent.getBooleanExtra(DogrulukCesaretEnum.DOGRULUK_CESARET.isim, false)

        if (getBooleanIntent)
            dogrulukListesi = DogrulukDatabase.getDatabaseManager(this).dogrulukDao().getAllModel()
        else cesaretListesi = CesaretDatabase.getDatabaseManager(this).cesaretDao().getAllModel()

        val longClick = { position: Int ->

            val model = if (getBooleanIntent) dogrulukListesi[position]
            else cesaretListesi[position]

            val gecis = Intent(applicationContext, SoruDuzenleActivitiy::class.java)
            gecis.putExtra(DogrulukCesaretEnum.DOGRULUK_CESARET.isim, getBooleanIntent)
            gecis.putExtra(DogrulukCesaretEnum.SORU_MODELI.isim, model)
            gecis.putExtra(DogrulukCesaretEnum.SORUNUN_INDEXI.isim, position)
            startActivity(gecis)

        }

        mAdapter =
            SorularAdapter(dogrulukListesi, cesaretListesi, getBooleanIntent, longClick)

        binding.dogrulukMu = getBooleanIntent
        binding.dogrulukListesi = dogrulukListesi
        binding.cesaretListesi = cesaretListesi
        binding.onClickBinding = SorulariGoruntuleOnClickBinding(this)
        binding.sorularRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        toolTip()
        binding.sorularRecycler.adapter = ScaleInAnimationAdapter(mAdapter)
        binding.sorularRecycler.itemAnimator = FlipInBottomXAnimator()

    }

    private fun toolTip() {

        val sharedPref = SharedVeriSaklama(this)
        val tooltipGosterildiMi = sharedPref.getToolTip()

        if (!tooltipGosterildiMi) {
            ViewTooltip
                .on(this, binding.sorularRecycler)
                .autoHide(true, 10000)
                .corner(30)
                .position(ViewTooltip.Position.BOTTOM)
                .text(R.string.silmek_icin_uzun_bas)
                .textColor(Color.BLACK)
                .color(Color.GREEN)
                .clickToHide(true)
                .textSize(1, 16f)
                .arrowWidth(16)
                .arrowHeight(16)
                .show()
            sharedPref.updateToolTip(true)
        }


    }

    override fun onResume() {
        super.onResume()
        if (OyunIslemleri.soruSilindiMi) {
            mAdapter.deleteData()
            OyunIslemleri.soruSilindiMi = false
            OyunIslemleri.degisenSoruIndexi = 0
        } else if (OyunIslemleri.soruGuncellendiMi) {
            mAdapter.updateData()
            OyunIslemleri.soruGuncellendiMi = false
            OyunIslemleri.degisenSoruIndexi = 0
            OyunIslemleri.guncellenenSoru = ""
        } else if (OyunIslemleri.soruEklendiMi) {
            mAdapter.addData()
            OyunIslemleri.guncellenenSoru = ""
            OyunIslemleri.soruEklendiMi = false
            if (getBooleanIntent) binding.sorularRecycler.smoothScrollToPosition(OyunIslemleri.dogrulukSize - 1)
            else binding.sorularRecycler.smoothScrollToPosition(OyunIslemleri.cesaretSize - 1)
        }
    }

}