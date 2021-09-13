package util;

public class ABIUtil {


	public static String toCleanFunctionSig(String functionStr){

	    String cleanSig;
	    String functionName = parseFunctionName(functionStr);
	    String[] parameterTypes = parseParameterTypes(functionStr);
	    //Build the first piece of the clean signature
	    cleanSig = functionName + "(" + parameterTypes[0];
	    //If we have more than 1 parameter, lets cycle through them and add commas...
	    if(parameterTypes.length >= 2){
	    	for(int i = 1; i < parameterTypes.length; i++){
	    		cleanSig += "," + parameterTypes[i];
	    	}
	    }
	    cleanSig += ")";

		return cleanSig;
	}

	public static String toMethodID(String functionSig){

		String methodID = "";

		return methodID;
	}

	public static String parseFunctionName(String str){

		String functionName;

		int indexEnd = str.indexOf("(");
		int indexStart = 0;
		//If our function name has the function keyword specified...
		if(str.contains("function")){
			indexStart = str.indexOf("function") + 8;
		}
		functionName = str.substring(indexStart, indexEnd).trim();


		//System.out.println("Function Name: " + functionName);

		return functionName;
	}

	public static String[] parseParameterTypes(String str){

		String[] parameterTypes;

	    int indexStart = str.indexOf("(") + 1;
	    int indexEnd = str.indexOf(")");
	    parameterTypes = (str.substring(indexStart, indexEnd)).split(",");

	    for(int i = 0; i < parameterTypes.length; i++){
	    	//Trim the extra whitespace
	    	String paramType = parameterTypes[i].trim();
	    	//Remove all but the type, if we have a var explicitly named
	    	if(paramType.indexOf(" ") != -1){
	    		paramType = paramType.substring(0, paramType.indexOf(" "));
	    	}
	    	parameterTypes[i] = paramType;
	    	//System.out.println(paramType);
	    }
	    return parameterTypes;
	}
	
	public static String[] parseABI(String abi) {
		
		abi = abi.trim();
		if(abi.indexOf("0x") == 0) { abi = abi.substring(2); }

		int num = abi.length() / 64;
		String[] parsedABI = new String[num];
		
		for(int i = 0; i < num; i++) {
			String abiByte32 = abi.substring(0, 64);
			parsedABI[i] = abiByte32;
			
			abi = abi.substring(64);
		}
		return parsedABI;
	}
	


}
