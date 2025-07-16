package com.coderroots.kotlinclass6week.practiceroomdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coderroots.kotlinclass6week.databinding.PracticeViewBinding
import com.coderroots.kotlinclass6week.fragments.RecyclerAdapter

class DatabaseAdapter(var userList : ArrayList<UserModel>) : RecyclerView.Adapter<DatabaseAdapter.ViewHolder>() {

    class ViewHolder(var binding : PracticeViewBinding) :  RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = PracticeViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.binding.tvName.text = userList[position].userName
        holder.binding.tvContact.text = userList[position].userContact
    }
}