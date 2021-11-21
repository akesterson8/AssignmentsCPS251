package com.ebookfrenzy.carddemo

import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.snackbar.Snackbar
import androidx.core.content.ContextCompat.startActivity

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var data = Data()
   // private lateinit var arr: ArrayList<ArrayList<Int>>
    var vm = MainViewModel

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener{ v:View ->
                var position: Int = adapterPosition
                var titleSelect = vm.intlist[position][0]
                var detailSelect = vm.intlist[position][1]
                var imageSelect = vm.intlist[position][2]

                val i = Intent(v.getContext(),SecondActivity::class.java)
                i.putExtra("titles",titleSelect)
                i.putExtra("details",detailSelect)
                i.putExtra("image",imageSelect)
                startActivity(v.context,i,null)

            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.titles.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.itemTitle.text = data.titles[vm.intlist[i][0]]   // array[i][0]
        viewHolder.itemDetail.text = data.details[vm.intlist[i][1]] //array[i][1]
        viewHolder.itemImage.setImageResource(data.images[vm.intlist[i][2]]) //array[i][2]

    }
}
