package app.bo.com.ucb.clean22021

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.bo.com.ucb.domain.Movie
import app.bo.com.ucb.usecases.GetPopularMovies
import kotlinx.coroutines.launch

class MainViewModel(val popularMovies: GetPopularMovies): ScopedViewMode() {
    init {
        initScope()
    }
    val model: LiveData<UiModel>
        get() = _model

    private val _model = MutableLiveData<UiModel>()

    sealed class UiModel() {
        class Content(val movies: List<Movie>): UiModel()
        class Loading(): UiModel()
    }

    fun loadMovies() {
        launch {
            _model.value = UiModel.Content(popularMovies.invoke())
        }

    }

}