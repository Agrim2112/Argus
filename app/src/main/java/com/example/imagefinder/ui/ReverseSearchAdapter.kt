package com.example.imagefinder.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagefinder.databinding.ItemReverseBinding
import com.example.imagefinder.model.Data

class ReverseSearchAdapter(private val context: Context, private val reverseImagesList: MutableList<Data>) : RecyclerView.Adapter<ReverseSearchAdapter.ViewHolder>() {
    lateinit var viewModel3: ImageViewModel3
    class ViewHolder(binding: ItemReverseBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvTitle = binding?.tvTitle
        val tvDomain = binding?.tvDomain
        val tvLink = binding?.tvLink
        val ivImage = binding?.ivActor
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemReverseBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return reverseImagesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = reverseImagesList[position]

        holder.itemView.setOnClickListener(){
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(model.link))
            context.startActivity(intent)
        }

//        viewModel3.getDeepfake("Write a copyright strike mail on the link and the domain"+model.link+"and notify them for the same. Write the mail")
//
//        viewModel3.promptResponse.observe(curr)
//            if(it!=null)
//            {
//                Log.e("setObservers", "${it.choices[0].message}")
//            }
//        }

        holder?.tvTitle?.text = model.title
        holder?.tvDomain?.text = model.domain
        holder?.tvLink?.text = model.link
        Glide.with(context)
            .load(model.image)
            .into(holder?.ivImage!!)
    }

}
