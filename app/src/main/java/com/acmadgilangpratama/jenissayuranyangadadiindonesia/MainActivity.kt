package com.acmadgilangpratama.jenissayuranyangadadiindonesia

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.acmadgilangpratama.jenissayuranyangadadiindonesia.adapter.AdapterSayuran
import com.acmadgilangpratama.jenissayuranyangadadiindonesia.databinding.ActivityMainBinding
import com.acmadgilangpratama.jenissayuranyangadadiindonesia.model.Sayuran

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listSayuran = ArrayList<Sayuran>()
        listSayuran.add(Sayuran("Brokoli",R.drawable.brokoli,"Brassica oleracea var. Italica"))
        listSayuran.add(Sayuran("Sawi",R.drawable.sawi,"Brassica chinensis var. parachinensis"))
        listSayuran.add(Sayuran("Bayam",R.drawable.bayam,"Amaranthus"))
        listSayuran.add(Sayuran("Kangkung",R.drawable.kangkung,"ipomoea aquatic"))
        listSayuran.add(Sayuran("Bok Choy",R.drawable.bokchoy,"Brassica rapa subsp. chinensis"))
        listSayuran.add(Sayuran("Sawi Jepang",R.drawable.sawijepang,"Brassica rapa var. perviridis"))
        listSayuran.add(Sayuran("Sawi Putih",R.drawable.sawiputih,"Brassica rapa subsp. pekinensis"))
        listSayuran.add(Sayuran("Brokoli Cina",R.drawable.brokolicina,"Brassica oleracea Alboglabra Group"))
        listSayuran.add(Sayuran("Kubis",R.drawable.kubis,"Brassica oleracea var. Capitata"))
        listSayuran.add(Sayuran("Selada",R.drawable.selada,"Lactuca sativa"))


        binding.list.adapter = AdapterSayuran(this,listSayuran,object : AdapterSayuran.OnClickListener {
            override fun detailData(item: Sayuran?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_sayuran)

                    val image = this.findViewById<ImageView>(R.id.image_sayuran)
                    val nama = this.findViewById<TextView>(R.id.txtNamaSayur)
                    val namailmiah = this.findViewById<TextView>(R.id.txtIlmiahSayur)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    namailmiah.text = "${item?.namaIlmiah}"

                    btn.setOnClickListener{
                        this.dismiss()
                    }
                }.show()
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode : Int) {
        when(selectedMode) {
            R.id.myprofile -> {
                val intent = Intent(this,Profile::class.java)
                startActivity(intent)
            }
        }
    }
}
