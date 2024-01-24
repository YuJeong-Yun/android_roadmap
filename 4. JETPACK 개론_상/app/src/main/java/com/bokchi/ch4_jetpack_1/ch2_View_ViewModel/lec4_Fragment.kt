import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bokchi.ch4_jetpack_1.R
import com.bokchi.ch4_jetpack_1.ch2_View_ViewModel.lec4_ViewModel
import com.bokchi.ch4_jetpack_1.databinding.FragmentLec4Binding

class lec4_Fragment : Fragment() {

    private lateinit var binding : FragmentLec4Binding
    // 뷰모델을 직접 생성하지 않고
    //  안드로이드 Jetpack 라이브러리에서 제공하는 확장 함수입니다. 이 함수는 현재 활동(Activity)에 대한 ViewModel을 생성 또는 검색하는 데 사용됩니다.
    private val viewModel : lec4_ViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lec4_, container, false)

        binding.fragmentTest.text = viewModel.getCount().toString()

        return binding.root
    }

}