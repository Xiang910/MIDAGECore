package org.midage.midagecore;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.CustomKey;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class Config extends OkaeriConfig {

    @CustomKey("sql")
    private Sql sql = new Sql();

    @Getter
    @Accessors(fluent = true)
    public static class Sql extends OkaeriConfig {
        @CustomKey("host")
        private String host = "127.0.0.1";

        @CustomKey("port")
        private int port = 3306;

        @CustomKey("database")
        private String database = "my_database";

        @CustomKey("username")
        private String username = "my_user";

        @CustomKey("password")
        private String password = "my_password";

        @CustomKey("pool-size")
        private int poolSize = 10;
    }
}
