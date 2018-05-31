public class MyQuiz implements Quiz
{
	String[] questions;
	String[][] answers;
	int[] correct;
	public MyQuiz(String[] qs, String[][] as, int[] c)
	{
		questions = new String[qs.length];
		answers = new String[as.length][];
		correct = new int[c.length];
		for(int i = 0; i <qs.length; i++)
			questions[i] = qs[i];
		for(int i = 0; i <as.length; i++)
		{
			answers[i] = new String[as[i].length];
			for(int j = 0; j <as[i].length; j++)	
				answers[i][j] = as[i][j];
		}	
		for(int i = 0; i <c.length; i++)
			correct[i] = c[i];
	}
	public String getQuestion(int n)
	{
		if(n<=questions.length-1)
			return questions[n];
		else
			return null;
	}
	
	public String[] getAnswers(int n)
	{
		if(n<=answers.length-1)
			return answers[n];
		else
			return null;
	}
	
	public boolean isCorrect(String answer, int n)
	{
		if (n>questions.length)
			return false; 
		if (answer.equals(answers[n][correct[n]]))
			return true;
		else
			return false;
	}
	
}