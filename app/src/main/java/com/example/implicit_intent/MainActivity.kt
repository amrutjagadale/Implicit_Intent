package com.example.implicit_intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.implicit_intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.OpenWebPagebutton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/components/intents-filters"))
            startActivity(intent)
        }
        binding.OpenCamerabutton3.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+1234567989")
            startActivity(intent)
        }
        binding.editTextText.setOnClickListener{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)

        }
        binding.ShareTextbutton4.setOnClickListener {
            val text: String = binding.toString()
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,text)
            startActivity(Intent.createChooser(intent,"Share via"))

        }
    }
}