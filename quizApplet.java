import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;



@SuppressWarnings("deprecation")




public class quizApplet extends JApplet{
	int questionNum;
	int numCorrect;
	Quiz quiz;
	
    public void paint(Graphics gr) {
        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
  /*  public void QuizAppletConstructor(Quiz q) 
    	{
        	
    		quiz = q;
            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		JPanel panel = new JPanel();
    		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
            questionNum = 0;
    		numCorrect = 0;
    		ArrayList<JRadioButton> buttons = new ArrayList<JRadioButton>();
    		//add next button
    		JButton b=new JButton("Next");  
    		b.setBounds(50,100,95,30);  
    		b.addActionListener(new ActionListener(){  
    			public void actionPerformed(ActionEvent e){  
    				//check if they answered correctly
    				for(int i = 0; i < buttons.size(); i++)
    				{
    					if(buttons.get(i).isSelected() && quiz.isCorrect(buttons.get(i).getText(), questionNum))
    					{
    						numCorrect++;
    						System.out.println("correct!");
    						break;
    					}
    				}
    				questionNum++;
    				//update GUI with new question and answer choices
    				Component[] components = panel.getComponents();
    				for(int i = 1; i < components.length; i++)
    				{
    					panel.remove(components[i]);
    				}
    				String qText = quiz.getQuestion(questionNum);
    				if(qText != null)
    				{
    					JLabel question = new JLabel(qText);
    					panel.add(question);
    					buttons.clear();
    					addAnswerButtons(questionNum, panel, buttons);
    				}
    				else
    				{
    					//remove next button
    					panel.remove(components[0]);
    					//show score
    					JLabel score = new JLabel("Score: " + numCorrect);
    					panel.add(score);
    				}
    				System.out.println(numCorrect); 
    				panel.revalidate();
    				panel.repaint();
    			}  
    		});  
    		panel.add(b); 
    		//add first question as JLabel
    		JLabel question = new JLabel(quiz.getQuestion(0));
    		panel.add(question);
    		addAnswerButtons(0, panel, buttons);
    		//getContentPane().add(panel);
    		//pack();
    		setVisible(true);
        }   */
        
    public void addAnswerButtons(int n, JPanel panel, ArrayList<JRadioButton> buttons)
    	{
    		String[] answers = quiz.getAnswers(n);
    		ButtonGroup bg = new ButtonGroup();
    		for(int i = 0; i < answers.length; i++)
    		{
    			JRadioButton b = new JRadioButton(answers[i]);
    			bg.add(b);
    			buttons.add(b);
    			panel.add(b);
    		}
    	}
	public void init()
	{
		String[] questions = {"What is the better meal to eat?", "What are the top two causes of cancer?", "What's the best way to lose weight", "What can you do to prevent the spread of illnesses?", "Which of the following is worse for your overall health?", "What does it mean when somebody says \"cardio exercise\"?", "How much cardio exercise is recommended weekly?", "How do you calculate your BMI?"};
		String[][] answers = {{"McDonald's happy meal", "Subway \"eat Fresh\" footlong", "A homemade chicken Cesar salad"},{"Smoking(including cigarettes, hookah, or vapes) and obesity", "Smoking and sunburns", "Obesity and sunburns"}, {"Lower calorie intake", "exercise often", "a combination of both"}, {"Share food with friends", "Practice herd immunity by surrounding yourself with other people who aren't sick", "wash your hands and get vaccinated",}, {"Sitting in an office for long periods of time", "A brand new standing desk so you can stand while working", "Taking a break from work and moving a bit every hour or so", "Eating potatoe chips to snack while working"}, {"Using your credit card to buy exercise machines", "An exercise that gets your heart pumping", "A lifting exercise to gain muscle mass"}, {"1 hour every week", "30 minutes every day of the week", "3-4 hours, depending on intensity spread out over the week", "20-30 minutes 3-5 days of the week, depending on intensity"},{"Weight in kg divided by height in meters squared", "Weight in kg squared divided by height in meters", "Weight in pounds divided by height in meters squared","Weight in pounds divided by height in inches squared"}};
		int[] correct = {2,0,2,2,2,1,3,0};
		ArrayList<Integer> wrong = new ArrayList<Integer>();
		quiz = new MyQuiz(questions, answers, correct);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        questionNum = 0;
		numCorrect = 0;
		StringBuilder aFrayedKnot = new StringBuilder("<html>");
		ArrayList<JRadioButton> buttons = new ArrayList<JRadioButton>();
		//add next button
		JButton b=new JButton("Next");  
		b.setBounds(50,100,95,30);  
		b.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				//check if they answered correctly
				System.out.println(e);
				for(int i = 0; i < buttons.size(); i++)
				{
					if(buttons.get(i).isSelected() && quiz.isCorrect(buttons.get(i).getText(), questionNum))
					{
						numCorrect++;
						System.out.println("correct!");
						break;
					} else
					{
						aFrayedKnot.append(questions[questionNum] + ": Your answer was wrong, the correct answer is: " + answers[questionNum][correct[questionNum]] + "<br/>");
						System.out.println(aFrayedKnot.toString());
						
						break;
					}
				}
				questionNum++;
				//update GUI with new question and answer choices
				Component[] components = panel.getComponents();
				for(int i = 1; i < components.length; i++)
				{
					panel.remove(components[i]);
				}
				String qText = quiz.getQuestion(questionNum);
				if(qText != null)
				{
					JLabel question = new JLabel(qText);
					panel.add(question);
					buttons.clear();
					addAnswerButtons(questionNum, panel, buttons);
				}
				else
				{

					//remove next button
					panel.remove(components[0]);
					//show score
					JLabel score = new JLabel("Score: " + numCorrect);
					
					/*for(int i = 0; i < wrong.size(); i++)
					{
						aFrayedKnot+=questions[wrong.get(i)] + ": Your answer was wrong, the correct answer is: " + answers[wrong.get(i)][correct[wrong.get(i)]] + "<br/>" ;
					} */
					aFrayedKnot.append("</html>");
					JLabel questionsWrong = new JLabel(aFrayedKnot.toString());
					panel.add(score);
					panel.add(questionsWrong);
				}
				System.out.println(numCorrect); 
				panel.revalidate();
				panel.repaint();
			}  
		});  
		panel.add(b); 
		
		//add first question as JLabel
		JLabel question = new JLabel(quiz.getQuestion(0));
		panel.add(question);
		addAnswerButtons(0, panel, buttons);
		//getContentPane().add(panel);
		//pack();
		setVisible(true);
		add(panel);
	}
}

