package com.gkhn.nbaexample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.domain.domainmodel.PlayerDomainModel
import com.gkhn.nbaexample.domain.usecase.GetAllPlayersUseCaseImpl
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel(val getAllPlayersUseCaseImpl: GetAllPlayersUseCaseImpl) : ViewModel(),CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    val playerList = MutableLiveData<List<PlayerDomainModel>>()

    fun getAllPlayers() {

        launch {
            val result = withContext(Dispatchers.IO) {
                getAllPlayersUseCaseImpl.invoke()
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