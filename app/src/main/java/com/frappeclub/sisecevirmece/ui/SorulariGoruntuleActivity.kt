package com.frappeclub.sisecevirmece.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.abstracts.DogrulukDatabase
import com.frappeclub.sisecevirmece.adapter.SorularAdapter
import com.frappeclub.sisecevirmece.databinding.ActivitySorulariGoruntuleBinding
import com.frappeclub.sisecevirmece.util.extLogMessage

class SorulariGoruntuleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySorulariGoruntuleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sorulari_goruntule)

        //TODO: Gelen kategori seçimine göre liste alınıp setlenecek.
        val dogrulukDatabase = DogrulukDatabase.getDatabaseManager(this)
        val list = dogrulukDatabase.dogrulukDao().getAllModel()

        //TODO: Liste elemanı passlanacak
        val longClick = { position: Int ->
            "SÜLEYMAN" extLogMessage "" + position
        }

        binding.sorularRecycler.adapter = SorularAdapter(list, true, longClick)
        binding.sorularRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
