public class CountingValleys {
	 static void countingValleys(int n, String s) {
	        int count = 0;
	        boolean downFlag = false;
	        int valleyCount = 0;
	        for(int strCount=0;strCount<n;strCount++){
	            char c = s.charAt(strCount);
	            if(c == 'D'){
	            	count--;
	            	if(count<0)
	            		downFlag = true;
	            }else if( c == 'U'){
	            	count++;
	            }

	            if(downFlag==true&&count == 0 ){
	                valleyCount++;
	                downFlag = false;
	            }
	        }

	        System.out.println(valleyCount);

	    }
	public static void main(String[] args) {
		countingValleys(8,"UDDDUDUU");
	}

}
