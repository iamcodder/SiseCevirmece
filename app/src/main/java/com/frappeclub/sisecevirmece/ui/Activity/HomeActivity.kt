package com.frappeclub.sisecevirmece.ui.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frappeclub.sisecevirmece.R
import com.frappeclub.sisecevirmece.util.extSayfaGecisi
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        imgBeer.setOnClickListener {
            this extSayfaGecisi GameActivity::class.java
        }
    }
}
