package com.example.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.githubuser.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail User"

        val data = intent.getParcelableExtra<User>("DATA")
        binding.tvName.text = data?.name
        binding.tvUsername.text = data?.username
//        Glide.with(this)
//            .load(data)
//            .apply(RequestOptions())
//            .into(binding.civPhoto)


        Log.d("Detail Data Name", data?.name.toString())
        Log.d("Detail Data Username", data?.username.toString())
    }
}