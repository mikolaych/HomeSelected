package ru.mikolaych.homeselected.tabs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.mikolaych.homeselected.R
import ru.mikolaych.homeselected.databinding.ObjectItemBinding
import ru.mikolaych.homeselected.models.ObjectModel

class ObjectAdaptor (private val deleteObject:(ObjectModel)->Unit,
                     private val editObject:(ObjectModel)->Unit) : RecyclerView.Adapter<ObjectAdaptor.ObjectHolder>() {

    private val objectsList = ArrayList<ObjectModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ObjectItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.object_item, parent, false)
        return ObjectHolder(binding)
    }

    override fun getItemCount(): Int {
        return objectsList.size
    }

    override fun onBindViewHolder(holder: ObjectHolder, position: Int) {
        holder.bind(objectsList[position], deleteObject , editObject)
    }

    fun setList(objects: List<ObjectModel>) {
        objectsList.clear()
        objectsList.addAll(objects)

    }


    class ObjectHolder(val binding: ObjectItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            objectModel: ObjectModel,
            deleteObject: (ObjectModel) -> Unit,
            editObject: (ObjectModel) -> Unit

        ) {

            binding.idObject.text = objectModel.id.toString()
            binding.nameObject.text = objectModel.category
            binding.categoryObject.text = objectModel.category
            binding.priceObject.text = objectModel.price.toString()

            binding.editObject.setOnClickListener(View.OnClickListener {
                editObject(objectModel)
            })

            binding.deleteObject.setOnClickListener(View.OnClickListener {
                deleteObject(objectModel)
            })

        }




    }

}
