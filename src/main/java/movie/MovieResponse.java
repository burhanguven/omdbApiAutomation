package movie;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieResponse {

	@JsonProperty("Search")
	private List<MovieSummary> movies;
	@JsonProperty("totalResults")
	private String totalResults;
	@JsonProperty("Response")
	private String response;
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	public List<MovieSummary> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieSummary> movies) {
		this.movies = movies;
	}
	
}
