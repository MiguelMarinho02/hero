package com.MiguelMarinho02.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element{

    Monster(int x, int y){
        super(x, y);
    }

    public Position move(){
        Random rand = new Random();
        int rNumber = rand.nextInt(4);
        if(rNumber == 0){
            return new Position(super.getPosition().getX() + 1, super.getPosition().getY());
        }
        else if(rNumber == 1){
            return new Position(super.getPosition().getX(), super.getPosition().getY()+1);
        }
        else if(rNumber == 2){
            return new Position(super.getPosition().getX() - 1, super.getPosition().getY());
        }
        else{
            return new Position(super.getPosition().getX(), super.getPosition().getY()-1);
        }
    }

    public void setPosition(Position position){
        super.setPosition(position);
    }

    public Position getPosition() {
        return super.getPosition();
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "M");
    }
}
