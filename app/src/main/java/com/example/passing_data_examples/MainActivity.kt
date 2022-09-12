package com.example.passing_data_examples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.passing_data_examples.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnStart.setOnClickListener {
            //sending Data via Serializable
            val name = binding.etName.text.toString()
            val user = User(name = name)

            Intent(this, SecondActivity::class.java).also {
                it.putExtra(DataConstants.EXTRA_USER_SERIALIZABLE,user)
                startActivity(it)
            }
        }
    }
}