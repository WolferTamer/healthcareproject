public interface Quiz
{
	//returns the nth question in the quiz, or null if 
	//there are fewer than n questions in the quiz
	public String getQuestion(int n);
	
	//returns an array containing the answer choices 
	//for the nth question in the quiz, or null if 
	//there are fewer than n questions.
	//not all questions must have the same number of 
	//answer choices.
	public String[] getAnswers(int n);
	
	//returns true if answer is the correct answer to 
	//the nth question, and returns false otherwise
	public boolean isCorrect(String answer, int n);
}