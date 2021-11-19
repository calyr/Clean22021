package app.bo.com.ucb.data

import app.bo.com.ucb.domain.Movie

class MoviesRepository(val remoteDataSource: IRemoteDataSource) {
    suspend fun getPopularMovies(apiKey: String): List<Movie> {
        return remoteDataSource.getPopularMovies(apiKey)
    }
}