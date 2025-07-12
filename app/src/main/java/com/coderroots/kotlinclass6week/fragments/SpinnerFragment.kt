package com.coderroots.kotlinclass6week.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.coderroots.kotlinclass6week.R
import com.coderroots.kotlinclass6week.databinding.FragmentSpinnerBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SpinnerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpinnerFragment : Fragment() {


    // Declaration
    lateinit var binding :FragmentSpinnerBinding

    var spinnerData = arrayListOf<StudentModel>()
    lateinit var arrayAdapter : ArrayAdapter<StudentModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Initialization
        binding = FragmentSpinnerBinding.inflate(layoutInflater)
        arrayAdapter = ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1,spinnerData)
        binding.spinnner.adapter = arrayAdapter


        spinnerData.add(StudentModel(name = "Inderjot", contactNo = "1234567890", rollNo = "1"))
        spinnerData.add(StudentModel(name = "Sapna", contactNo = "1234567890", rollNo = "1"))
        spinnerData.add(StudentModel(name = "Rudhar", contactNo = "1234567890", rollNo = "1"))

        binding.spinnner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
             // binding.tvText.text = spinnerData[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

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
         * @return A new instance of fragment SpinnerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SpinnerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}