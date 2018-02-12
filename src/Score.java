
public class Score 
{
	private int correctWords;
	private int totalWords;
	
	public Score()
	{
		correctWords = 0;
		totalWords = 0;
	}
	
	public int getCorWords()
	{
		return correctWords;
	}
	
	public int getTotWords()
	{
		return totalWords;
	}
	
	public void correctWord()
	{
		totalWords++;
		correctWords++;
	}

}
