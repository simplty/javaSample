package net.simplty.fileMonitor;

public class TestFileMonitor {
	
	/**
	 * 测试方法：
	 * 启动程序，在制定的目录下进行文件操作
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {  
		String path = "/Users/zhaohan/Desktop/tmp";
		FileMonitor m = new FileMonitor(5000);  //每隔5000毫秒一次
		m.monitor(path,new FileListener());  
		m.start();  
	}
}
