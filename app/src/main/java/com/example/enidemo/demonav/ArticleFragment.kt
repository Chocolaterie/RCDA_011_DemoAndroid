package com.example.enidemo.demonav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.enidemo.R
import com.example.enidemo.databinding.FragmentArticleBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ArticleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArticleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var myFragmentView = DataBindingUtil.inflate<FragmentArticleBinding>(inflater, R.layout.fragment_article, container, false)

        // Naviguer sur un autre fragment dans un fragment
        // requireActivity().findNavController(R.id.myNavHost).navigate(R.id.action_homeFragment_to_articleFragment)
        
        // Inflate the layout for this fragment
        return myFragmentView.root;
    }
}