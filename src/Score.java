
public class Score 
{
	private int correctWords;
	private int totalWords;
	private int totalChar;
	private int totalTime;
	private int WPM;
	private int CPM;
	private int realWPM;
	private int realCPM;
	
	public Score(int totalTime)
	{
		this.totalTime = totalTime;
		correctWords = 0;
		totalWords = 0;
		WPM = 0;
		CPM = 0;
		realWPM = 0;
		realCPM = 0;
	}
	
	//returns total score in string form
	public String getTotalScore()
	{
		String score = "Words: " + totalWords + " Correct Words: " + correctWords;
		return score;
	}

	public int getCorWords()
	{
		return correctWords;
	}
	
	public int getTotWords()
	{
		return totalWords;
	}
	
	public int getWPM()
	{
		return WPM;
	}
	
	public int getRealWPM()
	{
		return realWPM;
	}
	
	public int getTotalTime()
	{
		return totalTime;
	}
	
	public void correctWord()
	{
		totalWords++;
		correctWords++;
	}
	
	public void incorrectWord()
	{
		totalWords++;
	}
	
	public void setWPM()
	{
		WPM = totalWords;
		realWPM = correctWords;
		
		
	}
	
	

}
