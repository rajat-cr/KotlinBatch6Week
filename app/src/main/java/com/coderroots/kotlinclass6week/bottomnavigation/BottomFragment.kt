package com.coderroots.kotlinclass6week.bottomnavigation

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment
import com.coderroots.kotlinclass6week.R
import com.coderroots.kotlinclass6week.databinding.FragmentBottomBinding
import java.security.Permission

/**
 * A simple [Fragment] subclass.
 * Use the [BottomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding : FragmentBottomBinding
    var imageUri : Uri? = null


    var galleryPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
        if(isGranted){
            Toast.makeText(requireContext(),"Permission Granted",Toast.LENGTH_SHORT).show()

        }else {
            Toast.makeText(requireContext(), "Permission Not Granted", Toast.LENGTH_SHORT).show()
        }
    }
    var galleryPick = registerForActivityResult(ActivityResultContracts.GetContent()){uri->
        uri.let {
          //  imageUri = it
            binding.ivImage.setImageURI(it)
        }

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
        binding = FragmentBottomBinding.inflate(layoutInflater)
        binding.ivImage.setImageURI(imageUri)
        binding.btnImage.setOnClickListener {
            if(ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.READ_MEDIA_IMAGES) == PackageManager.PERMISSION_GRANTED){
                println("Check SelectedImage: $imageUri")
//                binding.ivImage.setImageURI(imageUri)
                galleryPick.launch("image/*")



            }else{
                galleryPermission.launch(Manifest.permission.READ_MEDIA_IMAGES)

            }

        }
        return return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BottomFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BottomFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}