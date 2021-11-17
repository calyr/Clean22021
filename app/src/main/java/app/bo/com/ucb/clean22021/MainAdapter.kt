package app.bo.com.ucb.clean22021

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.bo.com.ucb.domain.Movie
import com.squareup.picasso.Picasso

class MainAdapter(val list: List<Movie>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_row, parent, false)
        return MainViewHolder(view)
    }

    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = list.get(position)
        holder.itemView.findViewById<TextView>(R.id.tv_movie_title).text = movie.title
        Picasso.get().load("https://image.tmdb.org/t/p/w185/${movie.posterPath}")
            .into(holder.itemView.findViewById<ImageView>(R.id.img_movie))
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
