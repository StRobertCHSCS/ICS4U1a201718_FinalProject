package com.strobertchs.finalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Uniform extends Rectangle{
    public Uniform(int x, int y) {
        setBounds(x+10,y+10,8,8);

    }
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x,y,width,height);
    }
}

