import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
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
				//update currently typed word per key press
				currentWord += e.getKeyChar() + "";
				
				//if space is pressed and time isnt up it spell checks word and reacts appropriately 
				if (e.getKeyCode() == 32 && !gameDone)
				{
					Word word = wordList.get(count);
					word.setSpelledWord(currentWord);
					word.spellCheck();
					
					if (word.getSpellCheck() == true)
					{
						score.correctWord();
					}
					score.incorrectWord();
					count++;
					currentWord = "";
				}
				//if backspace is pressed it checks to see if a word is being retyped, and the adjusts word count
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
				System.out.println(score.getTotalScore());
			
			}
		}, totalTime * 60 * 1000);
		//while time is running test if input words match expected words
		
		return score_;
	}
	
	//print error messsage 
	public static void errorMsg()
	{
		System.out.println("incorrect word");
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
