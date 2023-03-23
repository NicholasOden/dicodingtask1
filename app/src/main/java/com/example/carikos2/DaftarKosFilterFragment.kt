package com.example.carikos2

import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DaftarKosFilterFragment : Fragment() {

    companion object{
        var filterKos="putra"
    }
    var hasilFilter:String? = null
    private lateinit var rv: RecyclerView
    private val data = ArrayList<Kos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daftar_kos_filter, container, false)
    }

    private val ambilItem: ArrayList<Kos>
        get() {
            var dataPhoto: TypedArray? = null
            var dataName: Array<String>? = null
            var dataLocation: Array<String>? = null
            var dataDistance: Array<String>? = null
            when(hasilFilter){
                "putra" ->{
                   dataPhoto = resources.obtainTypedArray((R.array.data_photo_putra))
                   dataName = resources.getStringArray((R.array.data_name_putra))
                   dataLocation = resources.getStringArray((R.array.data_location_putra))
                   dataDistance = resources.getStringArray((R.array.data_distance_putra))
                }
                "putri" ->{
                   dataPhoto = resources.obtainTypedArray((R.array.data_photo_putri))
                   dataName = resources.getStringArray((R.array.data_name_putri))
                   dataLocation = resources.getStringArray((R.array.data_location_putri))
                   dataDistance = resources.getStringArray((R.array.data_distance_putri))
                }
                "rt" ->{
                   dataPhoto = resources.obtainTypedArray((R.array.data_photo_rt))
                   dataName = resources.getStringArray((R.array.data_name_rt))
                   dataLocation = resources.getStringArray((R.array.data_location_rt))
                   dataDistance = resources.getStringArray((R.array.data_distance_rt))
                }
            }


            val allItem = ArrayList<Kos>()
            if (dataName != null && dataPhoto != null && dataLocation != null && dataDistance != null) {
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
            }
            return allItem
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hasilFilter = arguments?.getString(filterKos).toString()

        rv = view.findViewById(R.id.rv)
        rv.setHasFixedSize(true)

        //ambil data barang dari string resource
        data.addAll(ambilItem)

        //tentukan tampilan recyclerView mau kayak apa
        rv.layoutManager = GridLayoutManager(requireActivity(),2)
        //di bawah ini pengaturan layout untuk menampilkan list gambar Horisontal
        // rv.layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL, false)

        //deklarasi adapter
        val listProductAdapter = ListKosAdapter(data)

        //kita setting adapter dari RecyclerView
        rv.adapter = listProductAdapter
    }
}