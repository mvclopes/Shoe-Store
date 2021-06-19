package com.udacity.shoestore.view.shoeList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.layout_item.view.*
import timber.log.Timber

class ShoeListAdapter(private val shoeList: LiveData<MutableList<Shoe>>) : RecyclerView.Adapter<ShoeListAdapter.ShoeListViewHolder>() {

    class ShoeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //Referência aos campos inseridos no layout exibido no Recycler View
        val txtModel : TextView = itemView.textModel
        val txtCompany : TextView = itemView.textCompany
        val txtDescription : TextView = itemView.textDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return ShoeListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShoeListViewHolder, position: Int) {
        val currentItem = shoeList.value?.get(position)

        if (currentItem != null) {
            holder.txtModel.text = currentItem.name
            holder.txtCompany.text = currentItem.company
            holder.txtDescription.text = currentItem.description
            holder.itemView.setOnClickListener(View.OnClickListener {
                Timber.i("item pressionado ${position}")
                it.findNavController().navigate(ShoeListFragmentDirections.
                                            actionShoeListFragmentToShoeDetailsEditFragment(position))
            })
        }
    }

    override fun getItemCount(): Int {
        return shoeList.value?.size ?: 0
    }
}