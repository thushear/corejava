/**
 * 
 */
package net.km.jvm;

/** HotSpot不区分虚拟机栈和本地栈 
 *  一般来说 java的方法栈深度达到1000-2000是没问题的
 * @author kongming
 * 运行时VM args: -Xss128k
 */
public class JavaVMStackSOF {

	private int stackLength = 1;
	
	public void stackLeak(){
		stackLength ++;
		stackLeak();
	}
	
	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length :" + oom.stackLength);
			throw e;
		}

	}

}
