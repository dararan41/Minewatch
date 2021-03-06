package twopiradians.minewatch.client.gui.teamStick;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

public class GuiButtonResized extends GuiButton {

	public GuiButtonResized(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		GlStateManager.pushMatrix();
		int actualHeight = this.height;
		float yScale = actualHeight/20f;
		float xScale = this.height == this.width ? yScale : 1;
		this.height = 20;
		GlStateManager.translate(0, this.yPosition-this.yPosition*(yScale), 0);
		GlStateManager.scale(1, yScale, 1);
		// copied - hovered edited
		if (this.visible) {
            FontRenderer fontrenderer = mc.fontRendererObj;
            mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + actualHeight;
            int i = this.getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + i * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
            this.mouseDragged(mc, mouseX, mouseY);
            int j = 14737632;

            if (packedFGColour != 0)
            {
                j = packedFGColour;
            }
            else
            if (!this.enabled)
            {
                j = 10526880;
            }
            else if (this.hovered)
            {
                j = 16777120;
            }

            GlStateManager.translate(this.xPosition-this.xPosition*(xScale), 0, 0);
    		GlStateManager.scale(xScale, 1, 1);
            this.drawCenteredString(fontrenderer, this.displayString, (int) (this.xPosition + this.width/xScale / 2), this.yPosition + (this.height - 8) / 2, j);
        }
		this.height = actualHeight;
		GlStateManager.popMatrix();
    }
	
}