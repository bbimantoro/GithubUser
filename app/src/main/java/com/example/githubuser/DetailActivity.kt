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

        val user = intent.getParcelableExtra<User>("DATA") as User

        Glide.with(this)
            .load(user.photo)
            .into(binding.civPhoto)

        binding.apply {
            tvName.text = user.name
            tvUsername.text = user.username
            tvRepo.text = user.repository
            tvFollowers.text = user.followers
            tvFollowing.text = user.following
            tvLocation.text = user.location
            tvCompany.text = user.company
        }

        binding.btnFollow.setOnClickListener {
            Toast.makeText(this, "Anda mengikuti " + user.name, Toast.LENGTH_SHORT).show()
        }

        Log.d("Detail Data Name", user.name)
        Log.d("Detail Data Username", user.username)
    }
}