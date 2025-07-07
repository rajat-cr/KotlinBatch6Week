package com.coderroots.kotlinclass6week.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.ActionBar.LayoutParams
import com.coderroots.kotlinclass6week.R
import com.coderroots.kotlinclass6week.databinding.DialogDesignBinding
import com.coderroots.kotlinclass6week.databinding.FragmentListViewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListViewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding : FragmentListViewBinding
    lateinit var arrayAdapter: ArrayAdapter<String>
    var list = arrayListOf("Inderjot","Sapna","Kulpdeep","Rudhar","Inderjot","Inderjot","Sapna","Kulpdeep","Rudhar")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListViewBinding.inflate(layoutInflater)
        // arrayList.add() .set. removeAt // arrayAdapter
        arrayAdapter = ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1,list)
        binding.lvList.adapter = arrayAdapter

        binding.lvList.setOnItemClickListener { parent, view, position, id ->
            list.set(position,"Inderjot kaur")
            arrayAdapter.notifyDataSetChanged()
            Toast.makeText(requireActivity(),"${list[position]}", Toast.LENGTH_SHORT).show()
        }

        binding.lvList.setOnItemLongClickListener { parent, view, position, id ->
            list.removeAt(position)
            arrayAdapter.notifyDataSetChanged()
            return@setOnItemLongClickListener true

        }

        binding.fabBtn.setOnClickListener {
            var dialog = Dialog(requireActivity())
            var dialogBinding = DialogDesignBinding.inflate(layoutInflater)
               dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)
            dialogBinding.btnSave.setOnClickListener {
                if(dialogBinding.etName.text.toString().isEmpty()){
                    dialogBinding.etName.error = "Enter Name"
                }else{
                    list.add(dialogBinding.etName.text.toString())
                    arrayAdapter.notifyDataSetChanged()
                    dialog.dismiss()
                }
            }

            dialog.show()
        }



        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListViewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}