package com.example.activityintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.activityintent.databinding.ActivityMainBinding
import com.example.activityintent.databinding.ActivitySecondaryBinding

class SecondaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondaryBinding
    companion object{
        const val EXTRA_ADDRESS = "EXT_ADDRESS"
    }
    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            val data = it.data
            val name = data?.getStringExtra(MainActivity.EXTRA_NAME)
            val address = data?.getStringExtra(EXTRA_ADDRESS)
            binding.textView.text = "$name ada di $address"
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(MainActivity.EXTRA_NAME)
        with(binding){
            textView.text = name
            btnGoToThird.setOnClickListener{
                val intent = Intent(this@SecondaryActivity, ThirdActivity::class.java)
                    .apply { putExtra(MainActivity.EXTRA_NAME, name) }
                launcher.launch(intent)
            }
        }
    }
}