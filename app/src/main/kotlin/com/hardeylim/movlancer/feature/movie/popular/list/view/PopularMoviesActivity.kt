package com.hardeylim.movlancer.feature.movie.popular.list.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hardeylim.movlancer.Constants
import com.hardeylim.movlancer.Constants.*
import com.hardeylim.movlancer.Constants.RecyclerSettings.columns
import com.hardeylim.movlancer.R
import com.hardeylim.movlancer.databinding.ActivityPopularMoviesBinding
import com.hardeylim.movlancer.feature.movie.popular.list.usecase.mapper.DtoToPopularMoviesMapper
import com.hardeylim.movlancer.framework.rx.RxSchedulerUtils
import com.hardeylim.movlancer.model.Movie
import com.hardeylim.movlancer.usecase.movie.MovieLoader
import dagger.android.AndroidInjection
import io.reactivex.disposables.Disposable
import timber.log.Timber
import java.util.*
import javax.inject.Inject


class PopularMoviesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPopularMoviesBinding

    private lateinit var movies: LinkedList<Movie>
    private lateinit var moviesAdapter: MoviesAdapter

    @Inject
    lateinit var loader: MovieLoader

    @Inject
    lateinit var rxSchedulerUtils: RxSchedulerUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_popular_movies)

//        val handler = Handler()
//        handler.postDelayed(Runnable {
//            var disposable: Disposable = loader.getPopularMovies("927ad0ee3b5ab2344711191ba07a0113")
//                .delay(5, TimeUnit.SECONDS)
//                .repeat()
//                .compose(rxSchedulerUtils.forFlowable())
//                .subscribe { t ->
//                    Timber.i(t.toString())
//                    movies = t.movies
//                    setupAdapter()
//                }
//        }, 5000)

        var disposable: Disposable = loader.getPopularMovies("927ad0ee3b5ab2344711191ba07a0113")
            //.delay(5, TimeUnit.SECONDS)
            .compose(rxSchedulerUtils.forSingle())
            .compose(DtoToPopularMoviesMapper())
            .subscribe { t ->
                Timber.i(t.toString())
                movies = t.movies
                setupAdapter()
            }


    }

    private fun setupAdapter() {
        binding.moviesRecycler.layoutManager = GridLayoutManager(this, columns)
//            GridLayoutManager(this, 2)
        moviesAdapter = MoviesAdapter(this, movies)
        binding.moviesRecycler.adapter = moviesAdapter
    }
}