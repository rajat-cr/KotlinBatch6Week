package com.coderroots.kotlinclass6week

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar.LayoutParams
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.coderroots.kotlinclass6week.databinding.ActivityAlertMessagesBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar

class AlertMessagesActivity : AppCompatActivity() {
    lateinit var binding : ActivityAlertMessagesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAlertMessagesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnToast.setOnClickListener {
            Toast.makeText(this,"This is Alert Message",Toast.LENGTH_LONG).show()
        }

        binding.btnSnack.setOnClickListener{
            Snackbar.make(binding.btnSnack,"I'm SnackBar", Snackbar.LENGTH_INDEFINITE)
                .setAction("ok"){
                }.show()
        }
        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Alert!")
                .setMessage("Hello I'm Danger")
                .setPositiveButton("Confirm"){_,_->


                }
                .setNegativeButton("Cancel"){_,_->


                }
                .setNeutralButton("No"){_,_->
                    
                }

                .show()

        }
        binding.btnDialog.setOnClickListener {
            var dialog = Dialog(this)
               dialog.setContentView(R.layout.dialog_design)
            dialog.window?.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            var name = dialog.findViewById<EditText>(R.id.etName)
            var save = dialog.findViewById<Button>(R.id.btnSave)
            name.setText(binding.tvText1.text.toString())
            save.setOnClickListener {
                if(name.text.isEmpty()){
                    name.error = "Enter Your Name"
                }else{
                    binding.tvText1.text = name.text.toString()
                    dialog.dismiss()


                }
            }
            dialog.show()

        }
        binding.btnSheet.setOnClickListener {
            var dialog = BottomSheetDialog(this)
            dialog.setContentView(R.layout.dialog_design)
            dialog.window?.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            var name = dialog.findViewById<EditText>(R.id.etName)
            var save = dialog.findViewById<Button>(R.id.btnSave)
            name?.setText(binding.tvText1.text.toString())
            save?.setOnClickListener {
                if(name?.text!!.isEmpty()){
                    name?.error = "Enter Your Name"
                }else{
                    binding.tvText1.text = name.text.toString()
                    dialog.dismiss()


                }
            }
            dialog.show()

        }

    }
}