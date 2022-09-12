package com.example.passing_data_examples

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.passing_data_examples.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //getting serializable data
        val user = intent.getSerializableExtra(DataConstants.EXTRA_USER_SERIALIZABLE) as User
        val txtGreet = "Hi ${user.name} :)"
        binding.txtUserName.text = txtGreet

        binding.btnFeedback.setOnClickListener {
            //sending Data via Parcelable
            val txtFeedback = binding.etFeedback.text.toString()
            val feedback = Feedback(feedback = txtFeedback)

            Intent(this, ThirdActivity::class.java).also {
                it.putExtra(DataConstants.EXTRA_FEEDBACK_PARCELABLE,feedback)
                startActivity(it)
            }
        }
    }
}