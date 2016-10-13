package net.simplty.fileMonitor;

import java.io.File;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileListener implements FileAlterationListener{
	
	FileMonitor monitor = null;
	@Override
	public void onStart(FileAlterationObserver observer) {
		System.out.println("onStart");
	}
	@Override
	public void onDirectoryCreate(File directory) {
		System.out.println("onDirectoryCreate:" +  directory.getName());
	}

	@Override
	public void onDirectoryChange(File directory) {
		System.out.println("onDirectoryChange:" + directory.getName());
	}

	@Override
	public void onDirectoryDelete(File directory) {
		System.out.println("onDirectoryDelete:" + directory.getName());
	}

	/**
	 * 当目录中有文件（或文件夹）创建的时候获取这个文件（或文件夹）
	 */
	@Override
	public void onFileCreate(File file) {
		System.out.println("onFileCreate:" + file.getPath());
	}

	@Override
	public void onFileChange(File file) {
		System.out.println("onFileCreate : " + file.getName());
	}

	@Override
	public void onFileDelete(File file) {
//		System.out.println("onFileDelete :" + file.getName());
	}

	@Override
	public void onStop(FileAlterationObserver observer) {
	}

}

