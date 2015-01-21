package com.bestgame.ru.bestgame;

import android.content.Context;

/**
 * An extension of GameUnit, PlayerUnit represents the player-controlled
 * unit in the game.
 * 
 * @author Dan Ruscoe (ruscoe.org)
 * @version 1.0
 */
public class PlayerUnit extends GameUnit
{
    public static final int SPEED = 8;
    public static final int INERTIA = 1;

	Context mContext;

	private int mUnmodifiedX = 0;
    private int mUnmodifiedY = 0;

    private int mSpeedX = 0;
    private int mSpeedY = 0;

    private int mAcsX = 0;
    private int mAcsY = 0;

	public PlayerUnit(Context context, int drawable)
	{
		super(context, drawable);
		this.mContext = context;
	}

	public int getUnmodifiedX()
	{
		return this.mUnmodifiedX;
	}

	public void setUnmodifiedX(int unmodifiedX)
	{
		this.mUnmodifiedX = unmodifiedX;
	}

	public int getUnmodifiedY()
	{
		return this.mUnmodifiedY;
	}

	public void setUnmodifiedY(int unmodifiedY)
	{
		this.mUnmodifiedY = unmodifiedY;
	}


    public int getmSpeedX() {
        return mSpeedX;
    }

    public void setmSpeedX(int mSpeedX) {
        this.mSpeedX = mSpeedX;
    }

    public int getmSpeedY() {
        return mSpeedY;
    }

    public void setmSpeedY(int mSpeedY) {
        this.mSpeedY = mSpeedY;
    }

    public int getmAcsX() {
        return mAcsX;
    }

    public void setmAcsX(int mAcsX) {
        this.mAcsX = mAcsX;
    }

    public int getmAcsY() {
        return mAcsY;
    }

    public void setmAcsY(int mAcsY) {
        this.mAcsY = mAcsY;
    }

}


