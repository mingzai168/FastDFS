package com.atguigu.test;



import java.io.IOException;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSTest {
	// 准备配置文件——————conf
	// 声明路径 必须、 开头
	public static void main(String[] args) throws MyException, IOException {
		
		String Path = "/fdfs_client.conf";
		
		String absolutePath = FastDFSTest.class.getResource(Path).getPath();
		
		System.out.println("absolutePath"+absolutePath);
		
		// 初始化
		ClientGlobal.init(absolutePath);
		
		// 申明四个变量
		TrackerServer trackerServer = null ;
		TrackerClient trackerClient = null ;
		StorageServer storageServer = null ;
		StorageClient storageClient = null ;
		
		// 创建对象
		trackerClient = new TrackerClient();
		
		trackerServer = trackerClient.getConnection();
		
		storageClient = new StorageClient(trackerServer, storageServer);
		
		String local_filename = "C:/Users/Administrator/Desktop/20180704sts/FastDFS/dayun.jpg";
		String file_ext_name = "jpg";
		NameValuePair[] meta_list = null ; // 文件数据源
		String[] results = storageClient.upload_appender_file(local_filename, file_ext_name, meta_list);
	
		for (String string : results) {
			System.out.println(string);
		}
		
			System.exit(0); /*我们运行上面程序的地点&mdash;&mdash;Eclipse等集成开发环境，
								这对于上面描述中的把启动虚拟机的地方作为标准输出来说是不合适的，
								这里的Console()返回的默认情况下是Null，于是就产生了上面的出错信息。*/
	}

	
}
