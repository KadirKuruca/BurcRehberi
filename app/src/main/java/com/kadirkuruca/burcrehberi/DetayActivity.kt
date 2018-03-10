package com.kadirkuruca.burcrehberi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detay.*
import android.support.v7.graphics.Palette
import com.kadirkuruca.burcrehberi.R.id.header
import android.graphics.BitmapFactory
import android.graphics.Bitmap



class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var position = intent.extras.get("position") as Int
        var tumBurcBilgileri = intent.extras.get("burcBilgileri") as ArrayList<Burc>

        tvBurcOzellikleri.setText(tumBurcBilgileri.get(position).burcGenelOzellik)
        header.setImageResource(tumBurcBilgileri.get(position).burcBuyukResim)

        setSupportActionBar(anim_toolbar) //Anim toolbarı seçiyoruz.
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true) // Geri butonunu ekliyoruz.
        collapsing_toolbar.title = tumBurcBilgileri.get(position).burcAdi

        val bitmap = BitmapFactory.decodeResource(resources,
                tumBurcBilgileri.get(position).burcBuyukResim)
        Palette.from(bitmap).generate { palette ->
            var mutedColor = palette.getMutedColor(R.attr.colorPrimary)
            collapsing_toolbar.setContentScrimColor(mutedColor)

            window.statusBarColor = mutedColor
        }

    }

    //Geri Butonuna işlev veriyoruz.
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
