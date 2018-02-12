import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class Typer 
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
		
		Score score = typeTest(wordList, 0);
	}

	public static Score typeTest(List<Word> words_, int cnt_, int totalTime_)
	{
		Score score = new Score();
		Timer timer = new Timer();
		boolean time = true;
		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() 
			{
				time = false;
			}
		}, totalTime_ * 60 * 1000);
		while (time == true)
		{
			Word word = words_.get(cnt_);
			word.setSpelledWord(inputStr(""));
			if (word.spellCheck(word))
			{
				score.correctWord();
			}
			else 
			{
				errorMsg(3);
			}
		}
		
		return score;
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
	
	public static String inputStr(String msg)
	{
		print(msg);
		Scanner scanner = new Scanner(System.in);
		String response = scanner.nextLine();
		
		return response;
		
	}
	
	//print given string 
	public static void print(String msg)
	{
		System.out.println(msg);
		return;
		
	}

}

