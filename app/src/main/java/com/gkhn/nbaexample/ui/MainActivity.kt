package com.gkhn.nbaexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.gkhn.nbaexample.R
import com.gkhn.nbaexample.data.repository.PlayerRepositoryImpl
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViewModel()
    }

    private fun initViewModel() {
        mainViewModel.playerList.observe(
            this,
            Observer {
                Log.e("playerList",""+it)
            }
        )

        mainViewModel.player.observe(
            this, Observer { player ->  Log.e("player",""+player) }
        )

        mainViewModel.teamList.observe(
            this,
            Observer { list -> Log.e("teamList",""+list) }
        )
        mainViewModel.getAllPlayers()
        mainViewModel.getPlayerWithId(237)
        mainViewModel.getAllTeams()
    }
}
