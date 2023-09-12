package com.example.activityintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activityintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "Lifecycle"
    private lateinit var binding: ActivityMainBinding
    companion object{
        const val EXTRA_NAME = "EXT_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "OnCreate()")

        with(binding){
            btnGotToSecond.setOnClickListener{
                val intent = Intent(this@MainActivity, SecondaryActivity::class.java)
                intent.putExtra(EXTRA_NAME, etInput.text.toString())
                startActivity(intent)
            }

            btnSend.setOnClickListener{
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "type/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "Hello World")
                startActivity(intent)
            }

            btnPhone.setOnClickListener{
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:08217882517")
                startActivity(intent)
            }
            btnOpenUrl.setOnClickListener{
                val intent = Intent(Intent.ACTION_SEND)
                intent.data = Uri.parse("https://www.google.com")
                startActivity(intent)
            }

        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "OnStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "OnResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "OnPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "OnStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "OnDestroy()")

    }
}