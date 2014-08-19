/**
 * 
 */
package net.km.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池内存溢出
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author kongming
 * 抛出outofMemoryException:PermGen space 说明
 * 运行时常量池属于方法区 
 */
public class RuntimeConstantPoolOOM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//使用List保持者常量池引用 避免Full GC 回收常量池行为
		List<String> list = new ArrayList<String>();
		//10M的PermSize在integer范围内足够产生OOM了
		int i = 0;
		while(true){
			//调用native 方法  使用常量池  
			list.add(String.valueOf(i++).intern());
		}
		

	}

}
