package com.eigthteentech.gapsi.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.eigthteentech.gapsi.App
import com.eigthteentech.gapsi.R
import com.eigthteentech.gapsi.common.ProductAdapter
import com.eigthteentech.gapsi.databinding.ActivityMainBinding
import com.eigthteentech.gapsi.entities.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var viewModel: ProductViewModel

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.products.layoutManager = manager

        viewModel.response.observe(this, ){
            when(it){
                is Response.NotInitialized -> {}
                is Response.Loading -> {}
                is Response.Fail -> {}
                is Response.Success -> {
                    binding.products.adapter = ProductAdapter(it.data)
                }
            }
        }

        binding.button.setOnClickListener {
            if(binding.queryText.toString().isNotEmpty())
                viewModel.fetchRepository(binding.queryText.toString())
        }

    }
}