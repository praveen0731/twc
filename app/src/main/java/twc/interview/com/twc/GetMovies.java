package twc.interview.com.twc;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by praveen on 2/17/2016.
 */
public class GetMovies extends AsyncTask<Void,Void,ArrayList<MovieVO>> {
    private Callbacks mCallbacks;

    public GetMovies(Callbacks mCallbacks){
        this.mCallbacks=mCallbacks;
    }

    public interface Callbacks {
        /**
         * Callback for when an item has been selected.
         */
        public void postExecute(ArrayList<MovieVO> movies);
    }

    protected void onPreExecute() {}

    @Override
    protected ArrayList<MovieVO> doInBackground(Void... params) {
        return new RestClient().getMovies();

    }

    @Override
    protected void onPostExecute(ArrayList<MovieVO> movies) {
        super.onPostExecute(movies);
        if(mCallbacks!=null)
            mCallbacks.postExecute(movies);



    }

}
