package com.gkhn.nbaexample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gkhn.nbaexample.data.Output
import com.gkhn.nbaexample.domain.domainmodel.PlayerDomainModel
import com.gkhn.nbaexample.domain.domainmodel.TeamDomainModel
import com.gkhn.nbaexample.domain.usecase.getallplayers.GetAllPlayersUseCaseImpl
import com.gkhn.nbaexample.domain.usecase.getallteams.GetAllTeamsUseCaseImpl
import com.gkhn.nbaexample.domain.usecase.getplayerwithid.GetPlayerWithIdUseCaseImpl
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel(val getAllPlayersUseCaseImpl: GetAllPlayersUseCaseImpl,
                    val getPlayerWithIdUseCase: GetPlayerWithIdUseCaseImpl,
                    val getAllTeamUseCaseImpl: GetAllTeamsUseCaseImpl) : ViewModel(),CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    val playerList = MutableLiveData<List<PlayerDomainModel>>()
    val player = MutableLiveData<PlayerDomainModel>()
    val teamList = MutableLiveData<List<TeamDomainModel>>()

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


    fun getPlayerWithId(id:Int) {
        launch {
            val result = withContext(Dispatchers.IO) {
                getPlayerWithIdUseCase.invoke(id)
            }

            when (result) {
            is Output.Success -> player.value = result.data
            }

        }
    }

    fun getAllTeams() {
        launch {
            val result = withContext(Dispatchers.IO) {
                getAllTeamUseCaseImpl.getAllTeams()
            }

            when (result) {
                is Output.Success -> teamList.value = result.data
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}