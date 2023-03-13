package core.ics;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class InitializerContainerTest implements QuarkusTestResourceLifecycleManager {

    private PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11");

    private Map<String, String> config(){
        Map<String, String> config = new HashMap<>();

        config.put("quarkus.datasource.url", postgreSQLContainer.getJdbcUrl());
        config.put("quarkus.datasource.username", postgreSQLContainer.getUsername());
        config.put("quarkus.datasource.password", postgreSQLContainer.getPassword());
        config.put("quarkus.datasource.db-kind", postgreSQLContainer.getDriverClassName());

        return config;
    }
    @Override
    public Map<String, String> start() {
        postgreSQLContainer.start();
        return config();
    }

    @Override
    public void stop() {
        if (postgreSQLContainer !=null){
            postgreSQLContainer.close();
        }
    }
}
