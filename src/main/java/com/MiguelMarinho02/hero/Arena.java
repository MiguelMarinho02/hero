package com.MiguelMarinho02.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Hero hero = new Hero(10, 10);
    private Position position = new Position(hero.getX(),hero.getY());

    private List<Wall> walls;

    public Arena(int a, int b){
        width = a;
        height = b;
        this.walls = createWalls();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
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
        for(Wall wall : walls){
            if (wall.getPosition().equals(position)){
                return false;
            }
        }
        return true;
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width * 2, height * 2), ' ');
        //graphics.putString(new TerminalPosition(position.getX() * 2, position.getY() * 2), "\\/");
        //graphics.putString(new TerminalPosition(position.getX() * 2, position.getY() * 2 + 1), "/\\");
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
    }

}