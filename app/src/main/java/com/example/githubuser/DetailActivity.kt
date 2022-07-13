package com.example.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.githubuser.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail User"

        val data = intent.getParcelableExtra<User>("DATA") as User

        Glide.with(this)
            .load(data.photo)
            .into(binding.civPhoto)

        binding.apply {
            tvName.text = data.name
            tvUsername.text = data.username
            tvRepo.text = data.repository
            tvFollowers.text = data.followers
            tvFollowing.text = data.following
            tvLocation.text = data.location
            tvCompany.text = data.company
        }

        binding.btnFollow.setOnClickListener {
            Toast.makeText(this, "Anda mengikuti " + data.name, Toast.LENGTH_SHORT).show()
        }

        Log.d("Detail Data Name", data.name)
        Log.d("Detail Data Username", data.username)
    }
}