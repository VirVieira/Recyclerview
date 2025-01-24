package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }
        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }
        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)
        }
    }
}

private val contacts = listOf(
    Contact(
        "Virginia",
        "(55) 84 98765432",
        R.drawable.sample1
    ),
    Contact(
        "Mario",
        "(55) 84 256976543",
        R.drawable.sample2
    ),
    Contact(
        "Valeria",
        "(55) 84 98645322",
        R.drawable.sample3
    ),
    Contact(
        "Rodrigo",
        "(55) 84 911876543",
        R.drawable.sample5
    ),
    Contact(
        "Kelly",
        "(55) 84 987654321",
        R.drawable.sample6
    ),
    Contact(
        "Luzimara",
        "(55) 84 98742351",
        R.drawable.sample7
    ),
    Contact(
        "Gustavo",
        "(55) 84 2345678",
        R.drawable.sample8
    ),
    Contact(
        "Francisco",
        "(55) 84 76543723",
        R.drawable.sample12
    ),
    Contact(
        "Cristiano",
        "(55) 84 987321675",
        R.drawable.sample13
    ),
    Contact(
        "Jessica",
        "(55) 84 76543897",
        R.drawable.sample16
    ),
    Contact(
        "Ricardo",
        "(55) 84 97642134",
        R.drawable.sample10
    ),
    Contact(
        "Erica",
        "(55) 84 99875643",
        R.drawable.sample11
    ),
    Contact(
        "Regina",
        "(55) 84 998765321",
        R.drawable.sample4
    ),
    Contact(
        "Miguel",
        "(55) 84 976342765",
        R.drawable.sample9
    ),
    Contact(
        "Daniel",
        "(55) 84 25496787",
        R.drawable.sample14
    ),
    Contact(
        "Joelma",
        "(55) 84 998712345",
        R.drawable.sample15
    )
)