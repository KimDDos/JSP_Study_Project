package orm;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 싱글톤 패턴으로 객체의 인스턴스를 오직 1개만 생성해서 유지

public class DatabaseBuilder {
	private static final Logger log = LoggerFactory.getLogger(DatabaseBuilder.class);
	private static SqlSessionFactory factory;
	private static final String Config = "orm/MybatisConfig.xml";
	
	
	// 초기화 블록
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(Config));
		} catch (Exception e) {
			log.info("DatabaseBuilder Error!");;
			e.printStackTrace();
		}
		
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
}
