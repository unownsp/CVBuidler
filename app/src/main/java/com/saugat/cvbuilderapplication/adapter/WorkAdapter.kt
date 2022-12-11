package com.saugat.cvbuilderapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saugat.cvbuilderapplication.databinding.RowWorkBinding
import com.saugat.cvbuilderapplication.pojo.Work

class WorkAdapter(
    private val workList: MutableList<Work> = mutableListOf()
) : RecyclerView.Adapter<WorkAdapter.WorkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkViewHolder {
        val itemBinding = RowWorkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WorkViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: WorkViewHolder, position: Int) {
        holder.bind(workList[position])
    }

    override fun getItemCount(): Int = workList.size

    inner class WorkViewHolder(private val binding: RowWorkBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(work: Work) {

            Glide.with(binding.root.context).load(work.logo).into(binding.logoImageView)
            binding.companyNameTextView.text = work.companyName
            binding.durationTextView.text = work.fromDate + " - " + work.toDate
            binding.locationTextView.text = work.location
            binding.rolesTextView.text = work.roles
        }
    }
}