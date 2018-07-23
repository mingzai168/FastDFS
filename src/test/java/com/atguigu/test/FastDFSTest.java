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
	// ׼�������ļ�������������conf
	// ����·�� ���롢 ��ͷ
	public static void main(String[] args) throws MyException, IOException {
		
		String Path = "/fdfs_client.conf";
		
		String absolutePath = FastDFSTest.class.getResource(Path).getPath();
		
		System.out.println("absolutePath"+absolutePath);
		
		// ��ʼ��
		ClientGlobal.init(absolutePath);
		
		// �����ĸ�����
		TrackerServer trackerServer = null ;
		TrackerClient trackerClient = null ;
		StorageServer storageServer = null ;
		StorageClient storageClient = null ;
		
		// ��������
		trackerClient = new TrackerClient();
		
		trackerServer = trackerClient.getConnection();
		
		storageClient = new StorageClient(trackerServer, storageServer);
		
		String local_filename = "C:/Users/Administrator/Desktop/20180704sts/FastDFS/dayun.jpg";
		String file_ext_name = "jpg";
		NameValuePair[] meta_list = null ; // �ļ�����Դ
		String[] results = storageClient.upload_appender_file(local_filename, file_ext_name, meta_list);
	
		for (String string : results) {
			System.out.println(string);
		}
		
			System.exit(0); /*���������������ĵص�&mdash;&mdash;Eclipse�ȼ��ɿ���������
								��������������еİ�����������ĵط���Ϊ��׼�����˵�ǲ����ʵģ�
								�����Console()���ص�Ĭ���������Null�����ǾͲ���������ĳ�����Ϣ��*/
	}

	
}
