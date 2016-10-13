package net.simplty.fileMonitor;

import java.io.File;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileMonitor {
	private static Log log = LogFactory.getLog(FileMonitor.class);
	FileAlterationMonitor monitor = null;  
	
	/**
	 * @param interval 每隔多少毫秒扫描一次
	 * @throws Exception
	 */
	public FileMonitor(long interval) throws Exception {  
		monitor = new FileAlterationMonitor(interval);  
	}  

	public void monitor(String path, FileAlterationListener listener) {  
		log.info("开启文件坚挺线程，监听路径："+path);
		
		FileAlterationObserver observer = new FileAlterationObserver(new File(path));  
		monitor.addObserver(observer);  
		observer.addListener(listener);  
	}  
	public void stop() throws Exception{  
		monitor.stop();  
	}  
	public void start() throws Exception {  
		monitor.start();  
	}  
	
}
