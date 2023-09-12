package com.example.activityintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityintent.databinding.ActivitySecondaryBinding
import com.example.activityintent.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra(MainActivity.EXTRA_NAME)

        with(binding){
            val resultIntent = Intent()
            resultIntent.putExtra(SecondaryActivity.EXTRA_ADDRESS,etInput.text.toString())
            resultIntent.putExtra(MainActivity.EXTRA_NAME, name)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}