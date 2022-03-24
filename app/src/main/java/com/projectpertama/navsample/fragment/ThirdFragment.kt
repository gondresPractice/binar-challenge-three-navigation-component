package com.projectpertama.navsample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.projectpertama.navsample.R
import com.projectpertama.navsample.model.Person


class ThirdFragment : Fragment() {

    private lateinit var  etNama : EditText
    private lateinit var  etUmur : EditText
    private lateinit var  etAlamat : EditText
    private lateinit var  etStatus : EditText
    private lateinit var btnNext : Button

    private val arguments : ThirdFragmentArgs by navArgs()
    private lateinit var tvName : TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etNama = view.findViewById(R.id.etNama)
        etUmur = view.findViewById(R.id.etUmur)
        etAlamat = view.findViewById(R.id.etTempat)
        etStatus = view.findViewById(R.id.etStatus)
        btnNext = view.findViewById(R.id.btnNext)

        val name = arguments.thirdBiodata.name
        val umur = arguments.thirdBiodata.umur
        val alamat = arguments.thirdBiodata.alamat
        val status = arguments.thirdBiodata.status

        etNama.setText(name)
        etUmur.setText(umur.toString())
        etAlamat.setText(alamat)
        etStatus.setText(status)


        btnNext.setOnClickListener {
            val nama = etNama.text.toString()
            val umur = etUmur.text.toString()
            val alamat = etAlamat.text.toString()
            val status = etStatus.text.toString()


            if(nama.isEmpty() || umur.isEmpty() || alamat.isEmpty() || status.isEmpty()){

                Toast.makeText(requireActivity(),"Isi kolom yang kosong terlebih dahulu", Toast.LENGTH_SHORT).show()

            }else{
                val biodata = Person(nama,Integer.parseInt(umur),alamat,status)
                findNavController().navigate(ThirdFragmentDirections.actionThirdFragmentToSecondFragment(biodata))
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false)
    }
}