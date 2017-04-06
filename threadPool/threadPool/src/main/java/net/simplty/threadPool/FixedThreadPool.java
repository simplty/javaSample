/**
* <p>Title: FixedThreadPool.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2017</p>
* @author 赵涵
* @date Apr 6, 2017
* @version 1.0
*/
package net.simplty.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * Title: FixedThreadPool
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author 赵涵
 * @date Apr 6, 2017
 */
public class FixedThreadPool {
	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}