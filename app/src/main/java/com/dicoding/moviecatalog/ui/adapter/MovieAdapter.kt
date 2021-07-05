package com.dicoding.moviecatalog.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.moviecatalog.R
import com.dicoding.moviecatalog.core.databinding.ItemsMoviesBinding
import com.dicoding.moviecatalog.core.domain.model.MovieVar
import com.dicoding.moviecatalog.core.utils.ListURL.IMAGE_URL
import java.util.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    private var listData = ArrayList<MovieVar>()
    var onItemClick: ((MovieVar) -> Unit)? = null

    fun setData(newListData: List<MovieVar>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_movies, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemsMoviesBinding.bind(itemView)
        fun bind(data: MovieVar) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(IMAGE_URL + data.posterPath)
                    .into(moviePoster)
                mvJudul.text = data.title
                mvRelease.text = data.voteAverage.toString()
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}