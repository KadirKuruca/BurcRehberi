package com.kadirkuruca.burcrehberi

import java.io.Serializable

/**
 * Created by Kadir on 23.02.2018.
 */
data class Burc(var burcAdi : String,var burcTarih : String,var burcResim : Int,var burcBuyukResim : Int, var burcGenelOzellik : String):Serializable{}