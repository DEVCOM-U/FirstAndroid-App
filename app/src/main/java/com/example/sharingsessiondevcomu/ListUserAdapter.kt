package com.example.sharingsessiondevcomu

import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ListUserAdapter(): ListAdapter<UserData, ListUserAdapter.ListViewHolder>(
    DIFF_CALLBACK) {


    companion object {
        val DIFF_CALLBACK = object: DiffUtil.ItemCallback<UserData>() {
            override fun areItemsTheSame(oldItem: UserData, newItem: UserData): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: UserData, newItem: UserData): Boolean {
                return oldItem == newItem
            }

        }
    }

    class ListViewHolder(view:View): RecyclerView.ViewHolder(view) {

        fun bind(userData: UserData) {
//            val photo = itemView.findViewById<ImageView>(R.id.placeholder_iv)
            val name = itemView.findViewById<TextView>(R.id.nama_tv)
            val fakultas = itemView.findViewById<TextView>(R.id.fakultas_tv)
            val universitas = itemView.findViewById<TextView>(R.id.universitas_tv)
            val alamat = itemView.findViewById<TextView>(R.id.alamat_tv)


            name.text = userData.nama
            fakultas.text = userData.fakultas
            universitas.text = userData.universitas
            alamat.text = userData.alamat

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                itemView.context.startActivity(intent)
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListUserAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.placeholder_item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListUserAdapter.ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }
}