/**
* <p>Title: NewCachedThreadPool.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2017</p>
* @author 赵涵
* @date Mar 30, 2017
* @version 1.0
*/
package net.simplty.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.simplty.util.DateUtil;

/**
* <p>Title: NewCachedThreadPool</p>
* <p>Description: 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。</p>
* @author    赵涵
* @date Mar 30, 2017
*/
public class CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			final int index = i;
			
			//每过2秒往线程池里面加一个线程
			try {
				//Thread.sleep(index * 1000);
				Thread.sleep(2 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					
					System.out.println(DateUtil.getDate()+"  "+index);
					//每个线程执行200秒
					try {
						Thread.sleep(200 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
