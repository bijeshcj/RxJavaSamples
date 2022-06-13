package com.bijesh.myrxapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bijesh.myrxapplication.databinding.FragmentHomeRxBinding
import com.google.android.material.snackbar.Snackbar

class HomeRxFragment : Fragment() {

    private var _binding: FragmentHomeRxBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeRxBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOperatos.setOnClickListener onClick@{
//            Snackbar.make(binding.constraintLayoutRxHome,"Pressed",Snackbar.LENGTH_LONG
//            ).show()
            findNavController().navigate(R.id.action_homeRxFragment_to_operatorFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}