package com.example.sharingsessiondevcomu

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    private var userData = ArrayList<UserData>()
    private lateinit var userAdapter: ListUserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(findViewById(R.id.my_toolbar))

        setupUserData()
        userAdapter = ListUserAdapter()
        userData.addAll(setupUserData())
        userAdapter.submitList(userData)
        val recylerView =findViewById<RecyclerView>(R.id.recyler_view)
        recylerView.layoutManager = LinearLayoutManager(this@HomeActivity)
        recylerView.setHasFixedSize(true)
        recylerView.adapter = userAdapter
    }


    fun setupUserData(): ArrayList<UserData> {
        val name = resources.getStringArray(R.array.data_name)
        val fakultas = resources.getStringArray(R.array.data_fakultas)
        val universitas = resources.getStringArray(R.array.data_university)
        val alamat = resources.getStringArray(R.array.data_address)

        var listUserData = ArrayList<UserData>()

        for (i in name.indices) {
             listUserData.add(UserData(name[i], fakultas[i], universitas[i], alamat[i]))
        }

        return listUserData
    }
}