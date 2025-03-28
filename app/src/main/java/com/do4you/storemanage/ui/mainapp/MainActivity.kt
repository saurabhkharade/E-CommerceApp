package com.do4you.storemanage.ui.mainapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.do4you.storemanage.R
import com.do4you.storemanage.StoreManageApplication
import com.do4you.storemanage.data.model.ProductsItem
import com.do4you.storemanage.databinding.ActivityMainBinding
import com.do4you.storemanage.di.component.DaggerActivityComponent
import com.do4you.storemanage.di.module.ActivityModule
import com.do4you.storemanage.ui.adapter.ProductAdapter
import com.do4you.storemanage.ui.base.UiState
import com.do4you.storemanage.ui.viewmodel.ProductListViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var productListViewModel: ProductListViewModel

    @Inject
    lateinit var adapter: ProductAdapter

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()


        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupUI()
        setupObserver()


    }


    private fun setupUI() {

        val recyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }


    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                productListViewModel.uiState.collect {
                    when (it) {

                        is UiState.Success -> {
                            binding.progressBar.visibility = View.GONE
                            renderList(it.data)
                            binding.recyclerView.visibility = View.VISIBLE
                        }

                        is UiState.Error -> {
                            //Handle Error
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_LONG)
                                .show()

                        }
                        UiState.Loading -> {

                            binding.progressBar.visibility = View.VISIBLE
                            binding.recyclerView.visibility = View.GONE
                        }
                    }
                }
            }
        }
    }

    private fun renderList(articleList: List<ProductsItem>) {
        adapter.addData(articleList)
        adapter.notifyDataSetChanged()
    }


    private fun injectDependencies() {

        DaggerActivityComponent.builder()
            .applicationComponent((application as StoreManageApplication).applicationComponent) // Pass ApplicationComponent
            .activityModule(ActivityModule(this)) // Provide ActivityModule
            .build()
            .inject(this)
    }
}