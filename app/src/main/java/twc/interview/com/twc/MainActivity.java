package twc.interview.com.twc;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GetMovies.Callbacks {
    ListView listView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        new GetMovies(this).execute();// service call to get movies information

    }

    @Override
    public void postExecute(ArrayList<MovieVO> movies) {
        if(listView!=null)
            listView.setAdapter(new MovieAdapter(context,movies));//loads data into list view after success reponse
    }



}
