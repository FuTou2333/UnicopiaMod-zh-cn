package com.minelittlepony.unicopia.container;

import com.minelittlepony.common.client.gui.IViewRoot;
import com.minelittlepony.common.client.gui.ScrollContainer;
import com.minelittlepony.common.client.gui.element.Label;
import com.minelittlepony.unicopia.ability.magic.spell.crafting.SpellbookRecipe;
import com.minelittlepony.unicopia.ability.magic.spell.trait.Trait;
import com.minelittlepony.unicopia.container.SpellbookScreen.TraitButton;
import com.minelittlepony.unicopia.item.URecipes;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.recipebook.RecipeBookProvider;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class SpellbookCraftingPageContent extends ScrollContainer implements SpellbookChapterList.Content, RecipeBookProvider {


    private final SpellbookScreen screen;

    private final RecipeBookWidget recipeBook = new RecipeBookWidget();

    public SpellbookCraftingPageContent(SpellbookScreen screen) {
        this.screen = screen;
        backgroundColor = 0xFFf9efd3;
        scrollbar.layoutToEnd = true;
    }

    @Override
    public void init(SpellbookScreen screen) {
        screen.addPageButtons(187, 300, 350, SpellbookPage::swap);
        refreshRecipeBook();
        screen.addDrawable(this);
        ((IViewRoot)screen).getChildElements().add(this);
    }

    @Override
    public void draw(MatrixStack matrices, int mouseX, int mouseY, IViewRoot container) {
        textRenderer.draw(matrices, screen.getTitle(), SpellbookScreen.TITLE_X, SpellbookScreen.TITLE_Y, SpellbookScreen.TITLE_COLOR);
        textRenderer.draw(matrices, SpellbookPage.getCurrent().getLabel(), screen.getBackgroundWidth() / 2 + SpellbookScreen.TITLE_X, SpellbookScreen.TITLE_Y, SpellbookScreen.TITLE_COLOR);

        Text pageText = Text.translatable("%s/%s", SpellbookPage.getCurrent().ordinal() + 1, SpellbookPage.VALUES.length);
        textRenderer.draw(matrices, pageText, 337 - textRenderer.getWidth(pageText) / 2F, 190, SpellbookScreen.TITLE_COLOR);
    }

    @Override
    public void refreshRecipeBook() {
        init(this::initPageContent);
    }

    @Override
    public RecipeBookWidget getRecipeBookWidget() {
        return recipeBook;
    }

    private void initPageContent() {
        getContentPadding().setVertical(10);
        getContentPadding().bottom = 30;

        switch (SpellbookPage.getCurrent()) {
            case DISCOVERIES: {
                int i = 0;
                int cols = 4;

                int top = 10;
                int left = 25;

                for (Trait trait : Trait.all()) {
                    int x = i % cols;
                    int y = i / cols;

                    addButton(new TraitButton(left + x * 32, top + y * 32, trait));
                    i++;
                }
                break;
            }
            case INVENTORY:
                // handled elsewhere
                break;
            case RECIPES:
                int top = 0;
                for (SpellbookRecipe recipe : this.client.world.getRecipeManager().listAllOfType(URecipes.SPELLBOOK)) {
                    if (client.player.getRecipeBook().contains(recipe)) {
                        IngredientTree tree = new IngredientTree(0, top,
                                width - scrollbar.getBounds().width + 2,
                                20);
                        recipe.buildCraftingTree(tree);
                        top += tree.build(this);
                    }
                }
                if (top == 0) {
                    addButton(new Label(width / 2, 0).setCentered()).getStyle().setText("gui.unicopia.spellbook.page.recipes.empty");
                }
        }
    }

    @Override
    public void init(Runnable contentInitializer) {
        if (screen != null) {
            margin.left = screen.getX() + screen.getBackgroundWidth() / 2 + 10;
            margin.top = screen.getY() + 35;
            margin.right = screen.width - screen.getBackgroundWidth() - screen.getX() + 30;
            margin.bottom = screen.height - screen.getBackgroundHeight() - screen.getY() + 40;
        }
        super.init(contentInitializer);
    }

    @Override
    public void drawOverlays(MatrixStack matrices, int mouseX, int mouseY, float tickDelta) {
        matrices.push();
        matrices.translate(margin.left, margin.top, 0);
        matrices.translate(-2, -2, 0);
        RenderSystem.enableBlend();
        RenderSystem.setShaderTexture(0, SpellbookScreen.TEXTURE);
        int tileSize = 25;

        final int bottom = height - tileSize + 4;
        final int right = width - tileSize + 9;

        drawTexture(matrices, 0, 0, 405, 62, tileSize, tileSize, 512, 256);
        drawTexture(matrices, right, 0, 425, 62, tileSize, tileSize, 512, 256);

        drawTexture(matrices, 0, bottom, 405, 72, tileSize, tileSize, 512, 256);
        drawTexture(matrices, right, bottom, 425, 72, tileSize, tileSize, 512, 256);

        for (int i = tileSize; i < right; i += tileSize) {
            drawTexture(matrices, i, 0, 415, 62, tileSize, tileSize, 512, 256);
            drawTexture(matrices, i, bottom, 415, 72, tileSize, tileSize, 512, 256);
        }

        for (int i = tileSize; i < bottom; i += tileSize) {
            drawTexture(matrices, 0, i, 405, 67, tileSize, tileSize, 512, 256);
            drawTexture(matrices, right, i, 425, 67, tileSize, tileSize, 512, 256);
        }
        matrices.pop();
        screen.drawSlots(matrices, mouseX, mouseY, tickDelta);

        super.drawOverlays(matrices, mouseX, mouseY, tickDelta);
    }
}
