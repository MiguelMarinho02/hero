package com.MiguelMarinho02.hero;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.w3c.dom.Text;

public class Hero extends Element{

    public Hero(int x, int y){
        super(x,y);
    }

    public int getY() {
        return super.getPosition().getY();
    }

    public void setY(int y) {
        super.getPosition().setY(y);
    }

    public int getX() {
        return super.getPosition().getX();
    }

    public void setX(int x) {
        super.getPosition().setX(x);
    }

    public Position moveUp(){
        return new Position(super.getPosition().getX(), super.getPosition().getY()-1);
    }
    public Position moveDown(){
        return new Position(super.getPosition().getX(), super.getPosition().getY() + 1);
    }
    public Position moveLeft(){
        return new Position(super.getPosition().getX()-1, super.getPosition().getY());
    }
    public Position moveRight(){
        return new Position(super.getPosition().getX() + 1, super.getPosition().getY());
    }
    public void setPosition(Position p){
        super.getPosition().setX(p.getX());
        super.getPosition().setY(p.getY());
    }
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "X");
    }
}
