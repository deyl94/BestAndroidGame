package com.bestgame.ru.bestgame.data;

import static android.provider.BaseColumns._ID;

import com.bestgame.ru.bestgame.GameTile;
import com.bestgame.ru.bestgame.R;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * The GameDAO class provides access to the database layer of the game.
 * 
 * The class includes the initial queries required to create the
 * database used by the game. 
 * 
 * @author Dan Ruscoe (ruscoe.org)
 * @version 1.0
 */
public class GameDAO extends SQLiteOpenHelper
{
	private static final String DATABASE_NAME = "tilegame.db";
	private static final int DATABASE_VERSION = 1;

	// Create table statements

	/**
	 * The table containing the definitions of each available game tile type.
	 */
	private static final String CREATE_TABLE_GAME_TILES = "CREATE TABLE " + GameTileData.TABLE_NAME + " ("
		+ _ID + " INTEGER PRIMARY KEY, "
		+ GameTileData.NAME + " STRING,"
		+ GameTileData.TYPE + " INTEGER DEFAULT 0,"
		+ GameTileData.DRAWABLE + " INTEGER DEFAULT 0,"
		+ GameTileData.VISIBLE + " INTEGER DEFAULT 1"
		+ ");";

	/**
	 * The table containing the definitions of each level.
	 */
	private static final String CREATE_TABLE_GAME_LEVEL_TILES = "CREATE TABLE " + GameLevelTileData.TABLE_NAME + " ("
		+ _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ GameLevelTileData.STAGE + " INTEGER DEFAULT 0,"
		+ GameLevelTileData.LEVEL + " INTEGER DEFAULT 0,"
		+ GameLevelTileData.PLAYER_START_TILE_X + " INTEGER DEFAULT 0,"
		+ GameLevelTileData.PLAYER_START_TILE_Y + " INTEGER DEFAULT 0,"
		+ GameLevelTileData.TILE_DATA + " TEXT NOT NULL"
		+ ");";

	// Populate table statements

	/**
	 * Populates the game tile definition table. Each row contains:
	 * - A unique ID, specified instead of generated by AUTOINCREMENT so tile definitions
	 * 		are easier to reference when populating the level data table
	 * - The tile name.
	 * - The tile type ID.
	 * - The tile drawable resource ID.
	 * - The tile visibility option (1 = visible, 0 = invisible.)
	 */
	private static final String[] POPULATE_TABLE_GAME_TILES = {
		"INSERT INTO " + GameTileData.TABLE_NAME + " VALUES "
		+ "(1,\"Tile 01\"," + GameTile.TYPE_OBSTACLE + "," + R.drawable.tile_01 + ",1);",

		"INSERT INTO " + GameTileData.TABLE_NAME + " VALUES "
		+ "(2,\"Tile 02\"," + GameTile.TYPE_OBSTACLE + "," + R.drawable.tile_02 + ",1);",
		
		"INSERT INTO " + GameTileData.TABLE_NAME + " VALUES "
		+ "(3,\"Tile 03\"," + GameTile.TYPE_OBSTACLE + "," + R.drawable.tile_03 + ",1);",
		
		"INSERT INTO " + GameTileData.TABLE_NAME + " VALUES "
		+ "(4,\"Tile 04\"," + GameTile.TYPE_OBSTACLE + "," + R.drawable.tile_04 + ",1);",
		
		"INSERT INTO " + GameTileData.TABLE_NAME + " VALUES "
		+ "(5,\"Tile 05\"," + GameTile.TYPE_OBSTACLE + "," + R.drawable.tile_05 + ",1);",
		
		"INSERT INTO " + GameTileData.TABLE_NAME + " VALUES "
		+ "(6,\"Tile 06\"," + GameTile.TYPE_OBSTACLE + "," + R.drawable.tile_06 + ",1);",
		
		"INSERT INTO " + GameTileData.TABLE_NAME + " VALUES "
		+ "(7,\"Tile 07\"," + GameTile.TYPE_OBSTACLE + "," + R.drawable.tile_07 + ",1);",

		"INSERT INTO " + GameTileData.TABLE_NAME + " VALUES "
		+ "(8,\"Dangerous Tile 01\"," + GameTile.TYPE_DANGEROUS + "," + R.drawable.tile_danger_01 + ",1);",

		"INSERT INTO " + GameTileData.TABLE_NAME + " VALUES "
		+ "(9,\"Exit Tile\"," + GameTile.TYPE_EXIT + "," + R.drawable.tile_exit + ",1);"
	};

	/**
	 * Populates the level data definition table. Each row contains:
	 * - An automatically generated unique ID.
	 * - The stage ID.
	 * - The level ID.
	 * - The player start tile X (horizontal) location.
	 * - The player start tile Y (vertical) location.
	 * - The level tile data.
	 * 		Level tile data consists of rows of comma-delimited game tile IDs.
	 * 		The tile IDs used correspond to the unique IDs found in the game
	 * 		tile definition table.
	 * 
	 * 		The position of each game tile ID corresponds to the position the
	 * 		tile will be drawn in the game.
	 */
	private static final String[] POPULATE_TABLE_GAME_LEVEL_TILES = {
		"INSERT INTO " + GameLevelTileData.TABLE_NAME + " VALUES "
		+ "(null,1,1,7,3,\""
				// 1  2  3  4  5  6  7  8  9  10 11 12 13 14 15
		/* 1  */+ "01,01,01,01,01,01,01,01,01,01,01,01,01,01,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 2  */+ "01,03,03,03,03,03,03,03,03,03,03,03,03,03,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 3  */+ "01,03,00,00,00,00,00,00,00,00,00,00,00,03,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 4  */+ "01,03,00,00,00,00,00,00,00,00,00,07,07,03,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 5  */+ "01,03,07,00,00,00,00,00,00,00,07,07,07,03,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 6  */+ "01,03,05,05,06,05,00,00,00,05,06,05,05,03,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 7  */+ "01,03,03,00,08,00,00,00,00,00,08,00,03,03,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 8  */+ "01,03,00,00,00,00,00,00,00,00,00,00,00,03,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 9  */+ "01,03,00,00,00,00,00,00,00,00,00,00,00,03,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 10 */+ "01,03,00,00,00,00,04,04,04,00,00,00,00,03,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 11 */+ "01,03,00,00,04,04,03,03,03,04,04,00,00,03,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 12 */+ "01,03,00,00,03,00,00,00,00,00,03,00,00,03,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 13 */+ "01,03,00,00,00,00,00,00,00,00,00,00,00,03,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 14 */+ "01,03,00,00,00,00,00,09,00,00,00,00,07,03,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 15 */+ "01,03,03,00,00,00,02,02,02,00,00,00,03,03,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 16 */+ "01,03,03,04,04,04,02,02,02,04,04,04,03,03,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		/* 17 */+ "01,01,01,01,01,01,01,01,01,01,01,01,01,01,01" + GameLevelTileData.TILE_DATA_LINE_BREAK
		+ "\");"		
	};

	public GameDAO(Context ctx)
	{
		super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		// Create game tables
		
		Log.d("Tile Game Example", "Creating DB tables");
		
		db.execSQL(CREATE_TABLE_GAME_TILES);
		db.execSQL(CREATE_TABLE_GAME_LEVEL_TILES);

		// Populate game tables
		
		Log.d("Tile Game Example", "Populating DB tables");
		
		for (String query : POPULATE_TABLE_GAME_TILES)
		{
			db.execSQL(query);
		}
		
		for (String query : POPULATE_TABLE_GAME_LEVEL_TILES)
		{
			db.execSQL(query);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS " + GameTileData.TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + GameLevelTileData.TABLE_NAME);
		
		onCreate(db);
	}

}
