package app.bo.com.ucb.clean22021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import app.bo.com.ucb.data.MoviesRepository
import app.bo.com.ucb.domain.Movie
import app.bo.com.ucb.framework.MovieDataSource
import app.bo.com.ucb.framework.RetrofitBuilder
import app.bo.com.ucb.usecases.GetPopularMovies

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = MainViewModel(GetPopularMovies( MoviesRepository( MovieDataSource( RetrofitBuilder) ), getString(R.string.api_key)) )

        mainViewModel.model.observe(this, Observer(:: updateUi))
        mainViewModel.loadMovies()
    }

    private fun updateUi(uiModel: MainViewModel.UiModel?) {
        when ( uiModel) {
            is MainViewModel.UiModel.Content -> loadList( uiModel.movies)
        }
    }

    fun loadList( list: List<Movie>) {
        // recycler.adapter = AdapterMainViewModel( list)
    }
}