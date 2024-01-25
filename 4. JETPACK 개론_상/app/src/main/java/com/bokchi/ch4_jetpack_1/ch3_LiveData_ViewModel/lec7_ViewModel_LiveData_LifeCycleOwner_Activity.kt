package com.bokchi.ch4_jetpack_1.ch3_LiveData_ViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bokchi.ch4_jetpack_1.R
import com.bokchi.ch4_jetpack_1.databinding.ActivityLec7ViewModelLiveDataLifeCycleOwnerBinding

/**
 *  LiveData + DataBinding + ViewModel
 */
class lec7_ViewModel_LiveData_LifeCycleOwner_Activity : AppCompatActivity() {


    private lateinit var binding: ActivityLec7ViewModelLiveDataLifeCycleOwnerBinding
    private lateinit var viewModel: Lec7ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_lec7_view_model_live_data_life_cycle_owner
        )
        viewModel =  ViewModelProvider(this).get(Lec7ViewModel::class.java)
        binding.vm = viewModel
        binding.lifecycleOwner = this // view에서 liveData 사용할 때 같이 사용

        binding.next.setOnClickListener {
            viewModel.getNextData()
        }


    }
}