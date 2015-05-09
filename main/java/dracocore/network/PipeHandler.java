package dracocore.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.EnumMap;

import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import dracocore.References;
import dracocore.blocks.blockclasses.PacketSimple;

public class PipeHandler extends FMLIndexedMessageToMessageCodec<IPacket>
{
    private EnumMap<Side, FMLEmbeddedChannel> channels;

    private PipeHandler()
    {
        this.addDiscriminator(-1, PacketSimple.class);
        this.addDiscriminator(-2, PacketDynamic.class);
    }

    public static PipeHandler init()
    {
        PipeHandler channelHandler = new PipeHandler();
        channelHandler.channels = NetworkRegistry.INSTANCE.newChannel(References.modid, channelHandler, new PipeHandler());
        return channelHandler;
    }

    @Override
    public void encodeInto(ChannelHandlerContext ctx, IPacket msg, ByteBuf target) throws Exception
    {
        msg.encodeInto(ctx, target);
    }

    @Override
    public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, IPacket msg)
    {
        msg.decodeInto(ctx, source);
    }

    /**
     * Send this message to everyone.
     * <p/>
     * Adapted from CPW's code in
     * cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
     *
     * @param message The message to send
     */
    public void sendToAll(IPacket message)
    {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
        this.channels.get(Side.SERVER).writeOutbound(message);
    }

    /**
     * Send this message to the specified player.
     * <p/>
     * Adapted from CPW's code in
     * cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
     *
     * @param message The message to send
     * @param player  The player to send it to
     */
    public void sendTo(IPacket message, EntityPlayerMP player)
    {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
        this.channels.get(Side.SERVER).writeOutbound(message);
    }

    /**
     * Send this message to everyone within a certain range of a point.
     * <p/>
     * Adapted from CPW's code in
     * cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
     *
     * @param message The message to send
     * @param point   The
     *                {@link cpw.mods.fml.common.network.NetworkRegistry.TargetPoint}
     *                around which to send
     */
    public void sendToAllAround(IPacket message, NetworkRegistry.TargetPoint point)
    {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
        this.channels.get(Side.SERVER).writeOutbound(message);
    }

    /**
     * Send this message to everyone within the supplied dimension.
     * <p/>
     * Adapted from CPW's code in
     * cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
     *
     * @param message     The message to send
     * @param dimensionId The dimension id to target
     */
    public void sendToDimension(IPacket message, int dimensionId)
    {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.DIMENSION);
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(dimensionId);
        this.channels.get(Side.SERVER).writeOutbound(message);
    }

    /**
     * Send this message to the server.
     * <p/>
     * Adapted from CPW's code in
     * cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper
     *
     * @param message The message to send
     */
    public void sendToServer(IPacket message)
    {
        this.channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
        this.channels.get(Side.CLIENT).writeOutbound(message);
    }
}
