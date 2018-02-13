import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Game 
{
	boolean gameDone;
	
	public Game()
	{
		gameDone = false;
	}
	
	//starts timer for given amount of time. Then compares whether the typed word matches the expected word and increments score accordingly
	public Score start(Score score_, List<Word> words_, int cnt_)
	{
		int totalTime = score_.getTotalTime();
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() 
			{
				gameDone = true;
			
			}
		}, totalTime * 60 * 1000);
		//while time is running test if input words match expected words
		while (!gameDone)
		{
			Word word = words_.get(cnt_);
			word.setSpelledWord(inputStr());
			if (word.spellCheck(word))
			{
				score_.correctWord();
				System.out.println("yeah buddy");
			}
			else 
			{
				errorMsg();
			}
			
			cnt_++;
		}
		
		return score_;
	}
	
	public static void errorMsg()
	{
		System.out.println("incorrect word");
	}
	
	public static String inputStr()
	{
		Scanner scanner = new Scanner(System.in);
		String response = scanner.nextLine();
		
		return response;
		
	}
	

}
