package app.bo.com.ucb.data

import app.bo.com.ucb.domain.Movie

class MoviesRepository(val remoteDataSource: IRemoteDataSource) {
    fun getPopularMovies(apiKey: String): List<Movie> {
        return remoteDataSource.getPopularMovies(apiKey)
    }
}