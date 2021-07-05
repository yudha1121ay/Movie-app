package com.dicoding.moviecatalog.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.moviecatalog.core.vo.Resource
import com.dicoding.moviecatalog.databinding.FragmentMoviesBinding
import com.dicoding.moviecatalog.detail.DetailMovie
import com.dicoding.moviecatalog.ui.adapter.MovieAdapter
import com.dicoding.moviecatalog.ui.viewmodel.MovieModel
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {

    private val movieViewModel : MovieModel by viewModel()

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
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

            movieViewModel.getMovies.observe(viewLifecycleOwner, { data ->
                if (data != null) {
                    when (data) {
                        is Resource.Loading -> binding?.progressBar?.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding?.progressBar?.visibility = View.GONE
                            mvAdapter.setData(data.data)
                        }
                        is Resource.Error -> {
                            binding?.progressBar?.visibility = View.GONE
                        }
                    }
                }
            })

            with(binding?.listMovie) {
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












