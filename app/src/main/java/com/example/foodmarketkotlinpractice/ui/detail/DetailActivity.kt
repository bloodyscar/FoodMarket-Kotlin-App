package com.example.foodmarketkotlinpractice.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.foodmarketkotlinpractice.R
import com.example.foodmarketkotlinpractice.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)


    }

    override fun onResume() {
        super.onResume()
        hideToolbar()
    }

    fun toolbarPayment(){
        val mActionBarToolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(mActionBarToolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.show()
        supportActionBar?.title = resources.getString(R.string.payment)
        supportActionBar?.subtitle = resources.getString(R.string.deserve)

    }

    fun hideToolbar(){
        val mActionBarToolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(mActionBarToolbar);
        supportActionBar?.hide()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.detailHostFragment)
        return when(navController.currentDestination?.id){
            R.id.action_payment -> {
                true
            }
            else -> navController.navigateUp()
        }
//        return super.onSupportNavigateUp()
    }
}