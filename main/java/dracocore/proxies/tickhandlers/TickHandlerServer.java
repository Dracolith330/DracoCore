package dracocore.proxies.tickhandlers;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.WorldTickEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import dracocore.api.power.EnergyNetwork;
import dracocore.api.vector.BlockVec3;
import dracocore.blocks.tileentity.mana.crystal.TileBaseManaTransducer;
import dracocore.energy.tile.TileBaseConductor;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkProviderServer;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TickHandlerServer
{
    private static Map<Integer, CopyOnWriteArrayList<ScheduledBlockChange>> scheduledBlockChanges = new ConcurrentHashMap<Integer, CopyOnWriteArrayList<ScheduledBlockChange>>();
    private static Map<Integer, List<BlockVec3>> edgeChecks = new HashMap<Integer, List<BlockVec3>>();
    private static LinkedList<EnergyNetwork> networkTicks = new LinkedList<EnergyNetwork>();
    public static ArrayList<EntityPlayerMP> playersRequestingMapData = Lists.newArrayList();
    private static long tickCount;
	public static LinkedList<TileBaseConductor> energyTransmitterUpdates  = new LinkedList<TileBaseConductor>();
	public static LinkedList<TileBaseManaTransducer> manaTransmitterUpdates  = new LinkedList<TileBaseManaTransducer>();
	
    public static void restart()
    {
        TickHandlerServer.scheduledBlockChanges.clear();
        TickHandlerServer.edgeChecks.clear();
        TickHandlerServer.networkTicks.clear();
        TickHandlerServer.tickCount = 0L;
    }

    public static void scheduleNewBlockChange(int dimID, ScheduledBlockChange change)
    {
        CopyOnWriteArrayList<ScheduledBlockChange> changeList = TickHandlerServer.scheduledBlockChanges.get(dimID);

        if (changeList == null)
        {
            changeList = new CopyOnWriteArrayList<ScheduledBlockChange>();
        }

        changeList.add(change);
        TickHandlerServer.scheduledBlockChanges.put(dimID, changeList);
    }

    public static void scheduleNewBlockChange(int dimID, List<ScheduledBlockChange> changeAdd)
    {
        CopyOnWriteArrayList<ScheduledBlockChange> changeList = TickHandlerServer.scheduledBlockChanges.get(dimID);

        if (changeList == null)
        {
            changeList = new CopyOnWriteArrayList<ScheduledBlockChange>();
        }

        changeList.addAll(changeAdd);
        TickHandlerServer.scheduledBlockChanges.put(dimID, changeList);
    }

    public static void scheduleNewEdgeCheck(int dimID, BlockVec3 edgeBlock)
    {
        List<BlockVec3> updateList = TickHandlerServer.edgeChecks.get(dimID);

        if (updateList == null)
        {
            updateList = new ArrayList<BlockVec3>();
        }

        updateList.add(edgeBlock);
        TickHandlerServer.edgeChecks.put(dimID, updateList);
    }

    public static boolean scheduledForChange(int dimID, BlockVec3 test)
    {
        CopyOnWriteArrayList<ScheduledBlockChange> changeList = TickHandlerServer.scheduledBlockChanges.get(dimID);

        if (changeList != null)
        {
            for (ScheduledBlockChange change : changeList)
            {
                if (test.equals(change.getChangePosition()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void scheduleNetworkTick(EnergyNetwork grid)
    {
        TickHandlerServer.networkTicks.add(grid);
    }

    public static void removeNetworkTick(EnergyNetwork grid)
    {
        TickHandlerServer.networkTicks.remove(grid);
    }

    @SubscribeEvent
    public void onServerTick(ServerTickEvent event)
    {
        if (event.phase == Phase.START)
        {
            if (tickCount % 20 == 0)
            {
                if (!playersRequestingMapData.isEmpty())
                {
                    ArrayList<EntityPlayerMP> copy = new ArrayList<EntityPlayerMP>(playersRequestingMapData);
                    for (EntityPlayerMP playerMP : copy)
                    {
                    }

                    playersRequestingMapData.removeAll(copy);
                }
            }

            TickHandlerServer.tickCount++;

            if (TickHandlerServer.tickCount >= Long.MAX_VALUE)
            {
                TickHandlerServer.tickCount = 0;
            }

            EnergyNetwork.tickCount++;
        }
        else if (event.phase == Phase.END)
        {
            int maxPasses = 10;
            while (!TickHandlerServer.networkTicks.isEmpty())
            {
                LinkedList<EnergyNetwork> pass = new LinkedList();
                pass.addAll(TickHandlerServer.networkTicks);
                TickHandlerServer.networkTicks.clear();
                for (EnergyNetwork grid : pass)
                {
                    grid.tickEnd();
                }

                if (--maxPasses <= 0)
                {
                    break;
                }
            }

            maxPasses = 10;
            while (!TickHandlerServer.energyTransmitterUpdates.isEmpty())
            {
                LinkedList<TileBaseConductor> pass = new LinkedList();
                pass.addAll(TickHandlerServer.energyTransmitterUpdates);
                TickHandlerServer.energyTransmitterUpdates.clear();
                for (TileBaseConductor newTile : pass)
                {
                	if (!newTile.isInvalid()) newTile.refresh();
                }            

                if (--maxPasses <= 0)
                {
                    break;
                }
            }
            
            maxPasses = 10;
            while (!TickHandlerServer.manaTransmitterUpdates.isEmpty())
            {
                LinkedList<TileBaseManaTransducer> pass = new LinkedList();
                pass.addAll(TickHandlerServer.manaTransmitterUpdates);
                TickHandlerServer.energyTransmitterUpdates.clear();
                for (TileBaseManaTransducer newTile : pass)
                {
                	if (!newTile.isInvalid()) newTile.refresh();
                }            

                if (--maxPasses <= 0)
                {
                    break;
                }
            }
        }
    }

    @SubscribeEvent
    public void onWorldTick(WorldTickEvent event)
    {
        if (event.phase == Phase.START)
        {
            final WorldServer world = (WorldServer) event.world;

            CopyOnWriteArrayList<ScheduledBlockChange> changeList = TickHandlerServer.scheduledBlockChanges.get(world.provider.dimensionId);

            if (changeList != null && !changeList.isEmpty())
            {
                for (ScheduledBlockChange change : changeList)
                {
                    if (change != null)
                    {
                        BlockVec3 changePosition = change.getChangePosition();
                        if (changePosition != null)
                        {
                            world.setBlock(changePosition.x, changePosition.y, changePosition.z, change.getChangeID(), change.getChangeMeta(), 2);
                        }
                    }
                }

                changeList.clear();
                TickHandlerServer.scheduledBlockChanges.remove(world.provider.dimensionId);
            }

        }
        else if (event.phase == Phase.END)
        {
            final WorldServer world = (WorldServer) event.world;

            List<BlockVec3> edgesList = TickHandlerServer.edgeChecks.get(world.provider.dimensionId);
            final HashSet<BlockVec3> checkedThisTick = new HashSet();

            if (edgesList != null && !edgesList.isEmpty())
            {
                List<BlockVec3> edgesListCopy = new ArrayList();
                edgesListCopy.addAll(edgesList);
                for (BlockVec3 edgeBlock : edgesListCopy)
                {
                    if (edgeBlock != null && !checkedThisTick.contains(edgeBlock))
                    {
                        if (TickHandlerServer.scheduledForChange(world.provider.dimensionId, edgeBlock))
                        {
                            continue;
                        }

                    }
                }

                TickHandlerServer.edgeChecks.remove(world.provider.dimensionId);
            }
        }
    }
}
