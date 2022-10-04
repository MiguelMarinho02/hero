package com.MiguelMarinho02.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.w3c.dom.Text;

public class Hero {
    private Position position = new Position(10,10);

    public Hero(int a, int b){
        position.setX(a);
        position.setY(b);
    }

    public int getY() {
        return position.getY();
    }

    public void setY(int y) {
        position.setY(y);
    }

    public int getX() {
        return position.getX();
    }

    public void setX(int x) {
        position.setX(x);
    }

    public Position moveUp(){
        return new Position(position.getX(), position.getY()-1);
    }
    public Position moveDown(){
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position moveLeft(){
        return new Position(position.getX()-1, position.getY());
    }
    public Position moveRight(){
        return new Position(position.getX() + 1, position.getY());
    }
    public void setPosition(Position p){
        position.setX(p.getX());
        position.setY(p.getY());
    }
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }
}
