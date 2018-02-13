import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordReader 
{
	private String fileName;
	private List<Word> wordList;	
	
	public WordReader(String fileName_)
	{
		fileName = fileName_;
		wordList = new ArrayList<Word>();
	}
	
	//read text file and split each word into it's own string in array. 
	public List<Word> readFile() throws IOException
	{
		List<Word> wordList = new ArrayList<Word>();
		List<String> lineList = new ArrayList<String>();
		
		final String fileDir = "WordFile/";

		
		try
		{
			FileReader fr = new FileReader(fileDir + fileName);
			BufferedReader br = new BufferedReader(fr);
			String s;
		
			//loop through file and add each line to List
			while((s = br.readLine()) != null)
			{
				lineList.add(s);
			}
			
			//each line is converted to lowercase, split based into individual words, and added into new list of the Word class
			for(String ll: lineList)
			{
				
				ll.toLowerCase();
				ll = ll.replace(".", "");
				String[] tempList = ll.split(" ");
				for (int i = 0; i < tempList.length; i++)
				{
					wordList.add(new Word(tempList[i], ""));
				}
			}
			
			br.close();
			fr.close();
		}
		//show error message informing of a missing file
		catch (FileNotFoundException ex)
		{
			
		}
		
		return wordList;
		
	}
	
	
	public String getFileName()
	{
		return fileName;
	}
	
	public List<Word> getWordList()
	{
		return wordList;
	}
	
	public void setFileName(String newFileName)
	{
		fileName = newFileName;
	}

}
