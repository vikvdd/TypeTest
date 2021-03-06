import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class GUI extends Frame implements ActionListener, WindowListener
{
	
	private Label mainLbl;
	private Button btn1;
	private TextField typeTxt;
	
	
	//instantiate frame and set up labels/buttons/textfields
	public GUI()
	{
		super("Typer");
		
		// declare and add all components 
		mainLbl = new Label("");
		mainLbl.setSize(this.getWidth(), 300);
		typeTxt = new TextField("", 30);
		btn1 = new Button("a button");
		
		add(mainLbl);
		add(typeTxt);
		add(btn1);
		
		//add listeners
		btn1.addActionListener(this);
		addWindowListener(this);
		
		// setup the frame);
		setTitle("Typer");
		setPreferredSize(new Dimension(400, 400));
		setLayout(new GridLayout(3, 1));
		setVisible(true);
		pack();
	}

	
//GUI EVENTS/////////////////////////////////////////////////////	
	//triggers when action event occurs
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == typeTxt)
		{
			
		}
	}

//WINDOW EVENTS/////////////////////////////////////////////////////
	
	//close window when X is pressed on window container
	@Override
	public void windowClosing(WindowEvent evt)
	{
		System.exit(0);
	}
	
	 @Override public void windowOpened(WindowEvent evt) { }
	 @Override public void windowClosed(WindowEvent evt) { }
	 @Override public void windowIconified(WindowEvent evt) { }
	 @Override public void windowDeiconified(WindowEvent evt) { }
	 @Override public void windowActivated(WindowEvent evt) { }
	 @Override public void windowDeactivated(WindowEvent evt) { }

	//return main text label
	public Label getTextLbl()
	{
		return mainLbl;
	}
	
	//returns textfield
	public TextField getTextField()
	{
		return typeTxt;
	}
	
	
	
	//set text for main text label
	public void setTextLbl(String newTxt)
	{
		mainLbl.setText(newTxt);
		
		return;
	}
	
	//sets text label using all words in wordlist
	public void setTextLbl(List<Word> words_)
	{
		for(int i = 0; i < words_.size(); i++)
		{
			String lblText = mainLbl.getText();
			mainLbl.setText(lblText + " " + words_.get(i).getWord());
			
		}
		return;
	}
	
	//sets label size for text label
	public void setLabelSize(Label lbl, int width, int height) 
	{
		lbl.setSize(width, height);
		
		return;
	}
	
	//prints given message
	public void printMsg(String msg) {
		System.out.println(msg);
		
		return;
	}


	
	
}
