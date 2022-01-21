package com.example.grocerylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.example.grocerylist.databinding.FragmentGroceryListBinding


class GroceryListFragment : Fragment() {
    private var _binding: FragmentGroceryListBinding? = null
    private val binding get() = _binding!!
    private var currentIndex:Int = 0
    private var itemsList: MutableList<String> = mutableListOf("","","","","")
    private lateinit var textList: List<TextView>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGroceryListBinding.inflate(inflater,container,false)
        val rootView = binding.root
        val args = GroceryListFragmentArgs.fromBundle(requireArguments())

        textList =  listOf(binding.textView14,binding.textView15,binding.textView16,binding.textView12,binding.textView13)

        binding.Welcome.text = binding.Welcome.text.toString() + args.name
        binding.add.setOnClickListener() {
            val action = GroceryListFragmentDirections.actionGroceryListFragmentToChooseItemFragment()
            rootView.findNavController().navigate(action)
        }
        setFragmentResultListener("requestKey"){requestKey, bundle ->
                val result = bundle.getString("bundleKey")
                if(currentIndex<5) {
                    itemsList.set(currentIndex, result.toString())
                    currentIndex++
                }
            for((index, eachView) in textList.withIndex()){
                eachView.text = itemsList[index]
            }
        }
        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}