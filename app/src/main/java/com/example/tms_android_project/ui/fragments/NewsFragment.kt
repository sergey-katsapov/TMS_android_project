package com.example.tms_android_project.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tms_android_project.databinding.FragmentNewsBinding
import com.example.tms_android_project.ui.adapters.RecyclerAdapter


class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        //initSpinner()
        //initListView()
        initRecycler()
    }

    private fun initSpinner() {
        //TEST --> Simple example
//        val selected = binding.spinner.selectedItem.toString()
//        Toast.makeText(context, selected, Toast.LENGTH_SHORT).show()

        //TEST --> Adapter
//        val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(requireContext(),
//            com.example.tms_android_project.R.array.cars, R.layout.simple_spinner_item)
//        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        //вызов адаптера
        //binding.spinner.setAdapter(adapter)


        //TEST ---> onItemSelectedListener
//        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                itemSelected: View, selectedItemPosition: Int, selectedId: Long
//            ) {
//                val choose = resources.getStringArray(com.example.tms_android_project.R.array.cars)
//                val toast = Toast.makeText(
//                    requireContext(),
//                    choose[selectedItemPosition], Toast.LENGTH_SHORT
//                )
//                toast.show()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {}
//        }


        //TEST --> выбор выбранного элемента
        //binding.spinner.setSelection(2)
    }

    private fun initListView() {
//        val adapter = ArrayAdapter(
//            requireContext(),
//            R.layout.simple_list_item_1,  resources.getStringArray(com.example.tms_android_project.R.array.cars_list)
//        )
//
//        //прослушивание нажатий
//        binding.listView.setOnItemClickListener(OnItemClickListener { parent, itemClicked, position, id ->
//            Toast.makeText(
//                requireContext(),
//                (itemClicked as TextView).text,
//                Toast.LENGTH_SHORT
//            ).show()
//        })
//
//        // Привяжем массив через адаптер к ListView
//        binding.listView.setAdapter(adapter)
    }

    private fun initRecycler() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = RecyclerAdapter(listOfElements())
        }
    }

    private fun listOfElements(): List<String> {
        val data = mutableListOf<String>()
        (0..100).forEach { i -> data.add("$i item") }
        return data
    }
}