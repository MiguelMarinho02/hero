package com.MiguelMarinho02.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    private Hero hero = new Hero(10, 10);
    private Position position = new Position(hero.getX(),hero.getY());

    public Arena(int a, int b){
        width = a;
        height = b;
    }

    public void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp){
            moveHero(hero.moveUp());
        }
        if (key.getKeyType() == KeyType.ArrowDown){
            moveHero(hero.moveDown());
        }
        if (key.getKeyType() == KeyType.ArrowRight){
            moveHero(hero.moveRight());
        }
        if (key.getKeyType() == KeyType.ArrowLeft){
            moveHero(hero.moveLeft());
        }

        System.out.println(key);
    }

    private void moveHero(Position position) {
        if(canHeroMove(position)){
            hero.setPosition(position);
        }
    }

    private boolean canHeroMove(Position position){
        if(width <= position.getX() || position.getX() <= 0){
            return false;
        }
        if(height <= position.getY() || position.getY() <= 0){
            return false;
        }
        return true;
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width * 2, height * 2), ' ');
        graphics.putString(new TerminalPosition(position.getX() * 2, position.getY() * 2), "\\/");
        graphics.putString(new TerminalPosition(position.getX() * 2, position.getY() * 2 + 1), "/\\");
        hero.draw(graphics);
    }

}
