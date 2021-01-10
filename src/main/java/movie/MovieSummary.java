package movie;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieSummary {

    @JsonProperty("Title")	
    private String title;
    @JsonProperty("Year")
	private String year;
    @JsonProperty("imdbID")
	private String imdbID;
	@JsonProperty("Type")
	private String type;
	@JsonProperty("Poster")
	private String poster;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImbdID(String imbdID) {
		this.imdbID = imbdID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}


}
