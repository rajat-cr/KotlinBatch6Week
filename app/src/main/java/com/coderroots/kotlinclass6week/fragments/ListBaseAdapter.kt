package com.coderroots.kotlinclass6week.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.coderroots.kotlinclass6week.R

class ListBaseAdapter(var studentList : ArrayList<StudentModel>) : BaseAdapter() {
//var studentList : ArrayList<StudentModel>

    override fun getCount(): Int {
        return studentList.size
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 1L
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.base_view,parent,false)
        var name = view.findViewById<TextView>(R.id.tvName)
        var rollNo = view.findViewById<TextView>(R.id.tvRollNo)
        var contact = view.findViewById<TextView>(R.id.tvContact)

        name.text = studentList[position].name
        rollNo.text  = studentList[position].rollNo
        contact.text = studentList[position].contactNo


        return view



    }

}