package com.projectpertama.navsample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.projectpertama.navsample.R
import com.projectpertama.navsample.model.Person


class FirstFragment : Fragment() {

    private lateinit var etNama : EditText
    private lateinit var btnNavigate : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etNama = view.findViewById(R.id.etNama)
        btnNavigate = view.findViewById(R.id.btnNext)



        btnNavigate.setOnClickListener {
            val biodata = Person(etNama.text.toString(),null,"","",)
            val nama = etNama.text.toString()
            if(nama.isEmpty()){
                Toast.makeText(requireActivity(),"Silahkan isi nama terlebih dahulu",Toast.LENGTH_SHORT).show()
            }else{
                findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(biodata))
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)




    }
}