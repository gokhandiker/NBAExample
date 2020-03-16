package com.gkhn.nbaexample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.data.datamodel.AllPlayersNetworkModel
import com.gkhn.nbaexample.data.repository.PlayerRepositoryImpl
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel(val playerRepositoryImpl: PlayerRepositoryImpl) : ViewModel(),CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    val playerList = MutableLiveData<AllPlayersNetworkModel>()

    fun getAllPlayers() {

        launch {
            val result = withContext(Dispatchers.IO) {
                playerRepositoryImpl.getAllPlayers()
            }

            when(result) {
                is Output.Success -> playerList.value = result.data
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}