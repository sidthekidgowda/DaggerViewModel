package com.example.daggerviewmodel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerviewmodel.R
import com.example.daggerviewmodel.application.MainApplication

class MainActivity : AppCompatActivity() {

    val appComponent by lazy {
        (application as MainApplication).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, IncrementDecrementFragment())
                .commit()
        }
    }
}
