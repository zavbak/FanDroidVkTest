package ru.a799000.android.fandroidvktest.common.utils;




import java.util.List;

import ru.a799000.android.fandroidvktest.model.Owner;
import ru.a799000.android.fandroidvktest.model.WallItem;
import ru.a799000.android.fandroidvktest.rest.model.response.ItemsWithSendersResponse;


public class VkListHelper {
    public static List<WallItem> getWallList(ItemsWithSendersResponse<WallItem> response) {
        List<WallItem> wallItems = response.items;

        for (WallItem wallItem : wallItems) {
            Owner sender = response.getSender(wallItem.getFromId());
            wallItem.setSenderName(sender.getFullName());
            wallItem.setSenderPhoto(sender.getPhoto());

            wallItem.setAttachmentsString(Utils
                    .convertAttachmentsToFontIcons(wallItem.getApiAttachments()));

            if (wallItem.haveSharedRepost()) {
                Owner repostSender = response.getSender(wallItem.getSharedRepost().getFromId());
                wallItem.getSharedRepost().setSenderName(repostSender.getFullName());
                wallItem.getSharedRepost().setSenderPhoto(repostSender.getPhoto());

                wallItem.getSharedRepost().setAttachmentsString(Utils
                        .convertAttachmentsToFontIcons(wallItem.getSharedRepost().getApiAttachments()));
            }
        }
        return wallItems;
    }
}
