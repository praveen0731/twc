package twc.interview.com.twc;

/**
 * Created by praveen on 2/17/2016.
 */
public class ApplicationConstants {

    public static String key="apikey=s9gd3xzejzsyjzrj5zfu3d6a";
    public static String moviesCount="&limit=5";
    public static String rottenBaseUrl="http://api.rottentomatoes.com/api/public/v1.0/lists/"+
            "movies/box_office.json?";

    public static String rottenServiceUrl=rottenBaseUrl+key+moviesCount;
}
