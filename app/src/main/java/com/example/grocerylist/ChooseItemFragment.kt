package com.example.grocerylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.example.grocerylist.databinding.FragmentChooseItemBinding

class ChooseItemFragment : Fragment() {
    private var _binding: FragmentChooseItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChooseItemBinding.inflate(inflater,container,false)
        val rootView = binding.root



        val allButtons: List<View> = listOf(binding.button2,binding.button3,binding.button4,binding.button5,binding.button6,binding.button7,binding.button8,binding.button9)
        var item = ""
        for (button in allButtons){
            button.setOnClickListener{view->
                when (view){
                    binding.button2 -> item = binding.button2.text.toString()
                    binding.button3 -> item = binding.button3.text.toString()
                    binding.button4 -> item = binding.button4.text.toString()
                    binding.button5 -> item = binding.button5.text.toString()
                    binding.button6 -> item = binding.button6.text.toString()
                    binding.button7 -> item = binding.button7.text.toString()
                    binding.button8 -> item = binding.button8.text.toString()
                    binding.button9 -> item = binding.button9.text.toString()
                }
                setFragmentResult("requestKey", bundleOf("bundleKey" to item))
                rootView.findNavController().navigateUp()
            }
        }

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}