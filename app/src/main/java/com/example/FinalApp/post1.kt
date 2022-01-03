package com.example.FinalApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class post1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post1)

        val recyclerview:RecyclerView=findViewById(R.id.recylerView)
        recyclerview.layoutManager=LinearLayoutManager(this)

        val titleList= ArrayList<String>()
        val descriptionList= ArrayList<String>()

        titleList.add("Marine animals")
        descriptionList.add("Nearly 80% of the world's fisheries are fully exploited, over-exploited, depleted, or in a state of collapse. Globally, 90% of large predatory fish, such as sharks and tuna are gone. ")
        titleList.add("Pollution")
        descriptionList.add("Mining is considered the world’s Number One Toxic Polluter. Steel production, for example, results in 80 tons of toxic wastewater for each ton of steel produced. ")
        titleList.add("Deforestation")
        descriptionList.add("According to NASA, the world's rainforests will be gone by 2100 if the current rate of destruction continues.")
        titleList.add("Recycle")
        descriptionList.add("Aluminum is the most recyclable materials in the recycling bin, as well as one of the most recycled materials!")
        titleList.add("Ozone Layer")
        descriptionList.add("The UN's Environment Agency (UNEP) has declared that the ozone layer, the planet's protective shield of gas, is on track to heal completely by 2069.")
        titleList.add("Biome")
        descriptionList.add("The Taiga, also known as the boreal forest, is the world's largest biome.")
        titleList.add("Fungi")
        descriptionList.add("They not only decompose dead matter, but also break down rocks and even help to absorb oil spills and radiation.")
        titleList.add("Immortal Jellyfish!")
        descriptionList.add("There is one species of jellyfish, Turritopsis nutricula, reverts to a sexually immature stage after reproduction, rather than dying as in other jellyfishes.")
        titleList.add("Species Diversity")
        descriptionList.add("Till now 1.5 million species are discovered, yet 6 million species are yet to discovered and named!")
        titleList.add("Insects")
        descriptionList.add("More than 70% of discovered species are animals out of which 70% are Insects!")
        titleList.add("Ecosystem Services")
        descriptionList.add("According to biologist Robert Costanza  it would cost US $33 trillion a year, for ecosystem services which includes Soil formation, Nutrient cycling and Climate regulation!")

        val adapter=postadapter(titleList,descriptionList)
        recyclerview.adapter=adapter
    }
}