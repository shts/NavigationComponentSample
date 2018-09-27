package jp.shts.android.navigationsample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_animal.view.*

interface OnClickAnimalListener {
    fun onClick(name: String)
}

class AnimalViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_animal, parent, false)
) {
    fun bind(name: String, listener: OnClickAnimalListener?) {
        itemView.name.text = name
        itemView.setOnClickListener { listener?.onClick(name) }
    }
}

class AnimalListAdapter : RecyclerView.Adapter<AnimalViewHolder>() {

    var listener: OnClickAnimalListener? = null

    private val animals = arrayListOf<String>()

    fun add(animals: ArrayList<String>) {
        this.animals.addAll(animals)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder =
            AnimalViewHolder(parent)

    override fun getItemCount(): Int = animals.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(animals[position], listener)
    }
}