package com.example.assignment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.assignment.GameView.screenRatioX;
import static com.example.assignment.GameView.screenRatioY;

public class Flight {
    public boolean isGoingUp = false;
    public int toShoot = 0;
    int x,y,width,height,winCounter =0 , shootCounter = 1;
    Bitmap flight1,flight2, s1,s2,s3,s4,s5,dead;
    private GameView gameView;

    Flight(GameView gameView, int screenY, Resources res){
        this.gameView = gameView;
        flight1 = BitmapFactory.decodeResource(res,R.drawable.fly1);
        flight2 = BitmapFactory.decodeResource(res,R.drawable.fly2);

        width = flight1.getWidth();
        height = flight1.getHeight();

        width /=4;
        height /=4;

        width *= (int)screenRatioX;
        height *=(int)screenRatioY;

        flight1 = Bitmap.createScaledBitmap(flight1,width,height,false);
        flight2 = Bitmap.createScaledBitmap(flight2,width,height,false);

        s1 = BitmapFactory.decodeResource(res,R.drawable.shoot1);
        s2 = BitmapFactory.decodeResource(res,R.drawable.shoot2);
        s3 = BitmapFactory.decodeResource(res,R.drawable.shoot3);
        s4 = BitmapFactory.decodeResource(res,R.drawable.shoot4);
        s5 = BitmapFactory.decodeResource(res,R.drawable.shoot5);


        s1 = Bitmap.createScaledBitmap(s1,width,height,false);
        s2 = Bitmap.createScaledBitmap(s2,width,height,false);
        s3 = Bitmap.createScaledBitmap(s3,width,height,false);
        s4 = Bitmap.createScaledBitmap(s4,width,height,false);
        s5 = Bitmap.createScaledBitmap(s5,width,height,false);

        dead = BitmapFactory.decodeResource(res,R.drawable.dead);
        dead = Bitmap.createScaledBitmap(dead,width,height,false);

        y = screenY/2;
        x = (int)(64 * screenRatioX);

    }

    Bitmap getFlight(){
        if(toShoot!=0){
            if(shootCounter == 1){
                shootCounter++;
                return s1;
            }
            if(shootCounter == 2){
                shootCounter++;
                return s2;
            }
            if(shootCounter == 3){
                shootCounter++;
                return s3;
            }
            if(shootCounter == 4){
                shootCounter++;
                return s4;
            }

            shootCounter = 1;
            toShoot--;
            gameView.newBullet();

            return s5;

        }
        if(winCounter == 0){
            winCounter++;
            return flight1;
        }
        winCounter--;
        return flight2;
    }
    Rect getCollisionShape(){
        return new Rect(x,y,x+width,y+height);
    }
    Bitmap getDead(){
        return dead;
    }
}
