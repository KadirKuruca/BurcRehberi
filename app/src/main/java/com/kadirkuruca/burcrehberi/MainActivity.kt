package com.kadirkuruca.burcrehberi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var tumBurcBilgileri:ArrayList<Burc>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = resources.getColor(R.color.statusBar)

        veriKaynagiHazirla()

        /*var myAdapter = BurclarArrayAdapter(this,R.layout.teksatir_layout,R.id.tvBurcAdi,burclar,burcTarihleri,burcResimleri)
        listBurclar.adapter = myAdapter*/ // Custom ArrayAdapter ile yapılan örnek.

        var myBaseAdapter = BurclarBaseAdapter(this,tumBurcBilgileri)
        listBurclar.adapter = myBaseAdapter

        listBurclar.setOnItemClickListener { parent, view, position, id ->

            var intent = Intent(this@MainActivity,DetayActivity::class.java)
            intent.putExtra("position",position)
            intent.putExtra("burcBilgileri",tumBurcBilgileri)
            startActivity(intent)
        }

    }

    private fun veriKaynagiHazirla() {
        tumBurcBilgileri = ArrayList<Burc>(12)

        var burcAdlari = resources.getStringArray(R.array.burclar)
        var burcTarihleri = resources.getStringArray(R.array.burcTarih)
        var burcResimleri = arrayOf(R.drawable.akrep1,R.drawable.aslan2,R.drawable.balik3,R.drawable.basak4,R.drawable.boga5,R.drawable.ikizler6,R.drawable.koc7,R.drawable.kova8,
                R.drawable.oglak9,R.drawable.terazi10,R.drawable.yay11,R.drawable.yengec12)
        var burcBuyukResimler = arrayOf(R.drawable.akrepbuyuk1,R.drawable.aslanbuyuk2,R.drawable.balikbuyuk3,R.drawable.basakbuyuk4,R.drawable.bogabuyuk5,R.drawable.ikizlerbuyuk6,
                R.drawable.kocbuyuk7,R.drawable.kovabuyuk8,R.drawable.oglakbuyuk9,R.drawable.terazibuyuk10,R.drawable.yaybuyuk11,R.drawable.yengecbuyuk12)
        var burcGenelOzellik = resources.getStringArray(R.array.burcOzellikleri)

        for(i in 0..11){
            var listeAt = Burc(burcAdlari[i],burcTarihleri[i],burcResimleri[i],burcBuyukResimler[i],burcGenelOzellik[i])
            tumBurcBilgileri.add(listeAt)
        }
    }
}
