package com.bokchi.coco.view.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import com.bokchi.coco.databinding.ActivityIntroBinding
import com.bokchi.coco.view.main.MainActivity
import timber.log.Timber

/**
 *  Splash 화면 만들기
 *  기존 방식 : handler 이용 -> 3초 뒤에 다른액티비(MainActivity로 이동)
 *  Splash Screen 을 이용 -> https://developer.android.com/develop/ui/views/launch/splash-screen
 *      theme.xml 에서 splash 관련 설정 지정
 *      AndroidManifest.xml 에서 인트로 액티비티에 android:theme로 지정
 */
class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding
    private val viewModel: IntroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        // 인트로 액티비티에 아래 코드 추가
        installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.d("onCreate")

        viewModel.checkFirstFlag()
        // dataStore에서 값을 가져오는 게 비동기식으로 실행되므로, observe를 통해 실행되도록 했음
        viewModel.first.observe(this, Observer {
            if (it) {
                // 처음 접속하는 유저가 아님
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                // 처음 접속하는 유저
                binding.animationView.visibility = View.INVISIBLE
                binding.fragmentContainerView.visibility = View.VISIBLE
            }
        })
    }
}