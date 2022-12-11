package com.saugat.cvbuilderapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saugat.cvbuilderapplication.databinding.RowEducationBinding
import com.saugat.cvbuilderapplication.pojo.Education

class EducationAdapter(
    private val educationList: MutableList<Education> = mutableListOf()
) : RecyclerView.Adapter<EducationAdapter.EducationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        val itemBinding =
            RowEducationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EducationViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        holder.bind(educationList[position])
    }

    override fun getItemCount(): Int = educationList.size

    inner class EducationViewHolder(private val binding: RowEducationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(education: Education) {
            binding.collegeNameTextView.text = education.collegeName
            binding.programNameTextView.text = education.program

            Glide.with(binding.root.context).load(education.logo).into(binding.logoImageView)
        }
    }
}