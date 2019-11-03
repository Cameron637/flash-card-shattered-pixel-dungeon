package com.shatteredpixel.shatteredpixeldungeon.windows;

import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.ui.RedButton;

public class WndFlashCardQuestion extends WndFlashCard {
  public WndFlashCardQuestion(final Class<? extends Item> item) {
    super(item);
  }

  @Override
  public String getText() {
    return "4 x 9 = ?";
  }

  @Override
  public int renderInputs(final int height, final int width) {
    RedButton btn = new RedButton("Reveal Answer", 8) {
      @Override
      protected void onClick() {
        super.onClick();
        GameScene.show(new WndFlashCardAnswer(item));
        hide();
      }
    };

    btn.setRect(MARGIN_HORIZONTAL, height, width, BUTTON_HEIGHT);
    add(btn);

    return (int) btn.height() + MARGIN_VERTICAL;
  }
}