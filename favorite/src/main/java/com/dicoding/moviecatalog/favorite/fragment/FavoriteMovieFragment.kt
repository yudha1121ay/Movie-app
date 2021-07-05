package com.dicoding.moviecatalog.favorite.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.moviecatalog.databinding.FragmentFavoriteMovieBinding
import com.dicoding.moviecatalog.detail.DetailMovie
import com.dicoding.moviecatalog.favorite.viewmodel.FavMovieModel
import com.dicoding.moviecatalog.ui.adapter.MovieAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteMovieFragment : Fragment(){

    private val favoriteViewModel: FavMovieModel by viewModel()

    private var _binding: FragmentFavoriteMovieBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteMovieBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val mvAdapter = MovieAdapter()
            mvAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailMovie::class.java)
                intent.putExtra(DetailMovie.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            favoriteViewModel.favMovies.observe(viewLifecycleOwner, { movies ->
                mvAdapter.setData(movies)
                binding?.viewEmpty?.root?.visibility = if (movies.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding?.listfavmovie) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = mvAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}