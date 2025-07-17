package com.coderroots.kotlinclass6week.practiceroomdb

import android.app.Dialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar.LayoutParams
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.coderroots.kotlinclass6week.R
import com.coderroots.kotlinclass6week.databinding.ActivityDataBaseBinding
import com.coderroots.kotlinclass6week.databinding.DialogDesignBinding

class DataBaseActivity : AppCompatActivity(), ClickInterface {
    lateinit var binding : ActivityDataBaseBinding
    lateinit var userDatabase : UserDatabase
    lateinit var databaseAdapter: DatabaseAdapter
    var userList = ArrayList<UserModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDataBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userDatabase = UserDatabase.getDatabase(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        databaseAdapter = DatabaseAdapter(userList,this)
        binding.rvList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rvList.adapter = databaseAdapter
        getUserData()

        binding.fabBtn.setOnClickListener {
            var dialog = Dialog(this)
            var dialogBinding = DialogDesignBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)
            dialogBinding.btnSave.setOnClickListener {
                if(dialogBinding.etName.text.toString().isEmpty()){
                    dialogBinding.etName.error = "Enter Name"
                }else if(dialogBinding.etContact.text.toString().isEmpty()){
                    dialogBinding.etName.error = "Enter Contact No"
                }else{
                    var userModel = UserModel(userName = dialogBinding.etName.text.toString(), userContact = dialogBinding.etContact.text.toString())
                    userDatabase.userDao().insertUser(userModel)
                    getUserData()
                    dialog.dismiss()

                }
            }
              dialog.show()
        }
    }

    fun getUserData(){
        userList.clear()
        userList.addAll(userDatabase.userDao().getUserData())
            databaseAdapter.notifyDataSetChanged()
    }

    override fun updateUser(position: Int) {
        var dialog = Dialog(this)
        var dialogBinding = DialogDesignBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)

        dialog.window?.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)

        dialogBinding.etName.setText(userList[position].userName)
        dialogBinding.etContact.setText(userList[position].userContact)
        dialogBinding.btnSave.setOnClickListener {
            if(dialogBinding.etName.text.toString().isEmpty()){
                dialogBinding.etName.error = "Enter Name"
            }else if(dialogBinding.etContact.text.toString().isEmpty()){
                dialogBinding.etName.error = "Enter Contact No"
            }else{
                var userModel = UserModel(
                id = userList[position].id,

                    userName = dialogBinding.etName.text.toString(), userContact = dialogBinding.etContact.text.toString())
                    userDatabase.userDao().userUpdate(userModel)
                getUserData()
                dialog.dismiss()

            }
        }
        dialog.show()
    }

    override fun deleteUser(position: Int) {
       AlertDialog.Builder(this)
           .setTitle("Delete")
           .setMessage("Do you want to Delete?")
           .setPositiveButton("Delete"){_,_->
               userDatabase.userDao().deleteUser(userList[position])
               getUserData()


           }
           .setNegativeButton("No"){_,_->


           }
           .show()
    }
}