package com.aransafp.rickandmor.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.aransafp.rickandmor.data.api.ApiConfig
import com.aransafp.rickandmor.data.api.ApiHelperImpl
import com.aransafp.rickandmor.databinding.ActivityMainBinding
import com.aransafp.rickandmor.ui.main.adapter.MainAdapter
import com.aransafp.rickandmor.ui.main.intent.MainIntent
import com.aransafp.rickandmor.ui.main.viewmodel.MainViewModel
import com.aransafp.rickandmor.ui.main.viewstate.MainState
import com.aransafp.rickandmor.util.ViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private val mainAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCharacters.layoutManager = LinearLayoutManager(this)
        binding.rvCharacters.adapter = mainAdapter

        val factory = ViewModelFactory(ApiHelperImpl(ApiConfig.getApiService()))
        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        lifecycleScope.launch {
            mainViewModel.state.collect {

                when (it) {
                    is MainState.Idle -> {

                    }

                    is MainState.Loading -> {
                        with(binding) {
                            btnShow.visibility = View.GONE
                            progressBar.visibility = View.VISIBLE
                        }
                    }

                    is MainState.Characters -> {
                        binding.progressBar.visibility = View.GONE
                        binding.btnShow.visibility = View.GONE
                        binding.rvCharacters.visibility = View.VISIBLE
                        mainAdapter.setData(it.characters)
                    }

                    is MainState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.btnShow.visibility = View.VISIBLE
                        Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_LONG).show()
                    }

                }

            }
        }

        binding.btnShow.setOnClickListener {
            lifecycleScope.launch {
                mainViewModel.userIntent.send(MainIntent.FetchCharacter)
            }
        }


    }
}