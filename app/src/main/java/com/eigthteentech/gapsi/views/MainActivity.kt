package com.eigthteentech.gapsi.views

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.eigthteentech.gapsi.App
import com.eigthteentech.gapsi.common.ProductAdapter
import com.eigthteentech.gapsi.common.QueryAdapter
import com.eigthteentech.gapsi.databinding.ActivityMainBinding
import com.eigthteentech.gapsi.entities.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity(), QueryAdapter.QueryListener {

    @Inject
    lateinit var viewModel: ProductViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val managerQ = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.products.layoutManager = manager
        binding.recentQueriesList.layoutManager = managerQ

        viewModel.queries.observe(this){
            binding.recentQueriesList.adapter = QueryAdapter(it, this)
        }

        viewModel.response.observe(this) {
            when (it) {
                is Response.NotInitialized -> {
                    binding.progressBar.visibility = View.GONE
                }
                is Response.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Response.Fail -> {
                    Toast.makeText(this, it.exception.message, Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility = View.GONE
                }
                is Response.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.products.adapter = ProductAdapter(it.data)
                }
            }
        }

        binding.button.setOnClickListener {
            hideKeyboard()
            if (binding.queryText.text.toString().isNotEmpty())
                viewModel.fetchRepository(binding.queryText.text.toString())
            else
                Toast.makeText(this,"Please introduce a valid search", Toast.LENGTH_LONG).show()
        }



    }

    private fun hideKeyboard() {
        val imm: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view: View? = currentFocus
        if (view == null)
            view = View(this)
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onClicked(name: String) {
        viewModel.fetchRepository(name)
    }

}