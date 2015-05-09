package dracocore.proxies.handlers;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.EnumMap;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dracocore.CoreMain;
import dracocore.References;
import dracocore.blocks.tileentity.mana.crafting.TileEntityArcaneCraftingAltar;
import dracocore.blocks.tileentity.mana.crafting.TileEntityArcaneCraftingSlot;
import dracocore.blocks.tileentity.mana.crafting.TileEntityMagicalPlinth;
import dracocore.blocks.tileentity.mana.crafting.TileEntityRitualAltar;
import dracocore.blocks.tileentity.mana.upgrade.TileEntityRunicUpgradeT1;
import dracocore.blocks.tileentity.mana.upgrade.TileEntityRunicUpgradeT2;
import dracocore.blocks.tileentity.mana.upgrade.TileEntityRunicUpgradeT3;
import dracocore.blocks.tileentity.mana.upgrade.TileEntityRunicUpgradeT4;
import dracocore.blocks.tileentity.power.machine.TileEntityStoneSmasher;
import dracocore.network.IPacket;

public enum NewPacketHandler
{
	INSTANCE;

	private EnumMap<Side, FMLEmbeddedChannel> channels;

	private NewPacketHandler()
	{
		this.channels = NetworkRegistry.INSTANCE.newChannel(References.channel, new TEAltarCodec());
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
		{
			addClientHandler();
		}
	}
	
	@SideOnly(Side.CLIENT)
	private void addClientHandler()
	{
		FMLEmbeddedChannel clientChannel = this.channels.get(Side.CLIENT);
		
		String tileAltarCodec = clientChannel.findChannelHandlerNameForType(TEAltarCodec.class);

		clientChannel.pipeline().addAfter(tileAltarCodec, "TileEntityRitualAltarHandler", new TileEntityRitualAltarHandler());
		clientChannel.pipeline().addAfter(tileAltarCodec, "TileEntityArcaneCraftingAltar", new TileEntityArcaneCraftingAltarMessageHandler());
		clientChannel.pipeline().addAfter(tileAltarCodec, "TileEntityArcaneCraftingSlot", new TileEntityArcaneCraftingSlotMessageHandler());
		clientChannel.pipeline().addAfter(tileAltarCodec, "TileEntityMagicalPlinthHandler", new TileEntityMagicPlinthMessageHandler());
		clientChannel.pipeline().addAfter(tileAltarCodec, "TileEntityRunicUpgradeT1", new TileEntityRunicUpgradeT1MessageHandler());
		clientChannel.pipeline().addAfter(tileAltarCodec, "TileEntityRunicUpgradeT2", new TileEntityRunicUpgradeT2MessageHandler());
		clientChannel.pipeline().addAfter(tileAltarCodec, "TileEntityRunicUpgradeT3", new TileEntityRunicUpgradeT3MessageHandler());
		clientChannel.pipeline().addAfter(tileAltarCodec, "TileEntityRunicUpgradeT4", new TileEntityRunicUpgradeT4MessageHandler());
		clientChannel.pipeline().addAfter(tileAltarCodec, "TileEntityStoneSmasher", new TileEntityStoneSmasherHandler());
	}
	
	private static class TileEntityArcaneCraftingAltarMessageHandler extends SimpleChannelInboundHandler<TECraftingAltarMessage>
	{
		@Override
		protected void channelRead0(ChannelHandlerContext ctx, TECraftingAltarMessage msg) throws Exception
		{	
			World world = CoreMain.proxy.getClientWorld();
			TileEntity te = world.getTileEntity(msg.x, msg.y, msg.z);
			if(te instanceof TileEntityArcaneCraftingAltar)
			{
				TileEntityArcaneCraftingAltar altar = (TileEntityArcaneCraftingAltar) te;
				altar.handlePacketData(msg.items);
			}
			
		}
	}
	private static class TileEntityArcaneCraftingSlotMessageHandler extends SimpleChannelInboundHandler<TEArcaneCraftingSlotMessage>
	{
		@Override
		protected void channelRead0(ChannelHandlerContext ctx, TEArcaneCraftingSlotMessage msg) throws Exception
		{	
			World world = CoreMain.proxy.getClientWorld();
			TileEntity te = world.getTileEntity(msg.x, msg.y, msg.z);
			if(te instanceof TileEntityArcaneCraftingSlot)
			{
				TileEntityArcaneCraftingSlot altar = (TileEntityArcaneCraftingSlot) te;
				altar.handlePacketData(msg.items, msg.fluids, msg.capacity);
			}
		}
	}

	private static class TileEntityMagicPlinthMessageHandler extends SimpleChannelInboundHandler<TEMagicPlinthMessage>
	{
		@Override
		protected void channelRead0(ChannelHandlerContext ctx, TEMagicPlinthMessage msg) throws Exception
		{	
			World world = CoreMain.proxy.getClientWorld();
			TileEntity te = world.getTileEntity(msg.x, msg.y, msg.z);
			if (te instanceof TileEntityMagicalPlinth)
			{
				TileEntityMagicalPlinth altar = (TileEntityMagicalPlinth) te;
				altar.handlePacketData(msg.items, msg.fluids, msg.capacity);
			}
		}
	}
	private static class TileEntityRunicUpgradeT1MessageHandler extends SimpleChannelInboundHandler<TERunicUpgradeT1Message>
	{
		@Override
		protected void channelRead0(ChannelHandlerContext ctx, TERunicUpgradeT1Message msg) throws Exception
		{	
			World world = CoreMain.proxy.getClientWorld();
			TileEntity te = world.getTileEntity(msg.x, msg.y, msg.z);
			if (te instanceof TileEntityRunicUpgradeT1)
			{
				TileEntityRunicUpgradeT1 altar = (TileEntityRunicUpgradeT1) te;
				altar.handlePacketData(msg.items, msg.fluids, msg.capacity);
			}
		}
	}
	private static class TileEntityRunicUpgradeT2MessageHandler extends SimpleChannelInboundHandler<TERunicUpgradeT2Message>
	{
		@Override
		protected void channelRead0(ChannelHandlerContext ctx, TERunicUpgradeT2Message msg) throws Exception
		{	
			World world = CoreMain.proxy.getClientWorld();
			TileEntity te = world.getTileEntity(msg.x, msg.y, msg.z);
			if (te instanceof TileEntityRunicUpgradeT2)
			{
				TileEntityRunicUpgradeT2 altar = (TileEntityRunicUpgradeT2) te;
				altar.handlePacketData(msg.items, msg.fluids, msg.capacity);
			}
		}
	}
	private static class TileEntityRunicUpgradeT3MessageHandler extends SimpleChannelInboundHandler<TERunicUpgradeT3Message>
	{
		@Override
		protected void channelRead0(ChannelHandlerContext ctx, TERunicUpgradeT3Message msg) throws Exception
		{	
			World world = CoreMain.proxy.getClientWorld();
			TileEntity te = world.getTileEntity(msg.x, msg.y, msg.z);
			if (te instanceof TileEntityRunicUpgradeT3)
			{
				TileEntityRunicUpgradeT3 altar = (TileEntityRunicUpgradeT3) te;
				altar.handlePacketData(msg.items, msg.fluids, msg.capacity);
			}
		}
	}
	private static class TileEntityRunicUpgradeT4MessageHandler extends SimpleChannelInboundHandler<TERunicUpgradeT4Message>
	{
		@Override
		protected void channelRead0(ChannelHandlerContext ctx, TERunicUpgradeT4Message msg) throws Exception
		{	
			World world = CoreMain.proxy.getClientWorld();
			TileEntity te = world.getTileEntity(msg.x, msg.y, msg.z);
			if (te instanceof TileEntityRunicUpgradeT4)
			{
				TileEntityRunicUpgradeT4 altar = (TileEntityRunicUpgradeT4) te;
				altar.handlePacketData(msg.items, msg.fluids, msg.capacity);
			}
		}
	}
	
	private static class TileEntityRitualAltarHandler extends SimpleChannelInboundHandler<TEAltarMessage>
	{
		@Override
		protected void channelRead0(ChannelHandlerContext ctx, TEAltarMessage msg) throws Exception
		{	
			World world = CoreMain.proxy.getClientWorld();
			TileEntity te = world.getTileEntity(msg.x, msg.y, msg.z);
			
			if (te instanceof TileEntityRitualAltar)
			{
				TileEntityRitualAltar altar = (TileEntityRitualAltar) te;
				altar.handlePacketData(msg.items);
                System.out.println("Getting Called!");
			}
		}
	}
	private static class TileEntityStoneSmasherHandler extends SimpleChannelInboundHandler<TEAltarMessage>
	{
		@Override
		protected void channelRead0(ChannelHandlerContext ctx, TEAltarMessage msg) throws Exception
		{	
			World world = CoreMain.proxy.getClientWorld();
			TileEntity te = world.getTileEntity(msg.x, msg.y, msg.z);
			
			if (te instanceof TileEntityRitualAltar)
			{
				TileEntityRitualAltar altar = (TileEntityRitualAltar) te;
				altar.handlePacketData(msg.items);
			}
		}
	}
	public static class BMMessage
	{
	int index;
	}
	public static class TEStoneSmasherMessage extends BMMessage
	{
		int x;
		int y;
		int z;
		int[] items;
	}
	public static class TEAltarMessage extends BMMessage
	{
		int x;
		int y;
		int z;
		int[] items;
	}
	public static class TECraftingAltarMessage extends BMMessage
	{
		int x;
		int y;
		int z;
		int[] items;
	}
	public static class TEArcaneCraftingSlotMessage extends BMMessage
	{
		int x;
		int y;
		int z;
		int[] items;
		int[] fluids;
		int capacity;
	}
	public static class TEMagicPlinthMessage extends BMMessage
	{
		int x;
		int y;
		int z;
		int[] items;
		int[] fluids;
		int capacity;
	}
	public static class TERunicUpgradeT1Message extends BMMessage
	{
		int x;
		int y;
		int z;
		int[] items;
		int[] fluids;
		int capacity;
	}
	public static class TERunicUpgradeT2Message extends BMMessage
	{
		int x;
		int y;
		int z;
		int[] items;
		int[] fluids;
		int capacity;
	}
	public static class TERunicUpgradeT3Message extends BMMessage
	{
		int x;
		int y;
		int z;
		int[] items;
		int[] fluids;
		int capacity;
	}
	public static class TERunicUpgradeT4Message extends BMMessage
	{
		int x;
		int y;
		int z;
		int[] items;
		int[] fluids;
		int capacity;
	}
	public static class TileEntityManaPipe extends BMMessage
	{
		int x;
		int y;
		int z;
		int stored;
		int capacity;
	}
	private class TEAltarCodec extends FMLIndexedMessageToMessageCodec<BMMessage>
	{
		public TEAltarCodec()
		{
			addDiscriminator(0, TEAltarMessage.class);
			addDiscriminator(1, TECraftingAltarMessage.class);
			addDiscriminator(2, TEArcaneCraftingSlotMessage.class);
			addDiscriminator(3, TEMagicPlinthMessage.class);
			addDiscriminator(4, TERunicUpgradeT1Message.class);
			addDiscriminator(5, TERunicUpgradeT2Message.class);
			addDiscriminator(6, TERunicUpgradeT3Message.class);
			addDiscriminator(7, TERunicUpgradeT4Message.class);
			addDiscriminator(8, TEStoneSmasherMessage.class);
		}
		@Override
		public void encodeInto(ChannelHandlerContext ctx, BMMessage msg, ByteBuf target) throws Exception
		{
			target.writeInt(msg.index);
			switch (msg.index)
			{
			case 0:
				target.writeInt(((TEAltarMessage) msg).x);
				target.writeInt(((TEAltarMessage) msg).y);
				target.writeInt(((TEAltarMessage) msg).z);
				target.writeBoolean(((TEAltarMessage) msg).items != null);
				if (((TEAltarMessage) msg).items != null)
				{
					int[] items = ((TEAltarMessage) msg).items;
					for (int j = 0; j < items.length; j++)
					{
						int i = items[j];
						target.writeInt(i);
					}
				}
				break;
			case 1:
				target.writeInt(((TECraftingAltarMessage) msg).x);
				target.writeInt(((TECraftingAltarMessage) msg).y);
				target.writeInt(((TECraftingAltarMessage) msg).z);
				target.writeBoolean(((TECraftingAltarMessage) msg).items != null);
				if (((TECraftingAltarMessage) msg).items != null)
				{
					int[] items = ((TECraftingAltarMessage) msg).items;
					for (int j = 0; j < items.length; j++)
					{
						int i = items[j];
						target.writeInt(i);
					}
				}
				break;
			case 2:
				target.writeInt(((TEArcaneCraftingSlotMessage) msg).x);
				target.writeInt(((TEArcaneCraftingSlotMessage) msg).y);
				target.writeInt(((TEArcaneCraftingSlotMessage) msg).z);
				target.writeBoolean(((TEArcaneCraftingSlotMessage) msg).items != null);
				if (((TEArcaneCraftingSlotMessage) msg).items != null)
				{
					int[] items = ((TEArcaneCraftingSlotMessage) msg).items;
					for (int j = 0; j < items.length; j++)
					{
						int i = items[j];
						target.writeInt(i);
					}
				}
				break;
			case 3:
				target.writeInt(((TEMagicPlinthMessage) msg).x);
				target.writeInt(((TEMagicPlinthMessage) msg).y);
				target.writeInt(((TEMagicPlinthMessage) msg).z);
				target.writeBoolean(((TEMagicPlinthMessage) msg).items != null);
				if (((TEMagicPlinthMessage) msg).items != null)
				{
					int[] items = ((TEMagicPlinthMessage) msg).items;
					for (int j = 0; j < items.length; j++)
					{
						int i = items[j];
						target.writeInt(i);
					}
				}
				break;
			case 4:
				target.writeInt(((TERunicUpgradeT1Message) msg).x);
				target.writeInt(((TERunicUpgradeT1Message) msg).y);
				target.writeInt(((TERunicUpgradeT1Message) msg).z);
				target.writeBoolean(((TERunicUpgradeT1Message) msg).items != null);
				if (((TERunicUpgradeT1Message) msg).items != null)
				{
					int[] items = ((TERunicUpgradeT1Message) msg).items;
					for (int j = 0; j < items.length; j++)
					{
						int i = items[j];
						target.writeInt(i);
					}
				}
				break;
			case 5:
				target.writeInt(((TERunicUpgradeT2Message) msg).x);
				target.writeInt(((TERunicUpgradeT2Message) msg).y);
				target.writeInt(((TERunicUpgradeT2Message) msg).z);
				target.writeBoolean(((TERunicUpgradeT2Message) msg).items != null);
				if (((TERunicUpgradeT2Message) msg).items != null)
				{
					int[] items = ((TERunicUpgradeT2Message) msg).items;
					for (int j = 0; j < items.length; j++)
					{
						int i = items[j];
						target.writeInt(i);
					}
				}
				break;
			case 6:
				target.writeInt(((TERunicUpgradeT3Message) msg).x);
				target.writeInt(((TERunicUpgradeT3Message) msg).y);
				target.writeInt(((TERunicUpgradeT3Message) msg).z);
				target.writeBoolean(((TERunicUpgradeT3Message) msg).items != null);
				if (((TERunicUpgradeT3Message) msg).items != null)
				{
					int[] items = ((TERunicUpgradeT3Message) msg).items;
					for (int j = 0; j < items.length; j++)
					{
						int i = items[j];
						target.writeInt(i);
					}
				}
				break;
			case 7:
				target.writeInt(((TERunicUpgradeT4Message) msg).x);
				target.writeInt(((TERunicUpgradeT4Message) msg).y);
				target.writeInt(((TERunicUpgradeT4Message) msg).z);
				target.writeBoolean(((TERunicUpgradeT4Message) msg).items != null);
				if (((TERunicUpgradeT4Message) msg).items != null)
				{
					int[] items = ((TERunicUpgradeT4Message) msg).items;
					for (int j = 0; j < items.length; j++)
					{
						int i = items[j];
						target.writeInt(i);
					}
				}
				break;
			case 8:
				target.writeInt(((TEStoneSmasherMessage) msg).x);
				target.writeInt(((TEStoneSmasherMessage) msg).y);
				target.writeInt(((TEStoneSmasherMessage) msg).z);
				target.writeBoolean(((TEStoneSmasherMessage) msg).items != null);
				if (((TEStoneSmasherMessage) msg).items != null)
				{
					int[] items = ((TEStoneSmasherMessage) msg).items;
					for (int j = 0; j < items.length; j++)
					{
						int i = items[j];
						target.writeInt(i);
					}
				}
				break;
			}
		}
		@Override
		public void decodeInto(ChannelHandlerContext ctx, ByteBuf dat, BMMessage msg)
		{
			int index = dat.readInt();
			switch (index)
			{
			case 0:
				((TEAltarMessage) msg).x = dat.readInt();
				((TEAltarMessage) msg).y = dat.readInt();
				((TEAltarMessage) msg).z = dat.readInt();
				boolean hasStacks = dat.readBoolean();
				((TEAltarMessage) msg).items = new int[TileEntityRitualAltar.sizeInv * 3];
				if (hasStacks)
				{
					((TEAltarMessage) msg).items = new int[TileEntityRitualAltar.sizeInv * 3];
					for (int i = 0; i < ((TEAltarMessage) msg).items.length; i++)
					{
						((TEAltarMessage) msg).items[i] = dat.readInt();
					}
				}
				break;
			case 1:
				((TECraftingAltarMessage) msg).x = dat.readInt();
				((TECraftingAltarMessage) msg).y = dat.readInt();
				((TECraftingAltarMessage) msg).z = dat.readInt();
				boolean hasStacks1 = dat.readBoolean();
				((TECraftingAltarMessage) msg).items = new int[TileEntityArcaneCraftingAltar.sizeInv * 3];
				if (hasStacks1)
				{
					((TECraftingAltarMessage) msg).items = new int[TileEntityArcaneCraftingAltar.sizeInv * 3];
					for (int i = 0; i < ((TECraftingAltarMessage) msg).items.length; i++)
					{
						((TECraftingAltarMessage) msg).items[i] = dat.readInt();
					}
				}
				break;
			case 2:
				((TEArcaneCraftingSlotMessage) msg).x = dat.readInt();
				((TEArcaneCraftingSlotMessage) msg).y = dat.readInt();
				((TEArcaneCraftingSlotMessage) msg).z = dat.readInt();
				boolean hasStacks2 = dat.readBoolean();
				((TEArcaneCraftingSlotMessage) msg).items = new int[TileEntityArcaneCraftingSlot.sizeInv * 3];
				if (hasStacks2)
				{
					((TEArcaneCraftingSlotMessage) msg).items = new int[TileEntityArcaneCraftingSlot.sizeInv * 3];
					for (int i = 0; i < ((TEArcaneCraftingSlotMessage) msg).items.length; i++)
					{
						((TEArcaneCraftingSlotMessage) msg).items[i] = dat.readInt();
					}
				}
				break;
			case 3:
				((TEMagicPlinthMessage) msg).x = dat.readInt();
				((TEMagicPlinthMessage) msg).y = dat.readInt();
				((TEMagicPlinthMessage) msg).z = dat.readInt();
				boolean hasStacks3 = dat.readBoolean();
				((TEMagicPlinthMessage) msg).items = new int[TileEntityMagicalPlinth.sizeInv * 3];
				if (hasStacks3)
				{
					((TEMagicPlinthMessage) msg).items = new int[TileEntityMagicalPlinth.sizeInv * 3];
					for (int i = 0; i < ((TEMagicPlinthMessage) msg).items.length; i++)
					{
						((TEMagicPlinthMessage) msg).items[i] = dat.readInt();
					}
				}
				break;
			case 4:
				((TERunicUpgradeT1Message) msg).x = dat.readInt();
				((TERunicUpgradeT1Message) msg).y = dat.readInt();
				((TERunicUpgradeT1Message) msg).z = dat.readInt();
				boolean hasStacks4 = dat.readBoolean();
				((TERunicUpgradeT1Message) msg).items = new int[TileEntityRunicUpgradeT1.sizeInv * 3];
				if (hasStacks4)
				{
					((TERunicUpgradeT1Message) msg).items = new int[TileEntityRunicUpgradeT1.sizeInv * 3];
					for (int i = 0; i < ((TERunicUpgradeT1Message) msg).items.length; i++)
					{
						((TERunicUpgradeT1Message) msg).items[i] = dat.readInt();
					}
				}
				break;
			case 5:
				((TERunicUpgradeT2Message) msg).x = dat.readInt();
				((TERunicUpgradeT2Message) msg).y = dat.readInt();
				((TERunicUpgradeT2Message) msg).z = dat.readInt();
				boolean hasStacks5 = dat.readBoolean();
				((TERunicUpgradeT2Message) msg).items = new int[TileEntityRunicUpgradeT2.sizeInv * 3];
				if (hasStacks5)
				{
					((TERunicUpgradeT2Message) msg).items = new int[TileEntityRunicUpgradeT2.sizeInv * 3];
					for (int i = 0; i < ((TERunicUpgradeT2Message) msg).items.length; i++)
					{
						((TERunicUpgradeT2Message) msg).items[i] = dat.readInt();
					}
				}
				break;
			case 6:
				((TERunicUpgradeT3Message) msg).x = dat.readInt();
				((TERunicUpgradeT3Message) msg).y = dat.readInt();
				((TERunicUpgradeT3Message) msg).z = dat.readInt();
				boolean hasStacks6 = dat.readBoolean();
				((TERunicUpgradeT3Message) msg).items = new int[TileEntityRunicUpgradeT3.sizeInv * 3];
				if (hasStacks6)
				{
					((TERunicUpgradeT3Message) msg).items = new int[TileEntityRunicUpgradeT3.sizeInv * 3];
					for (int i = 0; i < ((TERunicUpgradeT3Message) msg).items.length; i++)
					{
						((TERunicUpgradeT3Message) msg).items[i] = dat.readInt();
					}
				}
				break;
			case 7:
				((TERunicUpgradeT4Message) msg).x = dat.readInt();
				((TERunicUpgradeT4Message) msg).y = dat.readInt();
				((TERunicUpgradeT4Message) msg).z = dat.readInt();
				boolean hasStacks7 = dat.readBoolean();
				((TERunicUpgradeT4Message) msg).items = new int[TileEntityRunicUpgradeT4.sizeInv * 3];
				if (hasStacks7)
				{
					((TERunicUpgradeT4Message) msg).items = new int[TileEntityRunicUpgradeT4.sizeInv * 3];
					for (int i = 0; i < ((TERunicUpgradeT4Message) msg).items.length; i++)
					{
						((TERunicUpgradeT4Message) msg).items[i] = dat.readInt();
					}
				}
				break;
			}
		}
	}
	//Packets to be obtained
	public static Packet getPacket(TileEntityRitualAltar tileRitualAltar)
	{
		TEAltarMessage msg = new TEAltarMessage();
		msg.index = 0;
		msg.x = tileRitualAltar.xCoord;
		msg.y = tileRitualAltar.yCoord;
		msg.z = tileRitualAltar.zCoord;
		msg.items = tileRitualAltar.buildIntDataList();
		return INSTANCE.channels.get(Side.SERVER).generatePacketFrom(msg);
	}
	public static Packet getPacket(TileEntityArcaneCraftingAltar tileCraftingAltar)
	{
		TECraftingAltarMessage msg1 = new TECraftingAltarMessage();
		msg1.index = 1;
		msg1.x = tileCraftingAltar.xCoord;
		msg1.y = tileCraftingAltar.yCoord;
		msg1.z = tileCraftingAltar.zCoord;
		msg1.items = tileCraftingAltar.buildIntDataList();
		return INSTANCE.channels.get(Side.SERVER).generatePacketFrom(msg1);
	}
	public static Packet getPacket(TileEntityArcaneCraftingSlot tileCraftingSlot)
	{
		TEArcaneCraftingSlotMessage msg2 = new TEArcaneCraftingSlotMessage();
		msg2.index = 2;
		msg2.x = tileCraftingSlot.xCoord;
		msg2.y = tileCraftingSlot.yCoord;
		msg2.z = tileCraftingSlot.zCoord;
		msg2.items = tileCraftingSlot.buildIntDataList();
		return INSTANCE.channels.get(Side.SERVER).generatePacketFrom(msg2);
	}
	public static Packet getPacket(TileEntityMagicalPlinth tileMagicalPlinth)
	{
		TEMagicPlinthMessage msg3 = new TEMagicPlinthMessage();
		msg3.index = 3;
		msg3.x = tileMagicalPlinth.xCoord;
		msg3.y = tileMagicalPlinth.yCoord;
		msg3.z = tileMagicalPlinth.zCoord;
		msg3.items = tileMagicalPlinth.buildIntDataList();
		return INSTANCE.channels.get(Side.SERVER).generatePacketFrom(msg3);
	}
	public static Packet getPacket(TileEntityRunicUpgradeT1 tileRunicUpgradeT1)
	{
		TERunicUpgradeT1Message msg4 = new TERunicUpgradeT1Message();
		msg4.index = 4;
		msg4.x = tileRunicUpgradeT1.xCoord;
		msg4.y = tileRunicUpgradeT1.yCoord;
		msg4.z = tileRunicUpgradeT1.zCoord;
		msg4.items = tileRunicUpgradeT1.buildIntDataList();
		return INSTANCE.channels.get(Side.SERVER).generatePacketFrom(msg4);
	}
	public static Packet getPacket(TileEntityRunicUpgradeT2 tileRunicUpgradeT2)
	{
		TERunicUpgradeT2Message msg5 = new TERunicUpgradeT2Message();
		msg5.index = 5;
		msg5.x = tileRunicUpgradeT2.xCoord;
		msg5.y = tileRunicUpgradeT2.yCoord;
		msg5.z = tileRunicUpgradeT2.zCoord;
		msg5.items = tileRunicUpgradeT2.buildIntDataList();
		return INSTANCE.channels.get(Side.SERVER).generatePacketFrom(msg5);
	}
	public static Packet getPacket(TileEntityRunicUpgradeT3 tileRunicUpgradeT3)
	{
		TERunicUpgradeT3Message msg6 = new TERunicUpgradeT3Message();
		msg6.index = 6;
		msg6.x = tileRunicUpgradeT3.xCoord;
		msg6.y = tileRunicUpgradeT3.yCoord;
		msg6.z = tileRunicUpgradeT3.zCoord;
		msg6.items = tileRunicUpgradeT3.buildIntDataList();
		return INSTANCE.channels.get(Side.SERVER).generatePacketFrom(msg6);
	}
	public static Packet getPacket(TileEntityRunicUpgradeT4 tileRunicUpgradeT4)
	{
		TERunicUpgradeT4Message msg7 = new TERunicUpgradeT4Message();
		msg7.index = 7;
		msg7.x = tileRunicUpgradeT4.xCoord;
		msg7.y = tileRunicUpgradeT4.yCoord;
		msg7.z = tileRunicUpgradeT4.zCoord;
		msg7.items = tileRunicUpgradeT4.buildIntDataList();
		return INSTANCE.channels.get(Side.SERVER).generatePacketFrom(msg7);
	}
	public static Packet getPacket(TileEntityStoneSmasher tileRitualAltar)
	{
		TEStoneSmasherMessage msg = new TEStoneSmasherMessage();
		msg.index = 8;
		msg.x = tileRitualAltar.xCoord;
		msg.y = tileRitualAltar.yCoord;
		msg.z = tileRitualAltar.zCoord;
		msg.items = tileRitualAltar.buildIntDataList();
		return INSTANCE.channels.get(Side.SERVER).generatePacketFrom(msg);
	}
	public void sendTo(Packet message, EntityPlayerMP player)
	{
		this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
		this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
		this.channels.get(Side.SERVER).writeAndFlush(message);
	}
	public void sendToServer(IPacket message)
	{
		this.channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
		this.channels.get(Side.CLIENT).writeOutbound(message);
	}
	public void sendToAll(Packet message)
	{
		this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
		this.channels.get(Side.SERVER).writeAndFlush(message);
	}
	public void sendToAllAround(Packet message, NetworkRegistry.TargetPoint point)
	{
		this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
		this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
		this.channels.get(Side.SERVER).writeAndFlush(message);
	}
	public void sendPipeToAllAround(IPacket message, NetworkRegistry.TargetPoint point)
    {
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
        this.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
        this.channels.get(Side.SERVER).writeOutbound(message);
    }
}