package ru.mikolaych.homeselected.tabs

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import ru.mikolaych.homeselected.R
import ru.mikolaych.homeselected.data.Database
import ru.mikolaych.homeselected.databinding.FragmentTabPanelBinding
import ru.mikolaych.homeselected.repositories.CategoryRepository
import ru.mikolaych.homeselected.repositories.ObjectRepository
import ru.mikolaych.homeselected.viewModels.CategoryFactory
import ru.mikolaych.homeselected.viewModels.CategoryViewModel
import ru.mikolaych.homeselected.viewModels.ObjectFactory
import ru.mikolaych.homeselected.viewModels.ObjectViewModel


class TabPanelFragment : Fragment(), View.OnClickListener, View.OnKeyListener {

    private var binding:FragmentTabPanelBinding? = null
    private var categoryRepository: CategoryRepository? = null
    private var categoryViewModel: CategoryViewModel? = null
    private var categoryFactory: CategoryFactory? = null

    private var objectRepository: ObjectRepository? = null
    private var objectViewModel: ObjectViewModel? = null
    private var objectFactory: ObjectFactory? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab_panel, container, false)

        val categoryDao = Database.getInstance((context as FragmentActivity).application).categoryDao
        categoryRepository = CategoryRepository(categoryDao)
        categoryFactory = CategoryFactory(categoryRepository!!)
        categoryViewModel = ViewModelProvider(this, categoryFactory!!).get(CategoryViewModel::class.java)

        val objectDao = Database.getInstance((context as FragmentActivity).application).objectDao
        objectRepository = ObjectRepository(objectDao)
        objectFactory = ObjectFactory(objectRepository!!)
        objectViewModel = ViewModelProvider(this,objectFactory!!).get(ObjectViewModel::class.java)

        binding?.enterFloorObject?.setOnKeyListener(this)
        binding?.enterCategoryObject?.setOnKeyListener(this)
        binding?.enterPriceObject?.setOnKeyListener(this)
        binding?.enterCity?.setOnKeyListener(this)
        binding?.enterStreet?.setOnKeyListener(this)
        binding?.enterHouse?.setOnKeyListener(this)
        binding?.enterFlat?.setOnKeyListener(this)
        binding?.enterRoomNumber?.setOnKeyListener(this)
        binding?.enterFloorInHouse?.setOnKeyListener(this)
        binding?.enterComments?.setOnKeyListener(this)
        binding?.enterRepair?.setOnKeyListener(this)
        binding?.enterPhone?.setOnKeyListener(this)
        binding?.enterContactName?.setOnKeyListener(this)
        binding?.enterSquare?.setOnKeyListener(this)



        binding?.buttonAddObject?.setOnClickListener(this)

        binding?.buttonAddCategoryFlats?.setOnClickListener(this)
        binding?.buttonAddCategoryHouses?.setOnClickListener(this)
        binding?.buttonAddCategoryComments?.setOnClickListener(this)

        return binding?.root
    }


    override fun onKey(view: View, i: Int, keyEvent: KeyEvent): Boolean {
        when (view.id) {

            R.id.enterFloorObject -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    binding?.resEnterFloorObject?.text = binding?.enterFloorObject?.text
                    binding?.enterFloorObject?.setText("")
                    return true
                }

            }

            R.id.enterCategoryObject -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    binding?.resEnterCategoryObject?.text = binding?.enterCategoryObject?.text
                    binding?.enterCategoryObject?.setText("")
                    return true
                }

            }

            R.id.enterPriceObject -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    binding?.resEnterPriceObject?.text = binding?.enterPriceObject?.text
                    binding?.enterPriceObject?.setText("")
                    return true
                }

            }
        }

        return false
    }

    override fun onClick(view: View) {

        when(view.id) {

            R.id.buttonAddCategoryFlats -> {

                categoryViewModel?.startInsert(binding?.buttonAddCategoryFlats?.text?.toString()!!)

            }

            R.id.buttonAddCategoryHouses -> {

                categoryViewModel?.startInsert(binding?.buttonAddCategoryHouses?.text?.toString()!!)

            }

            R.id.buttonAddCategoryComments -> {

                categoryViewModel?.startInsert(binding?.buttonAddCategoryComments?.text?.toString()!!)

            }

            R.id.buttonAddObject -> {

                objectViewModel?.startInsert(binding?.resEnterFloorObject?.text?.toString()!!,
                    binding?.resEnterCategoryObject?.text?.toString()!!,
                    binding?.resEnterStreetObject?.text?.toString()!!,
                    binding?.resEnterHouseObject?.text?.toString()!!,
                    binding?.resEnterFlatObject?.text?.toString()!!,
                    binding?.resEnterRoomNumberObject?.text?.toString()!!,
                    binding?.resEnterSquareObject?.text?.toString()!!,
                    binding?.resEnterFloorObject?.text?.toString()!!,
                    binding?.resEnterFloorInHouseObject?.text?.toString()!!,
                    binding?.resEnterPriceObject?.text?.toString()!!,
                    binding?.resEnterRepairObject?.text?.toString()!!,
                    binding?.resEnterPhoneObject?.text?.toString()!!,
                    binding?.resEnterContactNameObject?.text?.toString()!!,
                    binding?.resEnterCommentObject?.text?.toString()!!)

                clearResEnterProduct()

            }

        }

    }

    private fun clearResEnterProduct() {
        binding?.resEnterFloorObject?.setText("")
        binding?.resEnterCategoryObject?.setText("")
        binding?.resEnterPriceObject?.setText("")

    }


}