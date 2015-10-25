

public class Caesar {
	
	public static String caesarCode(String input, char offset){
		char arr[]=input.toUpperCase().toCharArray();
		
		for(int i = 0; i < input.length(); i++){
			arr[i] += offset-'A';
			if(arr[i]>'Z'){
				arr[i]=(char) ('A'+arr[i]-'Z'-1);
			}
		}
		String res = new String(arr);
		return res;
	}
}
