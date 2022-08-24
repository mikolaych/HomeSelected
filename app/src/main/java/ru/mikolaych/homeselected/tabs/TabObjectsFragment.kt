package ru.mikolaych.homeselected.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ru.mikolaych.homeselected.R
import ru.mikolaych.homeselected.data.Database
import ru.mikolaych.homeselected.databinding.FragmentTabObjectsBinding
import ru.mikolaych.homeselected.models.ObjectModel
import ru.mikolaych.homeselected.repositories.ObjectRepository
import ru.mikolaych.homeselected.viewModels.ObjectFactory
import ru.mikolaych.homeselected.viewModels.ObjectViewModel

class TabObjectsFragment : Fragment() {

    private var binding: FragmentTabObjectsBinding? = null
    private var objectRepository: ObjectRepository? = null
    private var objectViewModel: ObjectViewModel? = null
    private var objectFactory: ObjectFactory? = null
    private var objectAdaptor: ObjectAdaptor? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab_objects, container, false)

        val objectDao = Database.getInstance((context as FragmentActivity).application).objectDao
        objectRepository = ObjectRepository(objectDao)
        objectFactory = ObjectFactory(objectRepository!!)
        objectViewModel = ViewModelProvider(this, objectFactory!!).get(ObjectViewModel::class.java)
        initRecyclerObjects()

        binding?.deleteAllObjects?.setOnClickListener(View.OnClickListener {
            objectViewModel?.deleteAllObjects()
        })

        return binding?.root
    }

    private fun initRecyclerObjects(){
        binding?.recyclerObjects?.layoutManager = LinearLayoutManager(context)
        objectAdaptor = ObjectAdaptor({objectModel:ObjectModel->deleteObject(objectModel)},
            {objectModel: ObjectModel ->editObject(objectModel)})
        binding?.recyclerObjects?.adapter = objectAdaptor

        displayObjects()
    }

    private fun displayObjects(){
        objectViewModel?.products?.observe(viewLifecycleOwner, Observer {
            objectAdaptor?.setList(it)
            objectAdaptor?.notifyDataSetChanged()
        })
    }

    private fun deleteObject(productModel:ObjectModel) {
        objectViewModel?.deleteObject(productModel)
    }

    private fun editObject(objectModel:ObjectModel) {
        val panelEditObject = PanelEditObject()
        val parameters = Bundle()
        parameters.putString("idProduct", objectModel.id.toString())
        parameters.putString("categoryObject", objectModel.category)
        parameters.putString("cityObject", objectModel.city)
        parameters.putString("streetObject", objectModel.street)
        parameters.putString("houseObject", objectModel.house)
        parameters.putString("flatObject", objectModel.flat)
        parameters.putString("squareObject", objectModel.square)
        parameters.putString("floorObject", objectModel.floor)
        parameters.putString("floorInHouseObject", objectModel.floorHouse)
        parameters.putString("priceObject", objectModel.price)
        parameters.putString("phoneObject", objectModel.phone)
        parameters.putString("contactNameObject", objectModel.contactName)
        parameters.putString("repairObject", objectModel.repair)
        parameters.putString("commentObject", objectModel.commentaries)
        parameters.putString("roomNumberObject", objectModel.roomNumber)
        panelEditObject.arguments = parameters


        panelEditObject.show((context as FragmentActivity).supportFragmentManager, "editObject")
    }




}