package com.tecsup.labmaps

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MapsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var places: List<Place>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        places = listOf(
            Place("Cuarto del Rescate","El Cuarto del Rescate, en Cajamarca, Perú, es un sitio histórico crucial. En 1532, el inca Atahualpa fue capturado por los españoles liderados por Francisco Pizarro. Para ganar su libertad, ofreció llenar una habitación con oro y dos más con plata, pero los españoles no cumplieron el acuerdo y lo ejecutaron. Este lugar simboliza este trágico encuentro cultural y atrae a muchos visitantes interesados en la historia de la región.", R.drawable.cuarto),
            Place("Chan Chan", "Chan Chan es una antigua ciudad de barro ubicada en la costa norte de Perú, cerca de la ciudad de Trujillo. Construida por la civilización Chimú en el siglo IX, Chan Chan fue la capital del reino Chimú y es la ciudad de barro más grande del mundo. Las ruinas de Chan Chan son impresionantes por sus intrincados diseños de adobe, sus enormes murallas y sus complejos sistemas de irrigación.",R.drawable.chan_chan),
            Place("Señor de Sipán","El Museo de las Tumbas Reales del Señor de Sipán se encuentra en la ciudad de Lambayeque, Perú. Este museo alberga una colección de artefactos y restos arqueológicos pertenecientes a la cultura Moche, incluyendo las impresionantes tumbas descubiertas en la Huaca Rajada en 1987. El museo ofrece una fascinante visión de la cultura Moche y la vida del Señor de Sipán, un gobernante Moche que vivió en el siglo III d.C.", R.drawable.senor_de_sipan)
        )

        val adapter = PlaceAdapter(places) { place ->
            val intent = Intent(this, PlaceDetailActivity::class.java)
            intent.putExtra("placeName", place.lugar)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}
