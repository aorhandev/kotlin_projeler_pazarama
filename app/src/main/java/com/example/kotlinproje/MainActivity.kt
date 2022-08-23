package com.example.kotlinproje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main1(){

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

/*
fun main1(){
    var sayilar = arrayListOf<Int>(1,2,3,4,5,6,7)

    aritmatikOrtalama(sayilar, ::ortalama)
}

fun ortalama(dizi : ArrayList<Int>): String{
    var elemanSayisi = dizi.count()
    var sonuc = 0

    for (i in dizi){
        sonuc += i
    }

    var aritmatikOrtalamaSonuc = sonuc/elemanSayisi
    return println(aritmatikOrtalamaSonuc).toString()
}

fun aritmatikOrtalama(dizi: ArrayList<Int>,ortalama : (ArrayList<Int>)-> String){
    var elemanSayisi = dizi.count()

    if( elemanSayisi < 5 ){
        println("Eleman sayısı yetersiz")
    }else {
        ortalama(dizi)
    }

}

 */



/*
Kitapevi Modellemesi

-- Kütüphanedeki kaynaklar farklı kategorilerde olabilmekte ve her kaynağın ISBN numarası, Adı ve yazarı bulunmaktadır.
-- Kaynaklar Kitap, Ansiklopedi, Dergi türlerinde olabilir.
-- Kitapevine üye kişiler bulunur ve kişilerin Ad, Soyad ve üye numarası zorunlu olmakla birlikte telefon numarası ve adres bilgileri de bulunabilir.
-- Üyeler farklı türlerde olabilir. Misafir, Üye, Müdavim
-- Misafirler sadece 1 kitap alabilirler
-- Üyeler 3 kitap alabilir
-- Müdavimler ise sınırsız sayıda kitap alabilirler.

Bu modellemeyi yaparak, örnek kayıtlar ile kitaplar ve üyeler oluşturup üyelerin bu kaynaklardan bazılarını aldığı örnek uygulamayı oluşturunuz.

*/

class Kitap(isbnNo: String, ad: String, yazar: String) : Kaynaklar(isbnNo, ad, yazar) {

    var Kategoriler = ArrayList<Kategori>()

    fun kategoriEkle(kategori : Kategori)
    {
        Kategoriler.add(kategori)
        println("Kitaba kategori eklendi.")
    }

    init {
        println("Kitap oluşturuldu.")
    }
}
class Ansiklopedi(isbnNo: String, ad: String, yazar: String) : Kaynaklar(isbnNo, ad, yazar) {
    var Kategoriler = ArrayList<Kategori>()

    fun kategoriEkle(kategori : Kategori)
    {
        Kategoriler.add(kategori)
        println("Ansiklopediye kategori eklendi.")
    }

    init {
        println("Ansiklopedi oluşturuldu.")
    }
}
class Dergi(isbnNo: String, ad: String, yazar: String) : Kaynaklar(isbnNo, ad, yazar) {
    var Kategoriler = ArrayList<Kategori>()

    fun kategoriEkle(kategori : Kategori)
    {
        Kategoriler.add(kategori)
        println("Dergiye kategori eklendi.")
    }

    init {
        println("Dergi oluşturuldu.")
    }
}

class Kategori(var ad: String){
    init {
        println(ad + " oluşturuldu.")
    }
}

open class Kaynaklar(var isbnNo : String, var ad : String, var yazar : String) {}

class Misafir(ad: String, soyad: String, uyeNo: Int) : UyeBilgileri(ad, soyad, uyeNo) {
    init {
        println("Misafir üye oluşturuldu.")
    }

    override fun kaynakEkle(kaynak:Kaynaklar){
        if(kaynaklar.isEmpty()){
            kaynaklar.add(kaynak)
            println("Misafir üyeye kaynak eklendi.")
        }else {
            println("1'den fazla kaynak alınamaz.")
        }
    }
}
class Uye(ad: String, soyad: String, uyeNo: Int) : UyeBilgileri(ad, soyad, uyeNo) {
    init {
        println("Normal üye oluşturuldu.")
    }

    override fun kaynakEkle(kaynak:Kaynaklar){
        if(kaynaklar.count()<3){
            kaynaklar.add(kaynak)
            println("Normal üyeye kaynak eklendi.")
        }else {
            println("3'den fazla kaynak alınamaz.")
        }
    }
}
class Mudavim(ad: String, soyad: String, uyeNo: Int) : UyeBilgileri(ad, soyad, uyeNo) {
    init {
        println("Müdavim üye oluşturuldu.")
    }

    override fun kaynakEkle(kaynak:Kaynaklar){
            kaynaklar.add(kaynak)
            println("Müdavim üyeye kaynak eklendi. (Sınırsız)")
        }
}

open class UyeBilgileri(var ad: String, var soyad: String, var uyeNo: Int) {
    var telefonNo: String? = null
    var adres: String? = null
    var kaynaklar = ArrayList<Kaynaklar>()

    open fun kaynakEkle(kaynak:Kaynaklar){
        if(kaynaklar.isEmpty()){
            kaynaklar.add(kaynak)
        }else {
            println("Kaynak alınamaz.")
        }
    }
}

fun main() {

    // Kategoriler oluşturuldu.
    var kategori1 = Kategori("Kategori 1")
    var kategori2 = Kategori("Kategori 2")
    var kategori3 = Kategori("Kategori 3")
    var kategori4 = Kategori("Kategori 4")

    // Kaynaklar oluşturuldu.
    println("\n")
    var kaynak1 = Kitap("111222333","Kitap 1","Yazar 1")
    var kaynak2 = Dergi("111222333","Dergi 1","Yazar 2")
    var kaynak3 = Kitap("111222333","Kitap 2","Yazar 1")
    var kaynak4 = Ansiklopedi("111222333","Ansiklopedi 1","Yazar 3")
    var kaynak5 = Ansiklopedi("111222333","Ansiklopedi 2","Yazar 4")
    var kaynak6 = Ansiklopedi("111222333","Dergi 2","Yazar 5")

    // Üyelikler oluşturuldu.
    println("\n")
    var uye1 = Misafir("Misafir 1","Misafir Soyad 1",1231321,)
    var uye2 = Uye("Uye 1","Uye Soyad 1",12313213)
    var uye3 = Mudavim("Müdavim","Müdavim Soyad 1",12313213)

    // Kaynaklara kategori ekleme işlemi yapıldı.
    println("\n")
    kaynak1.kategoriEkle(kategori1)
    kaynak2.kategoriEkle(kategori1)
    kaynak3.kategoriEkle(kategori2)
    kaynak4.kategoriEkle(kategori3)
    kaynak5.kategoriEkle(kategori4)
    kaynak6.kategoriEkle(kategori2)

    // Üyelere kaynak ekleme işlemi yapıldı.
    println("\nÜye 1: Misafir")
    uye1.kaynakEkle(kaynak1)
    uye1.kaynakEkle(kaynak3)

    println("\nÜye 2: Normal Üye")
    uye2.kaynakEkle(kaynak1)
    uye2.kaynakEkle(kaynak4)
    uye2.kaynakEkle(kaynak2)
    uye2.kaynakEkle(kaynak3)
    uye2.kaynakEkle(kaynak5)

    println("\nÜye 3: Müdavim")
    uye3.kaynakEkle(kaynak1)
    uye3.kaynakEkle(kaynak2)
    uye3.kaynakEkle(kaynak3)
    uye3.kaynakEkle(kaynak2)
    uye3.kaynakEkle(kaynak1)
    uye3.kaynakEkle(kaynak1)
    uye3.kaynakEkle(kaynak2)
    uye3.kaynakEkle(kaynak4)
    uye3.kaynakEkle(kaynak5)


}