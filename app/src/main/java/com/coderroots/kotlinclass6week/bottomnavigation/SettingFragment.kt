package com.coderroots.kotlinclass6week.bottomnavigation

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.coderroots.kotlinclass6week.R
import com.coderroots.kotlinclass6week.databinding.FragmentSettingBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SettingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingFragment : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var binding : FragmentSettingBinding


    var getPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted->
        if(isGranted){
            Toast.makeText(requireContext(),"Permission Granted",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireContext(),"Permission Denied",Toast.LENGTH_SHORT).show()
        }


    }

    var getImage = registerForActivityResult(ActivityResultContracts.GetContent()){  uri->
        binding.ivImage.setImageURI(uri)


    }


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
        binding = FragmentSettingBinding.inflate(layoutInflater)

        binding.btnGallery.setOnClickListener {
            if(ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                println("Congratulation Gallery")
                getImage.launch("image/*")
            }else{
                getPermission.launch(Manifest.permission.READ_EXTERNAL_STORAGE)

            }

            //Customer => customerName, customerContact, customerMail;
            // Stock => image, stockName, quantity, perItemPrice;
            // Bill => CustomerName, totalBill, { stock,stock };


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
         * @return A new instance of fragment SettingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}