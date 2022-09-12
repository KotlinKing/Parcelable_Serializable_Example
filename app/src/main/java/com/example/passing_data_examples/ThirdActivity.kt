package com.example.passing_data_examples

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.passing_data_examples.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val feedback:Feedback = intent.getParcelableExtra(DataConstants.EXTRA_FEEDBACK_PARCELABLE)!!
        binding.txtFeedback.text = feedback.feedback

        binding.btnRestart.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(it)
            }
        }
    }
}