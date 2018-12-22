package Data;

import java.util.Random;
public class Questions {
	
	private String[] questions = new String[10];
	private String[] answers = new String[10];
	
	public Questions(String[] questions, String[] answers) {
		for(int i = 0; i< this.questions.length; i++) {
			this.questions[i] = questions[i];
			this.answers[i] = answers[i];
		}
		}
	public String getAnswer(int index) {
		 return answers[index];
	 }
		
	public String getAnswer(String question) {
		for(int i = 0; i< questions.length; i++) {
			if(questions[i] == question)
				return answers[i];
		}
		return "The Question Doesn't Exist";
	}
	
	public void generatekeys(int[] array) {
		Random rand = new Random();
		for(int i = 0; i < 4; i++) {
			int x;
			while(true) {
				int j;
				x = rand.nextInt(9);
				for(j = 0;j<i;j++) {
					if(x == array[j])
						break;
					
				}
				if(j==i)
					break;
			}
			array[i] = x;
		}
		
	}
	
	

}
