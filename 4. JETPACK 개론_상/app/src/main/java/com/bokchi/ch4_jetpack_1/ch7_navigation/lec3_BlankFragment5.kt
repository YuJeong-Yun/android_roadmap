package com.bokchi.ch4_jetpack_1.ch7_navigation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.bokchi.ch4_jetpack_1.R


// 첫번째로 Fragment5에서 backButton 눌렀을 때 Fragment1로 이동
class lec3_BlankFragment5 : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // 뒤로 가기 클릭 시 행동
        // but 이렇게 하면 해당하는 id의 action 실행 시키고
        // 거기서 뒤로가기하면 다시 여기로 돌아옴
        // ==> nav.xml에서 4to5 action에 attribute의 popUpTo에 fragment1 넣어주면 됨
//        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//                Log.d("BlankFragment5", "pressed")
//                view?.let {
//                    Navigation.findNavController(it)
//                        .navigate(R.id.action_lec3_BlankFragment5_to_lec2_BlankFragment1)
//                }
//            }
//
//        }
//        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lec3__blank5, container, false)
    }

}