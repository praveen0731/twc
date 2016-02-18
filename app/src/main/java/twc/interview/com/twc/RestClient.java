package twc.interview.com.twc;



import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by praveen on 2/17/2016.
 */
public class RestClient {

    public ArrayList<MovieVO> getMovies(){
        ArrayList<MovieVO> moviesVO=new ArrayList<MovieVO>();

        try{

            URL  url = new URL(ApplicationConstants.rottenServiceUrl);
        URLConnection connection = url.openConnection();

        String line;
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while((line = reader.readLine()) != null) {
            builder.append(line);
        }

        JSONObject json = new JSONObject(builder.toString());

        JSONArray movies=json.getJSONArray("movies");

       for(int i=0;i<movies.length();i++){

           JSONObject movie=movies.getJSONObject(i);
           MovieVO movieVO=new MovieVO();
           movieVO.setTitle(movie.getString("title"));
           movieVO.setSynopsis(movie.getString("synopsis"));
           JSONObject posters=movie.getJSONObject("posters");
           movieVO.setThumbnail(posters.getString("thumbnail"));

            moviesVO.add(movieVO);

       }


    } catch (Exception e) {
        e.printStackTrace();
    }
        return moviesVO;
    }


}
