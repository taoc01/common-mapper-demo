package cn.com.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.VerboseProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 
 * <p>标题： MybatisGenerator</p>
 * <p>
 *    功能描述：
 *    
 * </p>
 * <p>创建日期：2018年1月25日 上午10:53:13 </p>
 * <p>作者：TaoCong</p>
 * <p>版本：1.0</p>
 */
public class MybatisGenerator{
	
	public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		InputStream configFile = MybatisGenerator.class.getResourceAsStream("/generatorConfig.xml");
		System.out.println(configFile);
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		ProgressCallback progress = new VerboseProgressCallback();
		myBatisGenerator.generate(progress);
	}

}
