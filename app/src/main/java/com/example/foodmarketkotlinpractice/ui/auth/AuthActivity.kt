package com.example.foodmarketkotlinpractice.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.example.foodmarketkotlinpractice.R

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)



        val pageRequest = intent.getIntExtra("page_request", 0)
        if(pageRequest == 2) {
            toolbarSignup()
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.fragmentSignin, true)
                .build()
            Navigation.findNavController(findViewById(R.id.authHostFragment))
                .navigate(R.id.action_signup, null, navOptions)
        }


    }

    fun toolbarSignin(){
        val mActionBarToolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(mActionBarToolbar);
        supportActionBar?.title = resources.getString(R.string.signin);
        supportActionBar?.subtitle = resources.getString(R.string.find_your_best_ever_meal);
    }

    fun toolbarSignup(){
        val mActionBarToolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(mActionBarToolbar);
        supportActionBar?.title = resources.getString(R.string.signup);
        supportActionBar?.subtitle = resources.getString(R.string.register_and_eat);
    }

    fun toolbarSignupAddress(){
        val mActionBarToolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(mActionBarToolbar);
        supportActionBar?.title = resources.getString(R.string.address);
        supportActionBar?.subtitle = "Make sure it’s valid";
    }

    fun hideToolbar(){
        supportActionBar?.hide()
    }








}