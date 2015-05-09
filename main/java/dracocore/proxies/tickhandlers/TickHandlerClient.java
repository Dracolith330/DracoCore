package dracocore.proxies.tickhandlers;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import scala.swing.event.Key;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import dracocore.handbook.CategoryManager;
import dracocore.handbook.LexiconData;
import dracocore.handbook.gui.GuiLexicon;

public class TickHandlerClient
{
    public static boolean checkedVersion = true;
    private static boolean lastInvKeyPressed;
    private static long tickCount;
	public static int pageFlipTicks = 0;
	public static int ticksWithLexicaOpen = 0;
    public static int ticksInGame = 0;


    static
    {
    	
    }
    public static void notifyPageChange() {
		if(pageFlipTicks == 0)
			pageFlipTicks = 5;
	}
    @SubscribeEvent
    public void onRenderTick(RenderTickEvent event)
    {
        final Minecraft minecraft = FMLClientHandler.instance().getClient();
        final EntityPlayerSP player = minecraft.thePlayer;

        if (event.phase == Phase.END)
        {
        	
        }       
    }

    @SubscribeEvent
    public void onPreGuiRender(RenderGameOverlayEvent.Pre event)
    {
        final Minecraft minecraft = FMLClientHandler.instance().getClient();
        final EntityClientPlayerMP player = minecraft.thePlayer;

        if (event.type == RenderGameOverlayEvent.ElementType.ALL)
        {
        }
    }

    @SubscribeEvent
    public void onClientTick(ClientTickEvent event)
    {
        final Minecraft minecraft = FMLClientHandler.instance().getClient();
        final WorldClient world = minecraft.theWorld;
        final EntityClientPlayerMP player = minecraft.thePlayer;

        if (event.phase == Phase.START)
        {
            if (TickHandlerClient.tickCount >= Long.MAX_VALUE)
            {
                TickHandlerClient.tickCount = 0;
            }

            TickHandlerClient.tickCount++;

            if (TickHandlerClient.tickCount % 20 == 0)
            {
            	
            }

            if (minecraft.currentScreen != null && minecraft.currentScreen instanceof GuiMainMenu)
            {
            	
            }

            if (world != null && TickHandlerClient.checkedVersion)
            {
            	
            }

            if (world != null)
            {
            	
            }

            }

            if (world != null)
            {
                List entityList = world.loadedEntityList;             
                for (Object e : entityList)
                {
                	
                }
            }

    }
    @SubscribeEvent
	public void clientTickEnd(ClientTickEvent event) {
		if(event.phase == Phase.END) 
		{
			GuiScreen gui = Minecraft.getMinecraft().currentScreen;
			if(gui == null || !gui.doesGuiPauseGame()) 
			{
				ticksInGame++;
			}
			
		}
		
    }
    private void drawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6)
    {
        float f = (par5 >> 24 & 255) / 255.0F;
        float f1 = (par5 >> 16 & 255) / 255.0F;
        float f2 = (par5 >> 8 & 255) / 255.0F;
        float f3 = (par5 & 255) / 255.0F;
        float f4 = (par6 >> 24 & 255) / 255.0F;
        float f5 = (par6 >> 16 & 255) / 255.0F;
        float f6 = (par6 >> 8 & 255) / 255.0F;
        float f7 = (par6 & 255) / 255.0F;
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(f1, f2, f3, f);
        tessellator.addVertex(par3, par2, 0.0D);
        tessellator.addVertex(par1, par2, 0.0D);
        tessellator.setColorRGBA_F(f5, f6, f7, f4);
        tessellator.addVertex(par1, par4, 0.0D);
        tessellator.addVertex(par3, par4, 0.0D);
        tessellator.draw();
        GL11.glShadeModel(GL11.GL_FLAT);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }
    
    @SubscribeEvent
    public void onTick(TickEvent event) {
        if (event.type == TickEvent.Type.CLIENT) {
            GuiScreen gui = Minecraft.getMinecraft().currentScreen;
            if (gui == null || !gui.doesGuiPauseGame()) {
                ticksInGame++;
            }
            int ticksToOpen = 10;
            if (gui instanceof GuiLexicon) {
                if (ticksWithLexicaOpen < 0)
                    ticksWithLexicaOpen = 0;
                if (ticksWithLexicaOpen < ticksToOpen)
                    ticksWithLexicaOpen++;
                if (pageFlipTicks > 0)
                    pageFlipTicks--;
            } else {
                pageFlipTicks = 0;
                if (ticksWithLexicaOpen > 0) {
                    if (ticksWithLexicaOpen > ticksToOpen)
                        ticksWithLexicaOpen = ticksToOpen;
                    ticksWithLexicaOpen--;
                }
            }
        }
        
    }
}
