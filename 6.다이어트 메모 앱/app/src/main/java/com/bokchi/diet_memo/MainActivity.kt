package com.bokchi.diet_memo

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.bokchi.diet_memo.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class MainActivity : AppCompatActivity() {

    val dataModelList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //////////////////// 데이터베이스에서 데이터 읽기 ////////////////////
        // 데이터 읽어서 리스트뷰로 화면에 뿌려줌
        val database = Firebase.database
        val myRef = database.getReference("myMemo")

        val listView = findViewById<ListView>(R.id.mainLV)
        val adapter_list = ListViewAdapter(dataModelList)
        listView.adapter = adapter_list

        myRef.child(Firebase.auth.currentUser!!.uid) // 해당하는 유저의 데이터만 가져옴
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) { // snapshot에 데이터 모두 담겨있음
                    // 데이터가 누적되므로 초기화시키고 다시 db에서 불러와서 저장
                    dataModelList.clear()

                    // 화면에 저장된 목록 보여주기 위해 db에서 데이터 가져와서 dateModelList에 저장
                    for (dataModel in snapshot.children) { // snapshot에서 데이터 하나씩 꺼냄
                        Log.d("Data", dataModel.toString())
                        dataModelList.add(dataModel.getValue(DataModel::class.java)!!)
                    }
                    // 어댑터를 새로 만들어줌
                    // => dataModelList에 값을 넣은 후에 출력시켜줘야 하므로
                    adapter_list.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        //////////////////// 글쓰기 아이콘 클릭 시 다이어로그 띄우기 ////////////////////
        val writeButton = findViewById<ImageView>(R.id.writeBtn)
        writeButton.setOnClickListener {

            val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("운동 메모 다이얼로그")

            val mAlertDialog = mBuilder.show()

            // 다이어로그에서 날짜 선택 버튼 찾아오기
            val DateSelectBtn = mAlertDialog.findViewById<Button>(R.id.dateSelectBtn)
            var dateText = "" // db에 저장하기 위해 날짜 데이터 변수에 담아둠

            DateSelectBtn?.setOnClickListener {
                val today = GregorianCalendar()
                val year: Int = today.get(Calendar.YEAR)
                val month: Int = today.get(Calendar.MONTH)
                val date: Int = today.get(Calendar.DATE)

                // 달력 띄우는 문법
                val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet( // 날짜 선택하면 함수 실행
                        view: DatePicker?,
                        year: Int,
                        month: Int,
                        dayOfMonth: Int
                    ) {
                        Log.d("MAIN", "${year}, ${month + 1}, ${dayOfMonth}")
                        // 날짜 선택 버튼 값을 선택한 날짜 값으로 변경
                        DateSelectBtn.setText("${year}, ${month + 1}, ${dayOfMonth}")

                        dateText = "${year}, ${month + 1}, ${dayOfMonth}"
                    }

                }, year, month, date)
                dlg.show()
            }

            //////////////////// 데이터베이스 저장하는 부분 ////////////////////
            // 저장하기 버튼 클릭시
            val saveBtn = mAlertDialog.findViewById<Button>(R.id.saveBtn)
            saveBtn?.setOnClickListener {
                // db에 저장할 메모 입력값 가져오기
                val healMemo = mAlertDialog.findViewById<EditText>(R.id.healthMemo)?.text.toString()

                val database = Firebase.database
                val myRef = database.getReference("myMemo").child(Firebase.auth.currentUser!!.uid) // 유저의 uid 기반으로 데이터 저장

                val model = DataModel(dateText, healMemo)

                // db에 데이터 저장하는 부분
                myRef
                    .push()
                    .setValue(model)

                // 다이어로그 닫기
                mAlertDialog.dismiss()

            }

        }

    }

}