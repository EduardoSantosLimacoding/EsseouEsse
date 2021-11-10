package co.edu.myapplication

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {

    private lateinit var imageLeft : ImageView
    private lateinit var imageRight : ImageView
    private lateinit var tvResults : LinearLayoutCompat
    private lateinit var itemLeft: Item
    private lateinit var itemRight: Item
    private lateinit var listItems: MutableList<Item>
    private var listResults = hashMapOf<Item,Int>()
    private var list = mutableListOf<Result>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populate()

        imageLeft = findViewById(R.id.imageLeft)
        imageRight = findViewById(R.id.imageRight)

        setImageToView()

        imageLeft.setOnClickListener {
            vote(itemLeft)
        }
        imageRight.setOnClickListener {
            vote(itemRight)
        }
    }

    private fun vote(item: Item){
        //listItems.remove(item)
        listResults[item] = listResults[item]!! + 1
        setImageToView()
    }

    private fun setImageToView() {
        listItems.shuffle()

        itemLeft = listItems[0]
        itemRight = listItems[1]

        imageLeft.setImageDrawable(itemLeft.image)
        imageRight.setImageDrawable(itemRight.image)

        tvResults = findViewById(R.id.tvResults)
        tvResults.removeAllViews()
        for (i in listResults.keys) {
            if(listResults[i]!! > 0) {
                val tv = TextView(this)
                tv.text = "${i.title} tem ${listResults[i]} votos"
                tvResults.addView(tv)
            }
        }
    }

    private fun populate(): MutableList<Item> {
        listItems = mutableListOf()
        listItems.add(
            Item(
                "Ein",
                ResourcesCompat.getDrawable(resources, R.drawable.ein, null),
                0,
                false
            )
        )
        listItems.add(
            Item(
                "Ezra Scarlet",
                ResourcesCompat.getDrawable(resources, R.drawable.ezra_scarlet, null),
                0,
                false
            )
        )
        listItems.add(
            Item(
                "Genos",
                ResourcesCompat.getDrawable(resources, R.drawable.genos, null),
                0,
                false
            )
        )
        listItems.add(
            Item(
                "Hataki Kakashi",
                ResourcesCompat.getDrawable(resources, R.drawable.hataki_kakashi, null),
                0,
                false
            )
        )
        listItems.add(
            Item(
                "Hiei",
                ResourcesCompat.getDrawable(resources, R.drawable.hiei, null),
                0,
                false
            )
        )
        listItems.add(
            Item(
                "L",
                ResourcesCompat.getDrawable(resources, R.drawable.l_death_note, null),
                0,
                false
            )
        )
        listItems.add(
            Item(
                "Mae Hughes",
                ResourcesCompat.getDrawable(resources, R.drawable.mae_hughes, null),
                0,
                false
            )
        )
        listItems.add(
            Item(
                "Roronoa Zoro",
                ResourcesCompat.getDrawable(resources, R.drawable.roronoa_zoro, null),
                0,
                false
            )
        )
        listItems.add(
            Item(
                "Sanosuke",
                ResourcesCompat.getDrawable(resources, R.drawable.sanosuke, null),
                0,
                false
            )
        )
        listItems.add(
            Item(
                "The Choushin",
                ResourcesCompat.getDrawable(resources, R.drawable.the_choushin, null),
                0,
                false
            )
        )
        listItems.add(
            Item(
                "Vegeta",
                ResourcesCompat.getDrawable(resources, R.drawable.vegeta, null),
                0,
                false
            )
        )
        listItems.add(
            Item(
                "Zeno",
                ResourcesCompat.getDrawable(resources, R.drawable.zeno, null),
                0,
                false
            )
        )

        listItems.forEach{
            listResults[it] = 0
        }

        return listItems
    }
}

data class Item(
    val title: String,
    val image: Drawable?,
    val count: Int,
    val isVoted: Boolean
)

data class Result(
    val title: String?,
    val count: Int?
)