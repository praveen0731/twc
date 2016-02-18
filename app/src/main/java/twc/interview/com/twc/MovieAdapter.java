package twc.interview.com.twc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by praveen on 2/17/2016.
 */
public class MovieAdapter extends BaseAdapter {

    public Context context;
    public ArrayList<MovieVO> movies;

    public MovieAdapter(Context context,ArrayList<MovieVO> movies){
        this.context=context;
        this.movies=movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=layoutInflater.inflate(R.layout.movie_item,parent,false);
        ImageView thumbnail=(ImageView)rowView.findViewById(R.id.thumbnail);
        TextView titleTV=(TextView)rowView.findViewById(R.id.title);
        TextView synopsisTV=(TextView)rowView.findViewById(R.id.synopsis);
        titleTV.setText(movies.get(position).getTitle());
        synopsisTV.setText(movies.get(position).getSynopsis());
        Picasso.with(context)
                .load(movies.get(position).getThumbnail())
                //.placeholder(R.drawable.user_placeholder) not considering has thumbnails are small size
                //.error(R.drawable.user_placeholder_error)
                .into(thumbnail);

        return rowView;
    }
}
