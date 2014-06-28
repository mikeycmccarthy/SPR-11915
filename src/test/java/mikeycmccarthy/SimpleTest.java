package mikeycmccarthy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SimpleTest.TestConfig.class,
        initializers = AppInitializer.class)
public class SimpleTest {

    @Autowired
    private ServiceWithTransactionality testObject;

    @Test
    public void test_something() throws Exception {
        testObject.doSomething();
    }

    @Configuration
    @EnableTransactionManagement
    static class TestConfig {

        @Autowired
        public DataSource dataSource;

        @Bean
        public ServiceWithTransactionality serviceWithTransactionality() {
            return new ServiceWithTransactionalityImpl(dataSource);
        }


    }
}
