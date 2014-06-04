package example.android.graphics.canvas;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

// キャンバスビュークラス
public class CanvasView extends View {
	// 描画する点格納用リスト
	public static ArrayList<Point> points;
	public static ArrayList<Point> pointsBlack;
	public static ArrayList<Point> pointsRed;
	public static ArrayList<Point> pointsGreen;
	public static ArrayList<Point> pointsBlue;

	// points = red;

	// Paintインスタンス
	public static Paint paint;
	public static Paint paintBlack;
	public static Paint paintRed;
	public static Paint paintGreen;
	public static Paint paintBlue;

	// コンストラクタ
	public CanvasView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setFocusable(true);

		// 描画する点格納用リスト生成
		points = new ArrayList<Point>();
		pointsBlack = new ArrayList<Point>();
		pointsRed = new ArrayList<Point>();
		pointsGreen = new ArrayList<Point>();
		pointsBlue = new ArrayList<Point>();

		// Paint(筆)の設定
		paint = new Paint();
		paintBlack = new Paint();
		paintRed = new Paint();
		paintGreen = new Paint();
		paintBlue = new Paint();

		// paint.setColor(0xFF4444FF);
		paint.setStyle(Paint.Style.FILL);
		paint.setStrokeWidth(3);

		paintBlack.setStyle(Paint.Style.FILL);
		paintBlack.setStrokeWidth(3);
		paintRed.setStyle(Paint.Style.FILL);
		paintRed.setStrokeWidth(3);
		paintGreen.setStyle(Paint.Style.FILL);
		paintGreen.setStrokeWidth(3);
		paintBlue.setStyle(Paint.Style.FILL);
		paintBlue.setStrokeWidth(3);
	}

	// onMeasureメソッド(ビューのサイズ設定処理)
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
	}

	static int CR;

	// onTouchEventメソッド(タッチイベント)
	@Override
	public boolean onTouchEvent(MotionEvent event) {

		if (CR == 0) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:

			case MotionEvent.ACTION_MOVE:
				// 画面に指が付いたまたは動いている場合はその座標を設定
				pointsBlack.add(new Point((int) event.getX(), (int) event.getY()));
				break;
			case MotionEvent.ACTION_UP:
				// 画面から指が離された場合はデリミタを設定
				pointsBlack.add(new Point(-1, -1));
				break;
			default:
				break;
			}

			this.invalidate();
		} else if (CR == 1) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:

			case MotionEvent.ACTION_MOVE:
				// 画面に指が付いたまたは動いている場合はその座標を設定
				pointsRed
						.add(new Point((int) event.getX(), (int) event.getY()));
				break;
			case MotionEvent.ACTION_UP:
				// 画面から指が離された場合はデリミタを設定
				pointsRed.add(new Point(-1, -1));
				break;
			default:
				break;
			}
			this.invalidate();
			
		} else if (CR == 2) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:

			case MotionEvent.ACTION_MOVE:
				// 画面に指が付いたまたは動いている場合はその座標を設定
				pointsGreen.add(new Point((int) event.getX(), (int) event
						.getY()));
				break;
			case MotionEvent.ACTION_UP:
				// 画面から指が離された場合はデリミタを設定
				pointsGreen.add(new Point(-1, -1));
				break;
			default:
				break;
			}
			this.invalidate();
			
		} else if (CR == 3) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:

			case MotionEvent.ACTION_MOVE:
				// 画面に指が付いたまたは動いている場合はその座標を設定
				pointsBlue
						.add(new Point((int) event.getX(), (int) event.getY()));
				break;
			case MotionEvent.ACTION_UP:
				// 画面から指が離された場合はデリミタを設定
				pointsBlue.add(new Point(-1, -1));
				break;
			default:
				break;
			}
			this.invalidate();
			
		}

		return true;
	}

	// onDrawメソッド(描画処理)
	@Override
	protected void onDraw(Canvas canvas) {
		// キャンバスの背景を白に設定
		canvas.drawColor(Color.WHITE);

		// 描画処理
		Point sp = new Point(-1, -1);
		for (Point ep : points) {
			if (sp.x >= 0) {
				if (ep.x >= 0) {
					canvas.drawLine(sp.x, sp.y, ep.x, ep.y, paint);
				} else {
					canvas.drawPoint(sp.x, sp.y, paint);
				}
			}

			sp = ep;
		}
		
		// 描画処理
				Point spBlack = new Point(-1, -1);
				for (Point epBlack : pointsBlack) {
					if (spBlack.x >= 0) {
						if (epBlack.x >= 0) {
							canvas.drawLine(spBlack.x, spBlack.y, epBlack.x, epBlack.y, paintBlack);
						} else {
							canvas.drawPoint(spBlack.x, spBlack.y, paintBlack);
						}
					}

					spBlack = epBlack;
				}

		// 描画処理
		Point spRed = new Point(-1, -1);
		for (Point epRed : pointsRed) {
			if (spRed.x >= 0) {
				if (epRed.x >= 0) {
					canvas.drawLine(spRed.x, spRed.y, epRed.x, epRed.y,
							paintRed);
				} else {
					canvas.drawPoint(spRed.x, spRed.y, paintRed);
				}
			}

			spRed = epRed;
		}
		// 描画処理
				Point spGreen = new Point(-1, -1);
				for (Point epGreen : pointsGreen) {
					if (spGreen.x >= 0) {
						if (epGreen.x >= 0) {
							canvas.drawLine(spGreen.x, spGreen.y, epGreen.x, epGreen.y,
									paintGreen);
						} else {
							canvas.drawPoint(spGreen.x, spGreen.y, paintGreen);
						}
					}

					spGreen = epGreen;
				}
		// 描画処理
		Point spBlue = new Point(-1, -1);
		for (Point epBlue : pointsBlue) {
			if (spBlue.x >= 0) {
				if (epBlue.x >= 0) {
					canvas.drawLine(spBlue.x, spBlue.y, epBlue.x, epBlue.y,
							paintBlue);
				} else {
					canvas.drawPoint(spBlue.x, spBlue.y, paintBlue);
				}
			}

			spBlue = epBlue;
		}
		
		
//		RectF oval = new RectF(50, 5, 150, 200);;
//		canvas.drawOval(oval, paint);
	}

	// clearDrawListメソッド(クリア処理)
	public void clearDrawList() {
		points.clear();
		pointsBlack.clear();
		pointsRed.clear();
		pointsGreen.clear();
		pointsBlue.clear();
		this.invalidate();
	}
}
