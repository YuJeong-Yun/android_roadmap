package com.example.listview

// MainAcitivy -> Adapter로 데이터 전달할 때
// 단순히 ["a","b","c"] 가 아니라
// 즉 ListViewModel("a","b") 이런식으로 객체를 전달할 때 사용
data class ListViewModel(
    var title: String = "",
    var content: String = ""
)