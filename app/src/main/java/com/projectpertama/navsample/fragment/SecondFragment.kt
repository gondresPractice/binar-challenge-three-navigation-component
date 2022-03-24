package com.projectpertama.navsample.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.projectpertama.navsample.R
import com.projectpertama.navsample.model.Person


class SecondFragment : Fragment() {


    private lateinit var btnNext : Button
    private lateinit var tvNama : TextView
    private lateinit var tvUmur : TextView
    private lateinit var tvAlamat : TextView
    private lateinit var tvStatus : TextView
    private val arguments : SecondFragmentArgs by navArgs()
    private val argumentsParcel : ThirdFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnNext = view.findViewById(R.id.btnNext)
        tvNama = view.findViewById(R.id.tvNama)
        tvUmur = view.findViewById(R.id.tvUsia)
        tvAlamat = view.findViewById(R.id.tvAlamat)
        tvStatus = view.findViewById(R.id.tvPekerjaan)

        val nama = arguments.biodata.name
        val umur = arguments.biodata.umur
        val alamat = arguments.biodata.alamat;
        val status = arguments.biodata.status;


        if (umur == null || alamat == null || status == null){
            tvUmur.setText("Umur belum di input")
            tvAlamat.setText("Alamat belum di input")
            tvStatus.setText("Status belum di input")
            btnNext.setText("Input Data")
        }else if (umur != null) {
            if (umur %2 == 0){
                tvNama.setText(nama)
                tvUmur.setText("Umur anda $umur yang berarti genap")
                tvAlamat.setText(alamat)
                tvStatus.setText(status)
                btnNext.setText("Ubah Data")
            }else{
                tvNama.setText(nama)
                tvUmur.setText("Umur anda $umur yang berarti ganjil")
                tvAlamat.setText(alamat)
                tvStatus.setText(status)
                btnNext.setText("Ubah Data")
            }
        }
        tvNama.setText(nama)

        btnNext.setOnClickListener {
            val biodata = Person(nama,umur,alamat,status)
            findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToThirdFragment(biodata))
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }
}