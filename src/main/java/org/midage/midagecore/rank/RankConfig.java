package org.midage.midagecore.rank;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.CustomKey;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class RankConfig extends OkaeriConfig {

    @CustomKey("default-rank")
    private String defaultRank = "member";
}
