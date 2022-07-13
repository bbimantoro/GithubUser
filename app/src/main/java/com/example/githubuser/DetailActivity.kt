package com.example.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.githubuser.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail User"

        val data = intent.getParcelableExtra<User>("DATA") as User
        binding.civPhoto.setImageResource(data.photo)
        binding.tvName.text = data.name
        binding.tvUsername.text = data.username
        binding.tvRepo.text = data.repository
        binding.tvFollowers.text = data.followers
        binding.tvFollowing.text = data.following
        binding.tvLocation.text = data.location
        binding.tvCompany.text = data.company
        binding.btnFollow.setOnClickListener {
            Toast.makeText(this, "Anda mengikuti " + data.name, Toast.LENGTH_SHORT).show()
        }

        Log.d("Detail Data Name", data.name)
        Log.d("Detail Data Username", data.username)
    }
}