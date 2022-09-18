package com.example.lab_8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation

class DetailsCharacterFragment : Fragment(R.layout.fragment_details_character) {
    private lateinit var  imageCharacter: ImageView
    private lateinit var textName: TextView
    private lateinit var textSpecie: TextView
    private lateinit var textStatus: TextView
    private lateinit var textGender: TextView
    private val args: DetailsCharacterFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageCharacter = view.findViewById(R.id.imageView_fragmentDetailsCharacter_charImage)
        textName = view.findViewById(R.id.textView_fragmentDetailsCharacter_nameCharacter)
        textSpecie = view.findViewById(R.id.textView_fragmentDetailsCharacter_specieChar)
        textStatus = view.findViewById(R.id.textView_fragmentDetailsCharacter_statusChar)
        textGender = view.findViewById(R.id.txtView_fragmentDetailsCharacter_genderCharacter)

        imageCharacter.load(args.character.image){
            transformations(CircleCropTransformation())
            placeholder(R.drawable.ic_baseline_download_24)
            error(R.drawable.ic_baseline_error_outline_24)
            diskCachePolicy(CachePolicy.ENABLED)
            memoryCachePolicy(CachePolicy.ENABLED)
        }
        textName.text = args.character.name.toString()
        textSpecie.text = args.character.species.toString()
        textStatus.text = args.character.status.toString()
        textGender.text = args.character.gender.toString()

    }
}