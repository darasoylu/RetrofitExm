package com.darasoylu.retrofitexm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.darasoylu.retrofitexm.adapter.PostAdapter
import com.darasoylu.retrofitexm.model.Post
import com.darasoylu.retrofitexm.repository.PostRepository

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { MainViewModel() }
    private val postAdapter by lazy { PostAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)

        //viewModel.getPost()

        /*
        with(findViewById<RecyclerView>(R.id.recyclerView)) {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        val options: HashMap<String, String> = HashMap()
        options["_sort"] = "id"
        options["_order"] = "desc"

        viewModel.getCustomPosts2(2, options)
        viewModel.myResponse4.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    postAdapter.setData(it)
                }
            } else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
         */

        /*
        activity_main.xml
        findViewById<Button>(R.id.button).setOnClickListener {
            val myNumber = findViewById<TextView>(R.id.editTextNumber).text.toString()
            viewModel.getCustomPosts2(myNumber.toInt(), options)
            viewModel.myResponse4.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    findViewById<TextView>(R.id.textTitle).text = response.body().toString()
                    response.body()?.forEach {
                        Log.i("Response", it.userId.toString())
                        Log.i("Response", it.id.toString())
                        Log.i("Response", it.title)
                        Log.i("Response", it.body)
                        Log.i("Response", "----------------------")
                    }
                } else {
                    findViewById<TextView>(R.id.textTitle).text = response.code().toString()
                }
            })
        }
        */

        //val myPost = Post(2, 3, "Test_title", "Test_body")
        //viewModel.pushPost(myPost)
        viewModel.pushPost2(2, 3, "Test_title", "Test_body")
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.i("Response", response.body().toString())
                    Log.i("Response", response.code().toString())
                    Log.i("Response", response.message())
                }
            } else {
                Toast.makeText(this, response.code().toString(), Toast.LENGTH_SHORT).show()
            }
        })

        /*
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.i("Response", response.body().toString())
                    Log.i("Response", response.code().toString())
                    Log.i("Response", response.headers().toString())
                }
            } else {
                Toast.makeText(this, response.code().toString(), Toast.LENGTH_SHORT).show()
            }
        })
         */

    }
}