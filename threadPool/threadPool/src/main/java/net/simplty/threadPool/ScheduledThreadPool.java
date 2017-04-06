/**
* <p>Title: ScheduledThreadPool.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2017</p>
* @author 赵涵
* @date Apr 6, 2017
* @version 1.0
*/
package net.simplty.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
* <p>Title: ScheduledThreadPool</p>
* <p>Description: </p>
* @author    赵涵
* @date Apr 6, 2017
*/
public class ScheduledThreadPool {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		//延迟3秒执行
		scheduledThreadPool.schedule(new Runnable() {
			public void run() {
				System.out.println("delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS);
		
		//定期执行
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("delay 1 seconds, and excute every 3 seconds");
			}
		}, 1, 3, TimeUnit.SECONDS);

	}
}
