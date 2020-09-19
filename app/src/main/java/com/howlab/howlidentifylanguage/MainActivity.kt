package com.howlab.howlidentifylanguage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.mlkit.nl.languageid.LanguageIdentification
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        check_language.setOnClickListener {
            identifyLanguage(inputText.text.toString())
        }
    }
    fun identifyLanguage(string:String){
        val languageIdentifier = LanguageIdentification.getClient()
        languageIdentifier.identifyPossibleLanguages(string).addOnSuccessListener { languages ->
            for(language in languages){
                val lang = language.languageTag
                val confidence = (language.confidence * 100).toInt()
                Toast.makeText(this,"It's a $confidence% and The Language is $lang",Toast.LENGTH_LONG).show()
            }
        }
    }
}