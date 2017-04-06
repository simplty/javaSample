/**
* <p>Title: SingleThreadExecutor.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2017</p>
* @author 赵涵
* @date Apr 6, 2017
* @version 1.0
*/
package net.simplty.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.simplty.util.DateUtil;

/**
* <p>Title: SingleThreadExecutor</p>
* <p>Description: </p>
* @author    赵涵
* @date Apr 6, 2017
*/
public class SingleThreadExecutor {
	public static void main(String[] args) {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//		for (int i = 0; i < 10; i++) {
//			final int index = i;
//			singleThreadExecutor.execute(new Runnable() {
//				public void run() {
//					try {
//						System.out.println(index);
//						Thread.sleep(3000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			});
//		}

		// 为了方便观察，做一点修改
		for (int i = 0; i < 100; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				public void run() {
					try {
						//这里写个死循环，就是模拟第一个线程一直运行不停止
						while (true) {
							System.out.println(DateUtil.getDate()+"  "+index);
							Thread.sleep(10 * 1000);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			
			System.out.println(DateUtil.getDate()+"  after execute");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
