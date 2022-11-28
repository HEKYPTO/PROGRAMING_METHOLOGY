package logic;

import component.Status;

public class WordValidator {
	
	public static Status[] checkWord(String guess, String word) {
		if (guess.length()!=5 || word.length()!=5) {
			return new Status[] {Status.INCORRECT, Status.INCORRECT, Status.INCORRECT, Status.INCORRECT, Status.INCORRECT};
		}
		Status[] result = new Status[] {Status.INCORRECT, Status.INCORRECT, Status.INCORRECT, Status.INCORRECT, Status.INCORRECT};
		
		String tempWord = word;
		String tempGuess = guess;
		
		for(int i = 0; i < 5; i++) {
			
			char current = guess.charAt(i);
			
			if(current==word.charAt(i)) {
				result[i] = Status.CORRECT;
				tempWord = replaceCharAt(tempWord, i, '-');
				tempGuess = replaceCharAt(tempGuess, i, '-');
			}
		}
		
		int total = tempGuess.length();
		
		for(int i = 0; i < total; i++) {
			
			char current = tempGuess.charAt(i);
			
			if(current!='-' && tempWord.contains(""+current)){
				result[i] = Status.PARTIAL;
				tempWord = tempWord.replaceFirst(current+"", "-");
			}
			
		}	
		
		return result;
	}
	
	public static String deleteCharAt(String s, int index) {
        StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(index);
        return sb.toString();
	}
	
	public static String replaceCharAt(String s, int pos, char c) {
		   return s.substring(0,pos) + c + s.substring(pos+1);
		}
}
