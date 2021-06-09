public class StringManipulator{
	public String trimAndConcat(String stringA ,String stringB){
		String result;
		result = stringA.trim() + stringB.trim();
		return result;
	}

	public Integer getIndexOrNull(String string, char ting){
		Integer result;
		result = string.indexOf(ting);
		if (result < 0) {
			return null;
		}
		return result;
	}

	public Integer getIndexOrNull(String stringA,String stringB){
		Integer result;
		result = stringA.indexOf(stringB);
		if (result < 0){
			return null;
		}
		return result;
	}

	public String concatSubstring(String stringA, int a, int b, String stringB){
		String result;
		result = (stringA.substring(a,b)).concat(stringB);
		return result;
	} 
}