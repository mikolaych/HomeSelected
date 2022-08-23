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
import ru.mikolaych.homeselected.databinding.FragmentTabCategoriesBinding
import ru.mikolaych.homeselected.models.CategoryModel
import ru.mikolaych.homeselected.repositories.CategoryRepository
import ru.mikolaych.homeselected.viewModels.CategoryFactory
import ru.mikolaych.homeselected.viewModels.CategoryViewModel


class TabCategoriesFragment : Fragment() {

    private var binding:FragmentTabCategoriesBinding? = null
    private var categoryRepository: CategoryRepository? = null
    private var categoryViewModel: CategoryViewModel? = null
    private var categoryFactory: CategoryFactory? = null
    private var categoryAdapter: CategoryAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab_categories, container, false)

        val categoriesDao = Database.getInstance((context as FragmentActivity).application).categoryDao
        categoryRepository = CategoryRepository(categoriesDao)
        categoryFactory = CategoryFactory(categoryRepository!!)
        categoryViewModel = ViewModelProvider(this, categoryFactory!!).get(CategoryViewModel::class.java)

        initRecyclerCategories()
        displayCategories()

        binding?.deleteAllCategories?.setOnClickListener(View.OnClickListener {
            categoryViewModel?.deleteAll()
        })

        return  binding?.root
    }

    private fun initRecyclerCategories(){
        binding?.recyclerCategories?.layoutManager = LinearLayoutManager(context)
        categoryAdapter = CategoryAdapter({categoryModel: CategoryModel ->deleteCategory(categoryModel)},
            {categoryModel:CategoryModel->editCategory(categoryModel)})
        binding?.recyclerCategories?.adapter = categoryAdapter


    }

    private fun displayCategories(){
        categoryViewModel?.categories?.observe(viewLifecycleOwner, Observer {
            categoryAdapter?.setList(it)
            categoryAdapter?.notifyDataSetChanged()
        })
    }


    private fun deleteCategory(categoryModel:CategoryModel) {
        categoryViewModel?.delete(categoryModel)
    }

    private fun editCategory(categoryModel:CategoryModel) {
        val panelCategory = PanelEditCategory()
        val parameters = Bundle()
        parameters.putString("idCategory", categoryModel.id.toString())
        parameters.putString("nameCategory", categoryModel.name)
        panelCategory.arguments = parameters

        panelCategory.show((context as FragmentActivity).supportFragmentManager, "editCategory")
    }


}