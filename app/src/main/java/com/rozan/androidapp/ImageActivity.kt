package com.rozan.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton

class ImageActivity : AppCompatActivity() {
    private lateinit var rdoGara:RadioButton
    private lateinit var rdoItachi:RadioButton
    private lateinit var rdoKageyama:RadioButton
    private lateinit var imgProfile:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        rdoGara=findViewById(R.id.rdoGaara)
        rdoItachi=findViewById(R.id.rdoItachi)
        rdoKageyama=findViewById(R.id.rdoKageyama)
        imgProfile=findViewById(R.id.imgProfile)

        rdoGara.setOnClickListener{
            imgProfile.setImageResource(R.drawable.gara)

        }
        rdoItachi.setOnClickListener{
            imgProfile.setImageResource(R.drawable.itachi)

        }
        rdoKageyama.setOnClickListener{
            imgProfile.setImageResource(R.drawable.kageyama)

        }


    }
}