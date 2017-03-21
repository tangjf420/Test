import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Main {

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
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
			System.out.println(e.getErrors());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
