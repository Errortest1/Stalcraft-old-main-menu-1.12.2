package by.errortest.stalcraft_menu.client.gui;

import by.errortest.stalcraft_menu.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class StalcraftMenuGui extends GuiScreen {
    
    Minecraft mc = Minecraft.getMinecraft();
    public static float sphereTimer = 0;
    boolean flag1 = true;

    public void initGui() {
        this.buttonList.add(new CustomGuiButton(0, this.width - 310, this.height / 6 - 22, this.width - 415, this.height / 6 - 20, this.width - 415,
                this.height / 6 - 20, 0, 14, 0, 100, 256, 20, 320, 30, ""));
        this.buttonList.add(new CustomGuiButton(1, this.width - 310, this.height / 6 + 18, this.width - 415, this.height / 6 + 20, this.width - 415,
                this.height / 6 + 16, 0, 37, 0, 120, 256, 20, 320, 30, ""));
        this.buttonList.add(new CustomGuiButton(2, this.width - 310, this.height / 6 + 58, this.width - 415, this.height / 6 + 52, this.width - 415,
                this.height / 6 + 51, 0, 55, 0, 140, 256, 20, 320, 30, ""));
        this.buttonList.add(new CustomGuiButton(3, this.width - 310, this.height / 6 + 95, this.width - 415, this.height / 6 + 88, this.width - 415,
                this.height / 6 + 87, 0, 76, 0, 161, 256, 20, 320, 30, ""));
    }

    public void updateScreen() {
        if (sphereTimer >= 30 && flag1)
            flag1 = false;
         else if (sphereTimer == 0 && !flag1)
            flag1 = true;
        if (!flag1)
            sphereTimer--;
         else
            sphereTimer++;

    }

    protected void actionPerformed(GuiButton button) {
        if (button.id == 0)
            mc.displayGuiScreen(new GuiWorldSelection(this));
        if (button.id == 1)
            mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
        if (button.id == 2) {
            try {
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        if (button.id == 3)
            mc.shutdown();

    }


    public void drawScreen(int var1, int var2, float p_73863_3_) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(0, -12, 0);
        drawFullScreenTexture(new ResourceLocation(Main.MODID, "textures/gui/menu/background_layer_0.png"));
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(0, sphereTimer / 8, 0);
        drawFullScreenTexture(new ResourceLocation(Main.MODID, "textures/gui/menu/background_layer_1.png"));
        GlStateManager.popMatrix();
        drawFullScreenTexture(new ResourceLocation(Main.MODID, "textures/gui/menu/background_layer_2.png"));

        super.drawScreen(var1, var2, p_73863_3_);
    }

    void drawFullScreenTexture(ResourceLocation resourceLocation) {
        ScaledResolution scaledRes = new ScaledResolution(mc);
        int x = scaledRes.getScaledWidth();
        int y = scaledRes.getScaledHeight();
        GlStateManager.pushMatrix();
        GlStateManager.translate((((Mouse.getEventX() * -1) * 5.44444444d) / x) * 1.03, ((Mouse.getEventY() * 5.44444444d) / y) * 1.03, 0);
        GlStateManager.scale(1.03, 1.03, 0);
        GlStateManager.enableBlend();
        this.mc.getTextureManager().bindTexture(resourceLocation);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos(0.0D, y, -90.0D).tex(0.0D, 1.0D).endVertex();
        bufferbuilder.pos(x, y, -90.0D).tex(1.0D, 1.0D).endVertex();
        bufferbuilder.pos(x, 0.0D, -90.0D).tex(1.0D, 0.0D).endVertex();
        bufferbuilder.pos(0.0D, 0.0D, -90.0D).tex(0.0D, 0.0D).endVertex();
        tessellator.draw();
        GlStateManager.popMatrix();
    }
}
