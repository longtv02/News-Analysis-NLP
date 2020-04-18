import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import org.knowm.xchart.*;
import org.knowm.xchart.internal.chartpart.Chart;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.Theme;
import org.knowm.xchart.style.Styler.ChartTheme;
import org.knowm.xchart.VectorGraphicsEncoder;
/*
 * This is a class that creates a pie chart. 
 * We will have several graphic classes with similar functions. 
 * We plan to change the methods to take inputs (ie:
 * allow us to specify if we want to make a chart for positive, 
 * negative, or neutral sentiment) 
 */
public class SentimentPieCharts implements Charts {

	//DTMNormalizer dtm;
	//ArrayList<String[]> DTMdata;
	HashMap<String, Integer[]> sentChartData = new HashMap<>();
	

	/*
	 * Constructs a PieChartMaker object
	 */
	public SentimentPieCharts() {
		this.sentChartData = extractSentSourceData();
		
		
	}

	


	/*
	 * Simplifies the ser file into an array with the data needed for just this chart.
	 * This array can be used to investigate sentiment by source.
	 */
	public HashMap<String, Integer[]> extractSentSourceData() {
		
	 for (Article article: Charts.articles) {
		
		String source = article.getSource().trim();
		int posSent = article.getPositiveCount();
		int negSent = article.getNegativeCount();
		int neutSent = article.getNeutralCount();
		
		if (sentChartData.containsKey(source)) {
			Integer[] counts = sentChartData.get(source);
			counts[0] += negSent;
			counts[1] += neutSent;
			counts[2] += posSent ;
			
			sentChartData.replace(source, counts);
		}
		
		else {
			Integer[] counts = {negSent, neutSent, posSent};
			sentChartData.put(source, counts);
			
		}
		

		}
		return sentChartData;
	}

	/*
	 * makes a chart showing the percent of positive sentiment that each source
	 * contributes to the corpus.
	 */
	public PieChart makeChart( String sentiment) {
		PieChart chart = new PieChartBuilder().width(1000).height(600).title("Sentiment Chart").theme(ChartTheme.GGPlot2).build();
	
		Color[] sliceColors = new Color[] { new Color(139,0,0), new Color(255,99,71), new Color(255,165,0), new Color(255,215,0), new Color(154,205,50), new Color(34,139,34), new Color(0,255,127)
				,new Color(32,178,170), new Color	(47,79,79), new Color(100,149,237), new Color(25,25,112), new Color(138,43,226), new Color(221,160,221), new Color(255,192,203)};
	    chart.getStyler().setSeriesColors(sliceColors);
		
		Integer sentAmount = 0;
		for (String source : sentChartData.keySet()) {
			Integer[] sents = sentChartData.get(source);
			
			if (sentiment.contains("pos")) {
				sentAmount= sents[2];	
				chart.setTitle("Percent of Positive Sentiment that each Source Contributes to the Corpus as a Whole");
			}
			
			if(sentiment.contains("neut")){
				sentAmount= sents[1];
				chart.setTitle("Percent of Neutral Sentiment that each Source Contributes to the Corpus as a Whole");
			}
			
			if(sentiment.contains("neg")){
				
				sentAmount= sents[0];
				chart.setTitle("Percent of Negative Sentiment that each Source Contributes to the Corpus as a Whole");
			}
			
			chart.addSeries(source, sentAmount);

		}
		
		
		
		
		//new SwingWrapper<PieChart>(chart).displayChart();
		return chart;
		

	}

	
	public static void main(String[] args) {
		//PieChartMaker gm = new PieChartMaker();
		//HashMap<String, Integer[]> series = gm.extractSentSourceData();
		//gm.makeChart("pos");

	}

	
		
		
		
		
	}


