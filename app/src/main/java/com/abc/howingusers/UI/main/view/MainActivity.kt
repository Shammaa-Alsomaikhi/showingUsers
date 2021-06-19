package com.abc.howingusers.UI.main.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abc.howingusers.Data.api.ApiHelper
import com.abc.howingusers.Data.api.RetrofitBuilder
import com.abc.howingusers.Data.model.users
import com.abc.howingusers.R
import com.abc.howingusers.UI.base.ViewModelFactory
import com.abc.howingusers.UI.main.adapter.RecyclerViewAdapter
import com.abc.howingusers.UI.main.viewmodel.mainViewModel
import com.abc.howingusers.Domain.status.ERROR
import com.abc.howingusers.Domain.status.LOADING
import com.abc.howingusers.Domain.status.SUCCESS


class MainActivity : AppCompatActivity() {

    //The lateinit keyword stands for late initialization. * variable can't be of null type
    private lateinit var viewModel: mainViewModel
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        setupViewModel()
        setupUI()
        setupObservers()

    }

    private fun setupViewModel() {

       // ViewModelProviders.of(<Your UI controller>).get(<Your ViewModel>.class)
        // use the ViewModelFactory class to instantiate and return the ViewModel object
        // that survives configuration changes.
        // A GOOD explanation here: https://medium.com/koderlabs/viewmodel-with-viewmodelprovider-factory-the-creator-of-viewmodel-8fabfec1aa4f

        viewModel = ViewModelProviders.of(
                this,
                ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(mainViewModel::class.java)
    }

    private fun setupUI() {
        //getting recyclerview from xml
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
       // recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(arrayListOf())
        recyclerView.addItemDecoration(
                DividerItemDecoration(
                        recyclerView.context,
                        (recyclerView.layoutManager as LinearLayoutManager).orientation
                )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        viewModel.getUsers().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        resource.data?.let { users -> retrieveList(users) }
                    }
                    ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    LOADING -> {
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(users: List<users>) {
        adapter.apply {
            addUsers(users)
            notifyDataSetChanged()
        }
    }
}