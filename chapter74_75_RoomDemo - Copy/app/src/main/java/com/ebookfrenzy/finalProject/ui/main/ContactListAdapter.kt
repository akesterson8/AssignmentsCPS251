package com.ebookfrenzy.finalProject.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.finalProject.Contacts
import com.ebookfrenzy.finalProject.R

class ContactListAdapter(private val contactItemLayout: Int) :
    RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactsList: List<Contacts>? = null
    var listener: onItemClickListener? = null
    fun settingListener(listener: onItemClickListener?){
        this.listener = listener
    }
    interface onItemClickListener{
        fun onClick(str: String)
    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val itemName = holder.name
        val itemPhone = holder.phone
        val itemId = holder.itemId
        var deleteBtn = holder.deleteBtn

        contactsList.let {
            itemName.text = it!![listPosition].name
            itemPhone.text = it!![listPosition].phone
            itemId.text = it!![listPosition].id.toString()
        }
        deleteBtn.setOnClickListener(View.OnClickListener {
            var id = itemId.text.toString()
            listener?.onClick(id)
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contacts>) {
        contactsList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactsList == null) 0 else contactsList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.nameTextView)
        var phone: TextView = itemView.findViewById(R.id.phoneTextView)
        var itemId: TextView = itemView.findViewById(R.id.itemId)
        var deleteBtn: ImageButton = itemView.findViewById(R.id.deleteBtn)
    }
}