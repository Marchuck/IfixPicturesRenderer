package pl.marczak.ifixpicturesrenderer.availablePictures


import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import pl.marczak.ifixpicturesrenderer.R
import java.util.ArrayList


class AvailablePicturesAdapter @JvmOverloads
constructor(dataSet: List<String> = ArrayList())
    : RecyclerView.Adapter<AvailablePicturesAdapter.ViewHolder>() {

    internal var dataSet: List<String>? = java.util.ArrayList()

    interface ClickListener {
        fun onClicked(title: String)
    }

    internal var listener: ClickListener? = null

    init {
        this.dataSet = dataSet
    }

    fun refreshDataset(dataSet: List<String>) {
        this.dataSet = dataSet
        notifyItemRangeChanged(0, itemCount)
        notifyDataSetChanged()
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvailablePicturesAdapter.ViewHolder {
        val v = android.view.LayoutInflater.from(parent.context).inflate(R.layout.drawer_list_item, null, false)
        return AvailablePicturesAdapter.ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AvailablePicturesAdapter.ViewHolder, position: Int) {
        val item = dataSet!![position]
        holder.textView.text = item
        holder.itemView.isClickable = true
        holder.itemView.setOnClickListener {
            Log.i("PicturesAdapter", "clicked " + item)
            listener?.onClicked(item)
        }
    }

    override fun getItemCount(): Int = if (dataSet == null) 0 else dataSet!!.size

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        internal var textView: android.widget.TextView = v as TextView

    }
}

