import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * @Title: Main.java
 * @Package:
 * @Description: TODO
 * @author: tangjf(tangjunfeng2006@126.com)
 * @date: 2015骞�6鏈�24鏃� 涓嬪崍11:31:02
 * @version: V1.0
 */

/**
 * @moudle: Main
 * @version:v1.0
 * @Description: TODO
 * @author: tangjf(tangjunfeng2006@126.com)
 * @date: 2015骞�6鏈�24鏃� 涓嬪崍11:31:02
 *
 */
public class Main {

	/**
	 *
	 * <p>
	 * Title: main
	 * </p>
	 * <p>
	 * author : tangjf(tangjunfeng2006@126.com)
	 * </p>
	 * <p>
	 * date : 2015骞�6鏈�24鏃� 涓嬪崍11:31:02
	 * </p>
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		try {
			List<String> warnings = new ArrayList<String>();
			final boolean overwrite = true;
			File configFile = new File("src/config.xml");
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration configuration = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator mybatisGenerator = new MyBatisGenerator(configuration, callback, warnings);

			mybatisGenerator.generate(null);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
