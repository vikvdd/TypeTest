
public class Word 
{
	private String word;
	private String spelledWord;
	private boolean spellCheck;
	
	public Word(String word_, String spelledWord_)
	{
		word_ = word_.replace(" ", "");
		word = word_.toLowerCase();
		spelledWord = spelledWord_;
		spellCheck = false;
	}
	
	//test if spelled word matches actual word
	public void spellCheck()
	{
		if (spelledWord.equals(word))
		{
			spellCheck = true;
		}
		else
		{
			spellCheck = false;
		}
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
		newWord_ = newWord_.replace(" ", "");
		spelledWord = newWord_.toLowerCase();
	}
	
	public boolean getSpellCheck()
	{
		return spellCheck;
	}
	
	public void setWordAfterSpace() 
	{
		
	}
	
}
