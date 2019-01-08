package com.example.harry.facialabsence

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.View
import android.widget.LinearLayout
import com.example.harry.facialabsence.Model.Pelajaran
import com.example.harry.facialabsence.controller.adapter.ScheduleAdapter
import kotlinx.android.synthetic.main.activity_landing_apps.*


class LandingApps : AppCompatActivity() {


    private lateinit var activity: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_apps)



        activity = this

        toolbar.title = ""



        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
            }
        })


    }


    override fun onResume() {
        super.onResume()


        var data: MutableList<Pelajaran> = mutableListOf()



        data.add(Pelajaran("08:00", "11:00", "ERP A", "301A"))
        data.add(Pelajaran("11:00", "13:00", "Pancasila B", "301A"))
        data.add(Pelajaran("13:00", "15:00", "PBO D", "301A"))
        data.add(Pelajaran("15:00", "17:00", "Algoritma D", "301A"))



        schedule_rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        schedule_rv.adapter = ScheduleAdapter(data, this)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


}
