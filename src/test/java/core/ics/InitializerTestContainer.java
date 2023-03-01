package core.ics;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class InitializerTestContainer implements QuarkusTestResourceLifecycleManager {

    private PostgreSQLContainer postgreSQLContainer;

    private Map<String, String> config(){
        final Map<String, String> config = new HashMap<>();
        config.put("quarkus.datasource.jdbc.url",postgreSQLContainer.getJdbcUrl());
        config.put("quarkus.datasource.db-kind", postgreSQLContainer.getDriverClassName());
        config.put("quarkus.datasource.username",postgreSQLContainer.getUsername());
        config.put("quarkus.datasource.password",postgreSQLContainer.getPassword());

        log.info("quarkus.datasource.jdbc.url {}", postgreSQLContainer.getJdbcUrl());
        log.info("quarkus.datasource.username {}",postgreSQLContainer.getUsername());
        log.info("quarkus.datasource.password {}",postgreSQLContainer.getPassword());
        log.info("quarkus.datasource.db-kind {}",postgreSQLContainer.getDriverClassName());

        return config;
    }

    @Override
    public Map<String, String> start() {
        this.postgreSQLContainer = new PostgreSQLContainer<>("postgres:11");
        this.postgreSQLContainer.start();
        return config();
    }

    @Override
    public void stop() {
        if (postgreSQLContainer != null){
            postgreSQLContainer.close();
        }
    }
}
