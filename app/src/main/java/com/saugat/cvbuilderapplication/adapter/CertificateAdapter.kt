package com.saugat.cvbuilderapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saugat.cvbuilderapplication.databinding.RowCertificateBinding
import com.saugat.cvbuilderapplication.pojo.Certification

class CertificateAdapter(
    private val certificationList: MutableList<Certification> = mutableListOf()
) : RecyclerView.Adapter<CertificateAdapter.CertificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CertificationViewHolder {
        val itemBinding =
            RowCertificateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CertificationViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CertificationViewHolder, position: Int) {
        holder.bind(certificationList[position])
    }

    override fun getItemCount(): Int = certificationList.size

    inner class CertificationViewHolder(private val binding: RowCertificateBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(certification: Certification) {
            binding.certificateNameTextView.text = certification.name
            Glide.with(binding.root.context).load(certification.logo).into(binding.logoImageView)
        }
    }
}