package com.example.carikos2

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale.filter

class HomeFragment : Fragment() {

    private lateinit var rvKos: RecyclerView
    private val dataKos = ArrayList<Kos>()
    val bundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    private val ambilItem: ArrayList<Kos>
        get() {
            val dataPhoto = resources.obtainTypedArray((R.array.data_photo))
            val dataName = resources.getStringArray((R.array.data_name))
            val dataLocation = resources.getStringArray((R.array.data_location))
            val dataDistance = resources.getStringArray((R.array.data_distance))
            val allItem = ArrayList<Kos>()

            for (i in dataName.indices) {
                allItem.add(
                    Kos(
                        dataPhoto.getResourceId(i, -1),
                        dataName[i],
                        dataLocation[i],
                        dataDistance[i]
                    )
                )
            }

            return allItem
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvKos = view.findViewById(R.id.rv_kos)
        rvKos.setHasFixedSize(true)

        //ambil data barang dari string resource
        dataKos.addAll(ambilItem)

        //tentukan tampilan recyclerView mau kayak apa
        rvKos.layoutManager = GridLayoutManager(requireActivity(), 2)

        //deklarasi adapter
        val listProductAdapter = ListKosAdapter(dataKos)

        //kita setting adapter dari RecyclerView
        rvKos.adapter = listProductAdapter


        // BUTTON KE KOS PUTRA/PUTRI/RUMAH TANGGA
        val mSupportFragmentManager = getActivity()?.supportFragmentManager

        val btnKosPutra: ImageButton = view.findViewById(R.id.img_kosPutra)
        btnKosPutra.setOnClickListener {
            bundle.clear()
            bundle.putString(DaftarKosFilterFragment.filterKos, "putra")
            val fragmentdum = DaftarKosFilterFragment()
            fragmentdum.arguments = bundle
            mSupportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, fragmentdum, DaftarKosFilterFragment::class.java.simpleName)
                ?.addToBackStack(null)
                ?.commit()
        }

        val btnKosPutri: ImageButton = view.findViewById(R.id.img_kosPutri)
        btnKosPutri.setOnClickListener {
            bundle.clear()
            bundle.putString(DaftarKosFilterFragment.filterKos, "putri")
            val fragmentdum = DaftarKosFilterFragment()
            fragmentdum.arguments = bundle
            mSupportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, fragmentdum, DaftarKosFilterFragment::class.java.simpleName)
                ?.addToBackStack(null)
                ?.commit()
        }

        val btnKosRT: ImageButton = view.findViewById(R.id.img_kosRT)
        btnKosRT.setOnClickListener {
            bundle.clear()
            bundle.putString(DaftarKosFilterFragment.filterKos, "rt")
            val fragmentdum = DaftarKosFilterFragment()
            fragmentdum.arguments = bundle
            mSupportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, fragmentdum, DaftarKosFilterFragment::class.java.simpleName)
                ?.addToBackStack(null)
                ?.commit()
        }
    }
}