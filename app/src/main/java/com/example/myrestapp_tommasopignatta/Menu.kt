package com.example.myrestapp_tommasopignatta

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson


class Menu : AppCompatActivity() {
    lateinit var etSearchText: EditText
    lateinit var btnSearch: Button
    lateinit var recyclerViewResults: RecyclerView
    lateinit var movieAdapter: MovieAdapter
    lateinit var requestQueue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etSearchText = findViewById(R.id.etSearchText)
        btnSearch = findViewById(R.id.btnSearch)
        btnSearch.setOnClickListener { search(etSearchText.text.toString()) }

        recyclerViewResults = findViewById(R.id.rvResults)
        recyclerViewResults.layoutManager = LinearLayoutManager(this)
        requestQueue = Volley.newRequestQueue(this)
    }

    private fun search(searchedText: String) {
        val queue: RequestQueue = Volley.newRequestQueue(this)
        val apiKey = "c4656ed2"
        val url = "https://www.omdbapi.com/?s=" + searchedText + "&apikey=" + apiKey

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                if (response.contains("ERROR")) {
                    showToast(response)
                    Log.e("LA MIA RESPONSE", response)
                    return@StringRequest
                }

                Log.d("LA MIA RESPONSE", response)

                val gson = Gson()
                val movieResponse = gson.fromJson(response, MovieResponse::class.java)
                movieAdapter = MovieAdapter(movieResponse.Search)
                recyclerViewResults.adapter = movieAdapter
            },
            { error ->
                error.printStackTrace()
                showToast("ERROR")
            })

        queue.add(stringRequest)
    }

    private fun showToast(msg: String) {
        Toast.makeText(
            this,
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }
}

data class Movie(
    val Title: String,
    val Year: String,
    val imdbID: String,
    val Type: String,
    val Poster: String
)

data class MovieResponse(
    val Search: List<Movie>,
    val totalResults: String,
    val Response: String
)