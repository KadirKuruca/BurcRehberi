package com.kadirkuruca.burcrehberi

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.teksatir_layout.view.*

/**
 * Created by Kadir on 22.02.2018.
 */
class BurclarArrayAdapter(var gelenContext: Context, resource: Int, textViewResourceId: Int, var burcAdları: Array<String>, var burcTarihleri : Array<String>, var burcResimleri : Array<Int>)
    : ArrayAdapter<String>(gelenContext, resource, textViewResourceId, burcAdları) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        // Aşağıdaki if satırı ile birlikte inflate işlemi optimize edildi. Uygulama çalışınca sürekli inflation işlemi yapması engellendi.
        var tek_satir_view = convertView
        var viewHolder : ViewHolder? = null

        if(tek_satir_view == null)
        {
            var inflater = LayoutInflater.from(gelenContext)
            tek_satir_view = inflater.inflate(R.layout.teksatir_layout,parent,false)

            viewHolder = ViewHolder(tek_satir_view)
            tek_satir_view.tag = viewHolder // Aşağıda da aynı viewHolder nesnesini kullanmak için tag kullandık.
            Log.e("KADIR","INFLATION YAPILDI "+burcAdları[position])
        }
        else{
            viewHolder = tek_satir_view.getTag() as ViewHolder // getTag ile nesneyi kullandık.

        }


        viewHolder.burcResim.setImageResource(burcResimleri[position])
        viewHolder.burcAdi.setText(burcAdları[position])
        viewHolder.burcTarih.setText(burcTarihleri[position])

        return tek_satir_view
    }
}

class ViewHolder(tek_satir_view :View){
    var burcResim :ImageView
    var burcAdi : TextView
    var burcTarih : TextView

    init {
        this.burcAdi = tek_satir_view.tvBurcAdi
        this.burcResim = tek_satir_view.imgBurcResim
        this.burcTarih = tek_satir_view.tvBurcTarih
    }
}