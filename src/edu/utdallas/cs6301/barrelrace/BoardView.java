package edu.utdallas.cs6301.barrelrace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.View;

public class BoardView extends View implements SensorEventListener {
	private ShapeDrawable horseDrawable;
	private ShapeDrawable barrelDrawable;
	private ShapeDrawable arenaDrawable;
	private SensorManager sensorManager;
	private Sensor sensor;
	private int x;
	private int y;
	private float accelX;
	private float accelY;
	private float accelZ;
	
	public BoardView(Context context, AttributeSet attributes) {
		super(context, attributes);
		x = 10;
		y = 10;		
		sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
		sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST );
		int width = context.getResources().getDisplayMetrics().widthPixels;
		int height = context.getResources().getDisplayMetrics().heightPixels;
		arenaDrawable = new ShapeDrawable(new OvalShape() /*new RectShape()*/);
		arenaDrawable.getPaint().setColor(0xffE6D875);
		//arenaDrawable.setBounds(x, y + (height - width -(2*x)), width - (2 * x), y + height);
		arenaDrawable.setBounds(x, y, x + 200, y + 200);
	}
	




	protected void onDraw(Canvas canvas) {
		arenaDrawable.draw(canvas);
	}

	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			accelX = (event.values[0]);
			accelY = (event.values[1]);
			accelZ = (event.values[2]);
/*			if (accelX < x) {
				x -= (int) accelX;
			}
			else {
				x += (int) accelX;
			}
			if (accelY < y) {
				x -= (int) accelY;
			}
			else {
				y += (int) accelY;
			}*/
			x -= (int) accelX;
			y += (int) accelY;
			arenaDrawable.setBounds(x, y, x + 200, y + 200);
			
			this.invalidate();
		}
	}





	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	
}
