package com.example.harry.facialabsence.controller.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.example.harry.facialabsence.Model.Pelajaran
import com.example.harry.facialabsence.Model.Pengajar
import com.example.harry.facialabsence.R
import com.example.harry.facialabsence.ScanFace
import com.example.harry.facialabsence.Utils.UtilHelpers

class ScheduleAdapter(data: List<Pelajaran>, context: Context) : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    private val VIEW_ORDINARY = 0
    private val VIEW_WITH_EXTRA_TEXT_VIEW = 1


    val data = data
    val context = context

    override fun getItemViewType(position: Int): Int {
        val data = data
        if (UtilHelpers.isNowSubject(data.get(position).timeStart, data.get(position).timStop)) {
            return VIEW_WITH_EXTRA_TEXT_VIEW
        } else {
            return VIEW_ORDINARY;
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType === VIEW_WITH_EXTRA_TEXT_VIEW) {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.schedule_item, parent, false)
            val viewHolder = ViewHolder(view)
            return viewHolder
        } else {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.schedule_item_2, parent, false)
            val viewHolder = ViewHolder(view)
            return viewHolder
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.subject?.text = data.get(position).name
        if (UtilHelpers.isNowSubject(data.get(position).timeStart, data.get(position).timStop)) {
            holder.timeStartStop?.text = "Sedang Berlangsung"
            holder.room?.text = "${data.get(position).timeStart} - ${data.get(position).timStop} Ruang ${data.get(position).className}"

            var dataPengajar: MutableList<Pengajar> = mutableListOf()

            dataPengajar.add(Pengajar("YARO", "https://img2.thejournal.ie/inline/2470754/original/?width=428&version=2470754"))
            dataPengajar.add(Pengajar("YARO", "https://img2.thejournal.ie/inline/2470754/original/?width=428&version=2470754"))
            dataPengajar.add(Pengajar("YARO", "https://img2.thejournal.ie/inline/2470754/original/?width=428&version=2470754"))
            dataPengajar.add(Pengajar("YARO", "https://img2.thejournal.ie/inline/2470754/original/?width=428&version=2470754"))
            dataPengajar.add(Pengajar("YARO", "https://img2.thejournal.ie/inline/2470754/original/?width=428&version=2470754"))
            dataPengajar.add(Pengajar("YARO", "https://img2.thejournal.ie/inline/2470754/original/?width=428&version=2470754"))
            dataPengajar.add(Pengajar("YARO", "https://img2.thejournal.ie/inline/2470754/original/?width=428&version=2470754"))
            dataPengajar.add(Pengajar("YARO", "https://img2.thejournal.ie/inline/2470754/original/?width=428&version=2470754"))
            dataPengajar.add(Pengajar("YARO", "https://img2.thejournal.ie/inline/2470754/original/?width=428&version=2470754"))
            dataPengajar.add(Pengajar("YARO", "https://img2.thejournal.ie/inline/2470754/original/?width=428&version=2470754"))
            dataPengajar.add(Pengajar("YARO", "https://img2.thejournal.ie/inline/2470754/original/?width=428&version=2470754"))
            dataPengajar.add(Pengajar("YARO", "https://img2.thejournal.ie/inline/2470754/original/?width=428&version=2470754"))
            dataPengajar.add(Pengajar("YARO", "https://img2.thejournal.ie/inline/2470754/original/?width=428&version=2470754"))
            dataPengajar.add(Pengajar("YARO", "https://img2.thejournal.ie/inline/2470754/original/?width=428&version=2470754"))


            holder.attendantRV!!.adapter = PengajarCircleAdapter(dataPengajar)
            holder.attendantRV!!.layoutManager = LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)
            holder.attendanTv!!.text = "Attendant ( ${dataPengajar.size} )"



            holder.scheduleHadir!!.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    context.startActivity(Intent(context, ScanFace::class.java))
                }
            })

        } else {
            holder.timeStartStop?.text = "${UtilHelpers.compareSubject(data.get(position).timeStart, data.get(position).timStop)}\n${data.get(position).timeStart} - ${data.get(position).timStop}"
            holder.room?.text = "Ruang ${data.get(position).className}"
        }
        var dataPengajar: MutableList<Pengajar> = mutableListOf()

        dataPengajar.add(Pengajar("YARO", "https://img2.thejournal.ie/inline/2470754/original/?width=428&version=2470754"))
        holder.pengajarRV!!.adapter = PengajarCircleAdapter(dataPengajar)
        holder.pengajarRV!!.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val scheduleCard: FrameLayout? = itemView?.findViewById(R.id.schedule_card)
        val scheduleHadir: TextView? = itemView?.findViewById(R.id.schedule_hadir)
        val scheduleAbsen: TextView? = itemView?.findViewById(R.id.schedule_absen)
        val subject: TextView? = itemView?.findViewById(R.id.schedule_subject)
        val timeStartStop: TextView? = itemView?.findViewById(R.id.schedule_time)
        val room: TextView? = itemView?.findViewById(R.id.schedule_room)
        val pengajarRV: RecyclerView? = itemView?.findViewById(R.id.pengajar_cicyle_rv)
        val attendantRV: RecyclerView? = itemView?.findViewById(R.id.attendant_rv)
        val attendanTv: TextView? = itemView?.findViewById(R.id.attendanTv);


    }


}