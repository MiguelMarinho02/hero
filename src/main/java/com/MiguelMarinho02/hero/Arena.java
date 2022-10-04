package com.MiguelMarinho02.hero;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    //private Screen screen;
    private Hero hero = new Hero(10, 10);

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
        else{
            System.out.println("Invalid Position");
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

    public void draw(Screen screen) throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

}
