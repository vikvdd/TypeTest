import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Game implements KeyListener
{
	private boolean gameDone;
	private TextField tField;
	private List<Word> wordList;
	private int count;
	private Score score;
	private String currentWord;
	
	
	public Game(Score score, TextField tField, List<Word> wordList)
	{
		gameDone = false;
		this.tField = tField;
		this.wordList = wordList;
		this.score = score;
		currentWord = "";
		tField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				currentWord += e.getKeyChar() + "";
				
				if (e.getKeyCode() == 32 && !gameDone)
				{
					Word word = wordList.get(count);
					word.setSpelledWord(currentWord);
					word.spellCheck();
					
					if (word.getSpellCheck() == true)
					{
						score.correctWord();
					}
					count++;
					currentWord = "";
				}
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					if ((tField.getText().equals("") || tField.getText().equals(" ") || tField.getText().equals("  ")))
					{
						count--;
					}
				}
			}
		});
	}

	//starts timer for given amount of time. Then compares whether the typed word matches the expected word and increments score accordingly
	public Score start(GUI gui_, Score score_, List<Word> words_, int cnt_)
	{
		int totalTime = score_.getTotalTime();
		Timer timer = new Timer();
		count = cnt_;
		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() 
			{
				gameDone = true;
			
			}
		}, totalTime * 60 * 1000);
		//while time is running test if input words match expected words
		
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

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	
	

}
