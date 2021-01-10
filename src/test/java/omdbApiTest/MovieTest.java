package omdbApiTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import apiConfig.QueryParam;
import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import junit.framework.Assert;
import movie.MovieDetail;
import movie.MovieResponse;
import movie.MovieSummary;
import utils.EnvProperties;

public class MovieTest extends BaseTest {
	
	private String movieName="Harry Potter";
	private int pageCount;
	
	@BeforeClass
	public void getQueryPageSize ()
	{	
		int itemCountPerPage=10;
		QueryParam query=new QueryParam();
		MovieResponse res= sendRequest(query.getApikeyAndNameAndType(movieName), MovieResponse.class);
		
		int totalItemCount = Integer.parseInt(res.getTotalResults());
		pageCount = (int)Math.ceil((double)totalItemCount / itemCountPerPage);
	}
	@Test
	public void shouldSearchHarryPotterAndGetImdbIDWhenHarryPotterIsExist() {
		
		String equalName = "Harry Potter and the Sorcerer's Stone";
		QueryParam query=new QueryParam();
		List<MovieSummary> allMovies = new ArrayList<MovieSummary>();
		
		for (int i = 1; i <= pageCount; i++) {
			MovieResponse res = sendRequest(query.getApikeyAndNameAndType(movieName,i), MovieResponse.class);
			allMovies.addAll(res.getMovies());
		}
		
		Optional<MovieSummary> movieSummaryOpt=allMovies.stream().filter(movieModel -> movieModel.getTitle().equals(equalName)).findFirst();
		Assert.assertTrue(movieSummaryOpt.isPresent());
		
		/*List<MovieModel> movieSummaryOpt=allMovies.stream().filter(movieModel -> movieModel.getTitle().equals(equalName)).collect(Collectors.toList());
		Assert.assertEquals(2, movieSummaryOpt.size()); */
		//System.out.println(movieSummaryOpt.get().getTitle());
		
		MovieDetail movieDetail = sendRequest(query.getMovieDetail(movieSummaryOpt.get().getImdbID()), MovieDetail.class);
		Assert.assertNotNull(movieDetail.getTitle());
		Assert.assertNotNull(movieDetail.getYear());
		Assert.assertNotNull(movieDetail.getReleased());
	}
}
