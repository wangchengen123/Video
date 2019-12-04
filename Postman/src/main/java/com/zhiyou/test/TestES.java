package com.zhiyou.test;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;

public class TestES {
	
	
	
	/**
	 * 创建索引
	 * @throws IOException 
	 */
	@Test
	public void testESAddIndex() throws IOException {
		// 创建客户端
		RestHighLevelClient cilent = new RestHighLevelClient(
				RestClient.builder(
						new HttpHost("192.168.70.128",9200,"http")));//ip 端口  请求协议
		
		
		// 1. 创建索引
		CreateIndexRequest request = new CreateIndexRequest("book2");
		
		// 1.1 索引的设置  分片/副本信息
		request.settings(Settings.builder()
				.put("index.number_of_shards",5) // 分片信息
				.put("index.number_of_replicas",1)); // 副本
		
		// 2. 构造mapping
		// 2.1 写构造mapping的json数据
		String jsonStr = "{\"novel\":{\"properties\":{\"title\":{\"type\":\"text\"}}}}";
		// 2.2 给请求设置json数据
		request.mapping("novel",jsonStr,XContentType.JSON);
		
		
		// 3. 发出请求:创建索引 并且 构造mapping
		cilent.indices().create(request);
		
		// 4. 关流
		cilent.close();
		
		System.out.println("执行完毕");
		
		
	}
}
