package com.example.tms_android_project.ui.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tms_android_project.ui.domain.models.DomainPost
import com.example.tms_android_project.ui.domain.use_cases.PostsUseCase
import com.example.tms_android_project.ui.presentation.models.NewsScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val postsUseCase: PostsUseCase
) : ViewModel() {

    private val eventFlow: MutableStateFlow<Event> = MutableStateFlow(value = Event.Default)
    private val newsScreenUiState = MutableStateFlow(value = NewsScreenUiState(isProgressVisible = false))

    internal fun getScreenStream(): Flow<NewsScreenUiState> = newsScreenUiState
    internal fun getEventsStream(): Flow<Event> = eventFlow

    fun uploadPosts(){
        viewModelScope.launch {
            //включаем видимость прогресса
            updateProgressVisibilityState(isProgressVisible = true)

            viewModelScope.launch {
                //задержка, чтобы успеть показать работу прогресса
                delay(POST_LOADING_DELAY)

                //запрос на получение постов
                val list = postsUseCase.getPosts()

                //это тригер ивента, о том, что обновился список и нам его надо обновить на фрагменте
                onEventHandled(event = Event.InitRecycler(list = list))

                //отключаем видимость прогресса
                updateProgressVisibilityState(isProgressVisible = false)
            }
        }
    }

    private fun updateProgressVisibilityState(isProgressVisible: Boolean) {
        newsScreenUiState.update { screenUiState ->
            screenUiState.copy(isProgressVisible = isProgressVisible)
        }
    }

    private fun onEventHandled(event: Event) = viewModelScope.launch { eventFlow.emit(event) }

    internal sealed class Event {
        object Default : Event()
        data class InitRecycler(val list: List<DomainPost>) : Event()
    }

    private companion object {
        private const val POST_LOADING_DELAY = 3000L
    }
}