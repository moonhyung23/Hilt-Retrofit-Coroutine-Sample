package com.example.a220411_retrofit_openapi.adapter

import android.view.LayoutInflater

import androidx.recyclerview.widget.RecyclerView


import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.a220411_retrofit_openapi.databinding.RecyclerviewItemBinding
import com.example.a220411_retrofit_openapi.domain.model.Movie
import com.example.a220411_retrofit_openapi.domain.model.PostModel


class MyAdapter() :
    ListAdapter<Movie, MyAdapter.MyViewHolder>(MyDiffCallback()) {
    private var items_movie = emptyList<Movie>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items_movie[position]
        holder.setItemMovie(item)
    }

    fun setDataMovie(items: List<Movie>) {
        this.items_movie = items
        submitList(items)
    }

    class MyViewHolder(private val binding: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setItemMovie(item: Movie) {
            binding.boxOfficeList = item
        }

    }


}

class MyDiffCallback : DiffUtil.ItemCallback<Movie>() {
    //비교 대상인 두 객체가 동일 객체인지를 판정하는 메서드
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        // === 사용
        return oldItem === newItem
    }

    //두 객체의 아이템이 동일한 데이터를 갖는 판정하기위에 ==(equals)사용
    //Monster가 데이터 클래스이기 때문에 정의에 따라 "=="기호도 가능
    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}