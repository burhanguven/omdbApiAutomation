package apiConfig;

public enum ParamType {

	MOVIE("movie"),
	SERIES("series"),
	EPISODE("episode");
	
	public String getLabel() {
		return label;
	}

	public final String label;

	private ParamType(String label) {
	   this.label = label;
	}
	
}
