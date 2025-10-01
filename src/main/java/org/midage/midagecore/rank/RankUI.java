package org.midage.midagecore.rank;

import org.allaymc.api.entity.interfaces.EntityPlayer;
import org.allaymc.api.form.Forms;
import org.allaymc.api.form.element.ImageData;
import org.allaymc.api.utils.TextFormat;

public class RankUI {

    public static void sendRankForm(EntityPlayer player) {
        Forms.simple()
                .header(TextFormat.YELLOW + "   Rank Manager      [ADMIN]")
                .label(TextFormat.GRAY + "A Rank Editor.")
                //https://pbs.twimg.com/profile_images/1766025145100185600/hn_LjV_t_400x400.jpg 可爱三咲
                .button(TextFormat.YELLOW + "Rank Editor", ImageData.ImageType.PATH, "textures/ui/book_edit_default.png")
                .onClick(button -> rankEditorForm(player))
                .divider()
                .button(TextFormat.GREEN + "Create a New Rank", ImageData.ImageType.PATH, "textures/ui/color_plus.png")
                // ui/confirm.png (绿色勾勾)
                .onClick(button -> rankCreatingForm(player))
                .button(TextFormat.MATERIAL_REDSTONE + "Delete a Rank", ImageData.ImageType.PATH, "textures/ui/icon_trash.png")
                .onClick(button -> rankDeletionForm(player))
                .sendTo(player);
    }

    public static void rankEditorForm(EntityPlayer player) {
        Forms.simple()
                .title(TextFormat.ITALIC + "Rank Manager [ADMIN]")
                .content(TextFormat.GRAY + "A Rank Editor ;-;")
                .sendTo(player);
        //todo
    }

    public static void rankCreatingForm(EntityPlayer player) {
        Forms.simple()
                .title(TextFormat.ITALIC + "Rank Manager [ADMIN]")
                .content(TextFormat.GRAY + "A Rank Create Panel (*￣▽￣*)")
                .sendTo(player);
        //todo
    }

    public static void rankDeletionForm(EntityPlayer player) {
        Forms.simple()
                .title(TextFormat.ITALIC + "Rank Manager [ADMIN]")
                .content(TextFormat.GRAY + "A Rank Deletion Panel (～﹃～)~zZ")
                .sendTo(player);
        //todo
    }
}
