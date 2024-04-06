package com.example.imagefinder.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagefinder.databinding.ActivityPlagiarismBinding
import com.example.imagefinder.model.Data
import com.example.imagefinder.model.ReverseSearchImageModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlagiarismActivity : AppCompatActivity() {
    private var binding: ActivityPlagiarismBinding? = null
    lateinit var viewModel: ImageViewModel
    private var reverseSearchImages: ReverseSearchImageModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlagiarismBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = ViewModelProvider(this)[ImageViewModel::class.java]

        binding?.btnSearch?.setOnClickListener()
        {
            val value: String = binding?.etImage?.text.toString()
            viewModel.getReverseSearchImage(value!!)

            viewModel.reverseSearchImageResponse.observe(this) {
                if (it != null) {
                    reverseSearchImages = it
                    Log.e("setObservers", "$it")
                    setUpImagesRv()
                }
            }
        }
    }

    private fun setUpImagesRv() {
        var reverseImagesList : MutableList<Data> = arrayListOf()

        for (i in 0..reverseSearchImages?.data?.size!! -1)
        {
            try {
                reverseImagesList.add(reverseSearchImages?.data!![i])
            } catch (e:Exception){
                Log.e("error",e.toString())
            }
        }

        val adapterImages = ReverseSearchAdapter(this,reverseImagesList)

        try {
            binding?.btnSearch?.visibility=View.GONE
            binding?.rvReverse?.visibility=View.VISIBLE
            binding?.rvReverse?.layoutManager= LinearLayoutManager(this)
            binding?.rvReverse?.adapter=adapterImages
        }catch  (e:Exception){
            Log.e("Error",e.toString())
        }
    }
}


