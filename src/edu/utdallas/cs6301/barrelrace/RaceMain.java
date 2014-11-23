package edu.utdallas.cs6301.barrelrace;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * This activity draws the following:
 * 1) Square arena
 * 2) Barrels (3 or 4)
 * 3) Horse (1)
 * 4) Timer
 * 5) Start button
 * @author Sean
 *
 */
public class RaceMain extends Activity {
	private BoardView boardView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_race_main);
		boardView = (BoardView)findViewById(R.id.board_view);
	}
}
