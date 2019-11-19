package buu.informatics.s59160624.daydiary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59160624.daydiary.database.Diary

class  TodayAdapter: RecyclerView.Adapter<TodayAdapter.ViewHolder>(){
    var data = listOf<Diary>()
    set(value){
        field = value
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val todaydate: TextView = itemView.findViewById(R.id.todaydateText)
        val todaycontent: TextView = itemView.findViewById(R.id.todaycontentText)
        val image: ImageView = itemView.findViewById(R.id.quality_image)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_day,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
           return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = data[position]
             holder.todaydate.text = item.dateTime
             holder.todaycontent.text = item.content
             holder.image.setImageResource(when (item.mood) {
                      "happy" -> R.drawable.happy
                      "sad" -> R.drawable.sad
                     "angry" -> R.drawable.angry
                    "sick" -> R.drawable.sick
                 else -> R.drawable.nothing
        })
    }

}