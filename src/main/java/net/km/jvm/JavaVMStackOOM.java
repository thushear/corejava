/**
 * 
 */
package net.km.jvm;

/**
 * @author kongming
 * VM args: -Xss2M
 */
public class JavaVMStackOOM {

	private void doneStop(){
		while(true){
			
		}
	}
	
	public void stackLeakByThread(){
		while(true){
			Thread thread = new Thread(new Runnable() {
				
				public void run() {
					doneStop();
				}
				
			});
			thread.start();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
		
	}

}
