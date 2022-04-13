package com.example.a220411_retrofit_openapi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.a220411_retrofit_openapi.adapter.MyAdapter
import com.example.a220411_retrofit_openapi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

//Application 클래스의 하위 클래스에 모두
//@AndroidEntryPoint 적기
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var mAdapter: MyAdapter
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModels()
    private val lm by lazy { LinearLayoutManager(applicationContext) } //레이아웃매니저

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecycler()


        //LiveData로 리사이클러뷰 상태변화 관찰
        viewModel.Live_BoxOffice.observe(this) {
            it.let {
                mAdapter.setDataMovie(it)

            }
        }

        /*  //Retrofit 통신 기존코드
          retrofit = Retrofit.Builder()
              .baseUrl(baseUrl)
              .addConverterFactory(GsonConverterFactory.create())
              .build()
          val retrofitInterface = retrofit?.create(
              ApiRetrofit::class.java)
          retrofitInterface?.getBoxOffice(API_KEY, "20200319")!!
              .enqueue(object : Callback<Map<String?, Any?>?> {
                  override fun onResponse(
                      call: Call<Map<String?, Any?>?>,
                      response: Response<Map<String?, Any?>?>,
                  ) {
                      val boxOfficeResult =
                          response.body()?.get("boxOfficeResult") as Map<String, Any>
                      val jsonList: ArrayList<Map<String, Any>> =
                          boxOfficeResult["dailyBoxOfficeList"] as ArrayList<Map<String, Any>>
                      mAdapter = MyAdapter(jsonList!!)
                  }

                  override fun onFailure(call: Call<Map<String?, Any?>?>?, t: Throwable?) {}
              })*/
    }


    private fun initRecycler() {
        //리사이클러뷰 어댑터 객체 생성
        mAdapter = MyAdapter()
        //리사이클러뷰에 어댑터 연결
        binding.rvRecyclerview.adapter = mAdapter
        binding.rvRecyclerview.setHasFixedSize(true)
        //레이아웃 매니저 세팅
        binding.rvRecyclerview.layoutManager = lm
        lm.orientation = LinearLayoutManager.VERTICAL
        //리사이클러뷰 아이템 뷰 구분선 넣기
        val dividerItemDecoration =
            DividerItemDecoration(applicationContext, LinearLayoutManager(this).orientation)
        binding.rvRecyclerview.addItemDecoration(dividerItemDecoration)
    }


}

