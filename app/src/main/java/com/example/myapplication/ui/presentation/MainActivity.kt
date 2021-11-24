package com.example.myapplication.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.myapplication.MainNavigation
import com.example.myapplication.database.TaskDatabase
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.viewmodel.MyViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val taskDao = TaskDatabase.getInstance(applicationContext).taskDao
        val vmf = MyViewModelFactory(taskDao)
        setContent {
            MyApplicationTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    MainNavigation(vmf)
                }
            }
        }
    }
}


