package com.example.lab_8.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.example.lab_8.CharactersFragmentDirections
import com.example.lab_8.dataBase.Character
import com.example.lab_8.R

class PlaceAdapter(
    private val dataSet: MutableList<Character>,
    private val listener: RecyclerViewCharacterClickHandler
    ):RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    class ViewHolder(private val view:View, private val listener: RecyclerViewCharacterClickHandler
    ): RecyclerView.ViewHolder(view){
        private val imageType: ImageView = view.findViewById(R.id.image_itemPlace)
        private val textName : TextView = view.findViewById(R.id.text_itemPlace_name)
        private val textSpecie: TextView = view.findViewById(R.id.text_itemPlace_specie)
        private val textStatus: TextView = view.findViewById(R.id.text_itemPlace_status)
        private val textGender: TextView = view.findViewById(R.id.text_itemPlace_gender)
        private val imageView: ImageView = view.findViewById(R.id.image_itemPlace)
        private val layoutPlace: ConstraintLayout = view.findViewById(R.id.layout_itemPlace)

        fun setData(character: Character){
            textName.text = character.name
            textSpecie.text = character.species
            textStatus.text = character.status
            textGender.text = character.gender
            imageView.load(character.image){
                transformations(CircleCropTransformation())
                placeholder(R.drawable.ic_baseline_download_24)
                error(R.drawable.ic_baseline_error_outline_24)
                diskCachePolicy(CachePolicy.ENABLED)
                memoryCachePolicy(CachePolicy.ENABLED)
            }
            layoutPlace.setOnClickListener{
                listener.onCharacterClick(character)
            }
        }
    }

    interface RecyclerViewCharacterClickHandler{
        fun onCharacterClick(character: Character)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_place, parent, false)
        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(dataSet[position])
    }

    override fun getItemCount() = dataSet.size
}