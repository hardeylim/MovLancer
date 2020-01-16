package com.hardeylim.movlancer.feature.movie.popular.list.view

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.marginLeft
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.hardeylim.movlancer.Constants.RecyclerSettings.columns
import com.hardeylim.movlancer.R
import com.hardeylim.movlancer.databinding.ItemMovieBinding
import com.hardeylim.movlancer.feature.movie.popular.list.view.MoviesAdapter.ViewHolder
import com.hardeylim.movlancer.model.Movie
import java.util.*


class MoviesAdapter(
    private val context: Context,
    private var movies: LinkedList<Movie>) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)

        setHeightAndWidth(binding)

        return ViewHolder(binding)
    }

    private fun setHeightAndWidth(binding : ItemMovieBinding) {
        val displayMetrics = DisplayMetrics()
        val padding = context.resources.getDimension(R.dimen.popular_movies_recycler_item_padding).toInt()
        val padding2 = context.resources.getDimension(R.dimen.popular_movies_recycler_item_padding)

        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        val deviceWidth = displayMetrics.widthPixels/columns-padding*2
        val basicDeviceWidth = displayMetrics.widthPixels/2

        binding.imageMovie.marginLeft
        binding.imageMovie.layoutParams.width = deviceWidth
        binding.imageMovie.layoutParams.height = deviceWidth
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    object ImageBindingAdapter {
        @JvmStatic
        @BindingAdapter("android:src")
        fun setImageUrl(view: ImageView, url: String) {
            val valueInPixels = view.context.resources.getDimension(R.dimen.grid_round_corner).toInt()
            Glide.with(view.context)
                .load(url)
                .apply( RequestOptions().transforms( CenterCrop(), RoundedCorners(valueInPixels)))
                .into(view)
        }
    }


    inner class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movie = movie
        }
    }
}


