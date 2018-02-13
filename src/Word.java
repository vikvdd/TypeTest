
public class Word 
{
	private String word;
	private String spelledWord;
	private boolean spellCheck;
	
	public Word(String word_, String spelledWord_)
	{
		word = word_.toLowerCase();
		spelledWord = spelledWord_;
		spellCheck = false;
	}
	
	public boolean spellCheck(Word word_)
	{
		if (word_.getSpelledWord().equals(word_.getWord()))
		{
			spellCheck = true;
		}
		
		return spellCheck;
	}
	
	public String getWord()
	{
		return word;
	}
	
	public String getSpelledWord()
	{
		return spelledWord;
	}
	
	public void setSpelledWord(String newWord_)
	{
		spelledWord = newWord_.toLowerCase();
	}
	
}
