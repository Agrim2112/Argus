import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagefinder.databinding.ItemReverseBinding
import com.example.imagefinder.model.Data
import com.example.imagefinder.model.ReverseSearchImageModel

class ReverseSearchAdapter(private val context: Context, private val reverseImagesList: MutableList<Data>) : RecyclerView.Adapter<ReverseSearchAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemReverseBinding) : RecyclerView.ViewHolder(binding.root){
        val tvTitle=binding?.tvTitle
        val tvDomain=binding?.tvDomain
        val tvLink=binding?.tvLink
        val ivImage = binding?.ivActor
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemReverseBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun getItemCount(): Int {
        return reverseImagesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = reverseImagesList[position]



        holder?.tvTitle?.text=model.title
        holder?.tvDomain?.text=model.domain
        holder?.tvLink?.text=model.link
        Glide.with(context)
            .load(model.image)
            .into(holder?.ivImage!!)

    }

}