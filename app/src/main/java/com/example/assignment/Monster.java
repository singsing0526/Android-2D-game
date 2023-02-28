package com.example.assignment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.assignment.GameView.screenRatioX;
import static com.example.assignment.GameView.screenRatioY;

public class Monster {
    public int speed = 10;
    public boolean wasShot = true;
    int x =0,y,width,height, MonsterCounter =1;
    Bitmap b1,b2,b3,b4;

    Monster(Resources res){
        b1 = BitmapFactory.decodeResource(res,R.drawable.m1);
        b2 = BitmapFactory.decodeResource(res,R.drawable.m2);
        b3 = BitmapFactory.decodeResource(res,R.drawable.m3);
        b4 = BitmapFactory.decodeResource(res,R.drawable.m4);

        width = b1.getWidth();
        height = b1.getHeight();

        width /=2;
        height /=2;

        width *=(int) screenRatioX;
        height *= (int) screenRatioY;

        b1 = Bitmap.createScaledBitmap(b1,width,height,false);
        b2 = Bitmap.createScaledBitmap(b2,width,height,false);
        b3 = Bitmap.createScaledBitmap(b3,width,height,false);
        b4 = Bitmap.createScaledBitmap(b4,width,height,false);

        y = -height;
    }
    Bitmap getMonster(){
        if(MonsterCounter ==1){
         MonsterCounter ++;
         return b1;
        }
        if(MonsterCounter ==2){
            MonsterCounter ++;
            return b2;
        }
        if(MonsterCounter ==3){
            MonsterCounter ++;
            return b3;
        }

        MonsterCounter =1;
        return b4;

    }
    Rect getCollisionShape(){
        return new Rect(x,y,x+width,y+height);
    }
}
