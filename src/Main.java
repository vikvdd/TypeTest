import java.io.*;
import java.util.*;
import java.util.List;

public class Main 
{
	public static void main(String[] args) 
	{
		final String fileName = "textFile.txt";
		List<Word> wordList = new ArrayList<Word>();
		WordReader wReader = new WordReader(fileName);
		
		
		try 
		{
			wordList = wReader.readFile();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		GUI gui = new GUI();
		gui.setTextLbl(wordList);
	
		Score score = new Score(1);
		Game game = new Game(score, gui.getTextField(), wordList);
	
		game.start(gui, score, wordList, 0);
	}
	
//UTILITY////////////////////////////////////////////////////////////////////////////////////////////
	//print various error messages depending on given situation
	public static void errorMsg(int type)
	{
		if (type == 1)
		{
			print("This is not a valid response.");
		}
		else if (type == 2)
		{
			print("This file does not exist.");
		}
		else if (type == 3)
		{
			print("This is not the correct spelling.");
		}
	}
	
	//print given string 
	public static void print(String msg)
	{
		System.out.println(msg);
		return;
		
	}

}

