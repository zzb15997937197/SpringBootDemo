package cn.itcast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Freemarker测试
 * @author lx
 *
 */
public class FMDemo {

	//实例化Freemarker  配置类   ftl freemarker templet  
	// .java  .html  .jsp .xml
	// .ftl .txt 
	//dao bean xml service controller .jsp
	public static void main(String[] args) throws IOException, TemplateException {
		//模板 +  数据模型 = 输出
		Configuration  conf = new Configuration();
		//告诉conf 类  模板放在哪里
		String dir = "C:\\Users\\admin\\Desktop\\freemarker\\freemarker\\ftl";
		// 模板放在哪里
		conf.setDirectoryForTemplateLoading(new File(dir));	
		//模板对象
		Template template = conf.getTemplate("freemarker.html");
		//数据
		Map root = new HashMap();
		root.put("world", "世界你好");
		//1
		Person person = new Person();
		person.setId(1);
		person.setName("薪水");
		root.put("person", person);
		//2 List
		List<String> persons = new ArrayList<String>();
		persons.add("范冰冰");
		persons.add("李冰冰");
		persons.add("何灵");
		root.put("persons", persons);
		//3 Map
		Map mx = new HashMap();
		mx.put("fbb","范冰冰");
		mx.put("lbb","李冰冰");
		root.put("mx",mx);
		//4: List<Map>
		
		List<Map> maps = new ArrayList<Map>();
		Map pms1 = new HashMap();
		pms1.put("id1", "范冰冰");
		pms1.put("id2", "李冰冰");
		Map pms2 = new HashMap();
		pms2.put("id1", "曾志伟");
		pms2.put("id2", "何炅");
		maps.add(pms1);
		maps.add(pms2);
		root.put("maps", maps);
		
		//时间
		root.put("cur_time", new Date());
		//null
		root.put("val",null);

		//输出流  最终成文件
		System.out.println(dir);
		Writer out = new FileWriter(new File(dir + "\\index01.html"));
		
		template.process(root, out);
		
		System.out.println("生成完毕！");
		
	}
}
