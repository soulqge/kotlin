package com.example.recyclev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.xmlpull.v1.sax2.Driver
import androidx.recyclerview.widget.GridLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<driver>
    lateinit var imgId : Array<Int>
    lateinit var namaId : Array<String>
    lateinit var descId : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgId = arrayOf(
            R.drawable.ver,
            R.drawable.per,
            R.drawable.lec,
            R.drawable.sainz,
            R.drawable.pia,
            R.drawable.nor,
            R.drawable.ham,
            R.drawable.rus,
            R.drawable.alo,
            R.drawable.str,
            R.drawable.hulk,
            R.drawable.mag,
            R.drawable.alb,
            R.drawable.sar,
            R.drawable.bot,
            R.drawable.zhou,
            R.drawable.tsu,
            R.drawable.ric,
            R.drawable.gas,
            R.drawable.ocon
        )

        namaId = arrayOf(
            "Max Verstappen",
            "Sergio Perez",
            "Charles Leclerc",
            "Carlos Sainz",
            "Oscar Piastri",
            "Lando Norris",
            "Lewis Hamilton",
            "George Russell",
            "Fernando Alonso",
            "Lance Stroll",
            "Nico Hulkenberg",
            "Kevin Magnussen",
            "Alexander Albon",
            "Logan Sargeant",
            "Valteri Bottas",
            "Zhou Guanyou",
            "Yuki Tsunoda",
            "Daniel Ricciardo",
            "Pierre Gasly",
            "Esteban Ocon"
        )

        descId = arrayOf(
            "Red Bull Racing Honda RBPT",
            "Red Bull Racing Honda RBPT",
            "Scuderria Ferrari",
            "Scuderria Ferrari",
            "Mclaren Mercedes",
            "Mclaren Mercedes",
            "Mercedes",
            "Mercedes",
            "Aston Martin Aramco Mercedes",
            "Aston Martin Aramco Mercedes",
            "Haas Ferrari",
            "Haas Ferrari",
            "Williams Mercedes",
            "Williams Mercedes",
            "Kick Sauber Ferrari",
            "Kick Sauber Ferrari",
            "RB Honda RBPT",
            "RB Honda RBPT",
            "Alpine Renault",
            "Alpine renault"
        )

        newRecyclerView = findViewById(R.id.RecycleList)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<driver>()
        getUserData()


    }

    private fun getUserData(){
        newArrayList.clear() // Clear the existing data
        for (i in imgId.indices){

            val Driver = driver(imgId[i],namaId[i], descId[i])
            newArrayList.add(Driver)
        }
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.adapter = MyListAdapter(newArrayList)
    }

    private fun getGridUserData(){
        newArrayList.clear()

        val layoutManager = GridLayoutManager(this, 2)
        newRecyclerView.layoutManager = layoutManager

        for (i in imgId.indices){

            val Driver = driver(imgId[i],namaId[i], descId[i])
            newArrayList.add(Driver)
        }



        newRecyclerView.adapter = MyGridAdapter(newArrayList)
    }

    private fun getCardUserData(){
        newArrayList.clear()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int){
        when(selectedMode){
            R.id.action_list ->{
                getUserData()
            }
            R.id.action_card-> {

            }
            R.id.action_grid->{
                getGridUserData()
            }
        }
    }

}


