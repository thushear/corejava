/**
 * 
 */
package net.km.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出异常测试 
 * VM args: -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * @author kongming
 *
 */
public class HeapOOM {
	
	
	static class OOMObject{
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<HeapOOM.OOMObject>();
		while(true){
			list.add(new OOMObject());
		}

	}

}
