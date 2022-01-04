package cn.com.common.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonUtils {
	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static XmlMapper xmlMapper = new XmlMapper();
	
	static {
		// 将对象中不能识别的property忽略
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	/**
	 * 将json字符串转换为Map对象
	 * @param json
	 * @return
	 * @version 1.1
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parse2Map(String json) {
		return parse2Object(json, HashMap.class);
	}
	
	/**
	 * 将字符串转换为数据对象的数组信息
	 * @param json
	 * @param clz
	 * @return 如果json为NULL或空白字符串，返回null。
	 * @version 1.1
	 */
	public static <T> List<T> parse2List(String json, Class<T> clz) {
		if (StringUtils.isEmpty(json)) return null;
		JavaType javaType = createCollectionType(clz);
		List<T> val = null;
		try {
			val = objectMapper.readValue(json, javaType);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return val;
	}
	
	private static <T> JavaType createCollectionType(Class<T> clz) {
		return objectMapper.getTypeFactory().constructParametricType(ArrayList.class, clz);
	}
	
	/**
	 * 将josn字符串转换为object
	 * @param json json字符串
	 * @param clz 目标对象类型
	 * @return 如果json为NULL或空白字符串，返回null。
	 * @version 1.1
	 */
	public static <T> T parse2Object(String json, Class<T> clz) {
		if (StringUtils.isEmpty(json)) return null;
		T val = null;
		try {
			val = objectMapper.readValue(json, clz);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return val;
	}
	
	/**
	 * 将object转换为json字符串
	 * @param obj 转换对象
	 * @return 如果obj为NULL，返回null。
	 * @version 1.1
	 */
	public static String object2Json(Object obj) {
		if (obj == null) return null;
		String res = null;
		try {
			res = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	public static String json2xml(String jsonStr) {
		String xml = null;
		try {
			JsonNode root = objectMapper.readTree(jsonStr);
			xml = xmlMapper.writeValueAsString(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xml;
	}

    /** 
     * xml string convert to json string FIXME 这个方法有问题
     */  
	public static String xml2json(String xml) {
		StringWriter w = new StringWriter();
		try {
			JsonParser jp = xmlMapper.getFactory().createParser(xml);
			JsonGenerator jg = objectMapper.getFactory().createGenerator(w);
			while (jp.nextToken() != null) {
				jg.copyCurrentEvent(jp);
			}
			jp.close();
			jg.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return w.toString();
	}
}
