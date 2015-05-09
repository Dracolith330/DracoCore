package dracocore.handbook.core;

import net.minecraft.util.EnumChatFormatting;

public class KnowledgeType {

    public final String id;
    public final EnumChatFormatting color;
    public final boolean autoUnlock;

    public KnowledgeType(String id, EnumChatFormatting color, boolean autoUnlock) {
        this.id = id;
        this.color = color;
        this.autoUnlock = autoUnlock;
    }

    public String getUnlocalizedName() {
        return "dracocore.knowledge." + id;
    }
}
