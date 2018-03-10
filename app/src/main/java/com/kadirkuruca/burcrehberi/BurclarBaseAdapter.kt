package com.kadirkuruca.burcrehberi

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.teksatir_layout.view.*
import java.text.FieldPosition

/**
 * Created by Kadir on 23.02.2018.
 */
class BurclarBaseAdapter(context: Context,tumBurcBilgileri : ArrayList<Burc>) : BaseAdapter() {

    var tumBurclar : ArrayList<Burc>
    var context : Context

    init {
        tumBurclar = tumBurcBilgileri
        this.context = context
    }

    override fun getView(position: Int,convertView : View?, parent: ViewGroup?): View? {

        var tek_satir_view = convertView
        var viewHolder:ViewHolder2

        if(tek_satir_view == null){
            var inflater = LayoutInflater.from(context)
            tek_satir_view = inflater.inflate(R.layout.teksatir_layout,parent,false)
            Log.e("Kadir","INFLATION YAPILDI "+tumBurclar[position].burcAdi)

            viewHolder = ViewHolder2(tek_satir_view)
            tek_satir_view.tag = viewHolder

        }
        else{
            viewHolder = tek_satir_view.getTag() as ViewHolder2
        }

        viewHolder.burcResim.setImageResource(tumBurclar.get(position).burcResim)
        viewHolder.burcAd.setText(tumBurclar.get(position).burcAdi)
        viewHolder.burcTarih.setText(tumBurclar.get(position).burcTarih)

        return tek_satir_view
    }

    override fun getItem(position: Int): Any {
        return tumBurclar.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return tumBurclar.size
    }
}



class ViewHolder2(tek_satir_view : View){
    var burcResim : ImageView
    var burcAd : TextView
    var burcTarih : TextView

    init {
        this.burcAd = tek_satir_view.tvBurcAdi
        this.burcTarih = tek_satir_view.tvBurcTarih
        this.burcResim = tek_satir_view.imgBurcResim
    }
}