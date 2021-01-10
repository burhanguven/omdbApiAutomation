package apiConfig;

import java.util.HashMap;
import java.util.Map;

import utils.EnvProperties;

public class QueryParam {

	public Map<String,String> getApikeyAndNameAndType(String movieName){
		Map<String, String> queryParam = new HashMap<String, String>();
		queryParam.put("apikey", EnvProperties.getProperties().get("apiKey"));
		queryParam.put("s", movieName);
		queryParam.put("type", ParamType.MOVIE.getLabel());
		
		return queryParam;
	}
	public Map<String,String> getApikeyAndNameAndType(String movieName,int page){
		Map<String, String> queryParam = getApikeyAndNameAndType(movieName);
		queryParam.put("page", String.valueOf(page));
		
		return queryParam;
	}
	public Map<String,String> getMovieDetail(String movieId){
		Map<String, String> queryParam=new HashMap<String, String>();
		queryParam.put("apikey", EnvProperties.getProperties().get("apiKey"));
		queryParam.put("i", movieId);
		
		return queryParam;
	}
}
