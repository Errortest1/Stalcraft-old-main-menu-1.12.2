package by.errortest.stalcraft_menu.client.gui;

import by.errortest.stalcraft_menu.Main;
import by.errortest.stalcraft_menu.client.ForgeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import org.lwjgl.opengl.GL11;

import static by.errortest.stalcraft_menu.client.ForgeEvent.musicCount;

public class CustomGuiButton extends GuiButton {
    public ResourceLocation buttonTexture = new ResourceLocation(Main.MODID, "textures/gui/menu/navigation.png");
    private int xHovPos, yHovPos, xOff, yOff, xHovOff, yHovOff, xTexSize, yTexSize, xTexPos, yTexPos;
    private boolean flag;

    public CustomGuiButton(int id, int xButtonPos, int yButtonPos, int xTexPos, int yTexPos, int xHovPos, int yHovPos, int xOff, int yOff, int xHovOff, int yHovOff, int xTexSize, int yTexSize, int width, int height, String displayString) {
        super(id, width, height, displayString);
        this.width = width;
        this.height = height;
        this.xHovPos = xHovPos;
        this.yHovPos = yHovPos;
        this.xTexPos = xTexPos;
        this.yTexPos = yTexPos;
        this.xOff = xOff;
        this.yOff = yOff;
        this.xHovOff = xHovOff;
        this.yHovOff = yHovOff;
        this.xTexSize = xTexSize;
        this.yTexSize = yTexSize;
        this.enabled = true;
        this.visible = true;
        this.id = id;
        this.x = xButtonPos;
        this.y = yButtonPos;
    }

    @Override
    public void drawButton(Minecraft minecraft, int mouseX, int mouseY, float partialTicks) {
        float scale = 1.65f;
        if (musicCount == 1) {
            playSound("main_menu");
            musicCount++;
        }
            GlStateManager.pushMatrix();
            GlStateManager.scale(scale, scale, scale);
            minecraft.renderEngine.bindTexture(buttonTexture);
            hovered = mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;
            GlStateManager.enableBlend();

            if (hovered) {
                if (flag)
                    playSound("main_menu_hover");
                flag = false;
                drawTexturedModalRect((int) ((xHovPos) / scale), (int) ((yHovPos + 15 - 13) / scale), xHovOff, yHovOff, xTexSize, yTexSize);
            } else {
                drawTexturedModalRect((int) ((xTexPos) / scale), (int) ((yTexPos + 15 - 13) / scale), xOff, yOff, xTexSize, yTexSize);
                flag = true;
            }
            GlStateManager.popMatrix();
            mouseDragged(minecraft, mouseX, mouseY);
        }

    private void playSound(String name) {
        ISound isound = PositionedSoundRecord.getMasterRecord(new SoundEvent(new ResourceLocation(Main.MODID, name)), 1);
        Minecraft.getMinecraft().getSoundHandler().playSound(isound);
    }
}

