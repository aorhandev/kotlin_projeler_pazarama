package com.example.kotlinproje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main(){

    var urunler = HashMap<String, Int>()
    var kategoriler = HashMap<String,HashMap<String,Int>>()

    urunler.put("iPhone13", 22000)
    urunler.put("iPhone12", 20000)
    urunler.put("iPhone11", 18000)
    kategoriler.put("Telefon", urunler)

    urunler = HashMap()
    urunler.put("Samsung Televizyon", 20000)
    urunler.put("Sony Televizyon", 15000)
    kategoriler.put("Televizyon", urunler)

    urunler = HashMap()
    urunler.put("Macbook Laptop", 25000)
    urunler.put("Asus Laptop", 20000)
    urunler.put("Lenovo Laptop", 15500)
    urunler.put("Monster Laptop", 15000)
    kategoriler.put("Bilgisayar", urunler)


    kategoriler.forEach { kategori ->

        println("${kategori.key} kategorisine ait ürünler")
        kategori.component2().forEach{ urun ->
            println("${urun.key} fiyatı ${urun.value} TL")
        }
        println("")
    }

    // Verilen tamsayı listesindeki verileri kontrol edip.
    // Eğer listedeki eleman sayısı 5 ten küçükse, string olarak sonuc değeri alan bir
    // işlevi tetikleyen ve parametre olarak "Eleman sayısı yetersiz" metnini gönderen,
    // eğer 5 ten büyükse sayıların aritmetik ortalamasını hesaplayıp kendisine gönderilen
    // farklı bir işleve gönderen fonksiyonu yazınız.



}