package org.midage.midagecore.rank;

import org.allaymc.api.command.SenderType;
import org.allaymc.api.command.Command;
import org.allaymc.api.command.tree.CommandTree;
import org.allaymc.api.permission.PermissionGroups;

public class RankCommand extends Command {

    public RankCommand() {
        super("rank", "Rank Manager.");
        getPermissions().forEach(PermissionGroups.OPERATOR::addPermission);
    }

    @Override
    public void prepareCommandTree(CommandTree tree){
        tree.getRoot()
                .exec((context, player) -> {
                    RankUI.sendRankForm(player);
                    return context.success();
                }, SenderType.PLAYER);
    }
}
