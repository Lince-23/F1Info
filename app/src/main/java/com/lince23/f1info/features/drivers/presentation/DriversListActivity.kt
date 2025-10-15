package com.lince23.f1info.features.drivers.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lince23.f1info.R
import com.lince23.f1info.core.api.ApiClient
import com.lince23.f1info.features.drivers.data.DriversDataRepository
import com.lince23.f1info.features.drivers.data.remote.DriversApiRemoteDataSource
import com.lince23.f1info.features.drivers.domain.GetDriversListUseCase

class DriversListActivity : AppCompatActivity() {

    private val viewModel = DriversListViewModel(
        GetDriversListUseCase(
            DriversDataRepository(
                DriversApiRemoteDataSource(ApiClient())
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_drivers_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setUpObserver()
        viewModel.loadDrivers()
    }

    private fun setUpObserver() {
        val observer = Observer<DriversListViewModel.UiState> { uiState ->
            if (uiState.isLoading) {

            } else {

            }

            uiState.error?.let {
                TODO("En caso de error")
            } ?: {
                TODO("Ocultar error")
            }

            uiState.drivers?.let { drivers ->
                val driversAdapter = DriversAdapter(drivers)
                val recyclerView: RecyclerView = findViewById(R.id.rvDrivers)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = driversAdapter
            }
        }
        viewModel.uiState.observe(this, observer)
    }
}