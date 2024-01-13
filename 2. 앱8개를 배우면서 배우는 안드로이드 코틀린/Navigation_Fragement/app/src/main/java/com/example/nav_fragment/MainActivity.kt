package com.example.nav_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // 1. app/ main_nav(Android Resource File & Resource type = Navigation) 파일 생성
    // 2. activity_main.xml 에서 Design 탭 -> Palette -> NavHostFragment 끌어다 놓기 -> main_nav 선택
    // 3. com.example.nav_fragment/ FristFragment(Fragment(Blank)) 생성 (fragement 필요한 개수만큼 생성)
    // 4. main_nav 에서 Design 탭 -> 왼쪽 상단 New Destination 클릭하면 생성한 프래그먼트들 나옴
    // 5. main_nav 에서 Design 탭 -> 첫 번째 fragment 에서 연결할 fragment에 화살표 생성 -> attribute에서 화살표 id 확인 가능 -> code 탭에서 action 태그 생성됨
    //      -> 해상 id 실행시키면 해당 프래그먼트로 옮겨감
}