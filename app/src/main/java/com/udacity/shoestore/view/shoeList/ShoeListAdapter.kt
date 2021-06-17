package com.udacity.shoestore.view.shoeList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_instructions.view.*
import kotlinx.android.synthetic.main.layout_item.view.*

class ShoeListAdapter(private val shoeList: LiveData<List<Shoe>>) : RecyclerView.Adapter<ShoeListAdapter.ShoeListViewHolder>() {

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
        //TODO: Identificar forma de realizar o bind dos dados e vinculá-los ao ViewModel da classe
        val currentItem = shoeList.value?.get(position)

        if (currentItem != null) {
            holder.txtModel.text = currentItem.name
            holder.txtCompany.text = currentItem.company
            holder.txtDescription.text = currentItem.description
        }
    }

    override fun getItemCount(): Int {
        return shoeList.value?.size ?: 0
    }
}