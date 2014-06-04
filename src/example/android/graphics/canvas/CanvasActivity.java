package example.android.graphics.canvas;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

// キャンバス画面アクティビティ
public class CanvasActivity extends Activity {
	
//	static int CR =0;
	// キャンバスクリアボタンのクリックリスナー定義
	private OnClickListener onClickListener = new View.OnClickListener() {
		public void onClick(View arg0) {
			CanvasView view = (CanvasView) findViewById(R.id.cv_canvas);
			view.clearDrawList();
		}
	};
	
//	public static  Paint paint;
	private OnClickListener onClickListenerBlack = new View.OnClickListener() {
		public void onClick(View arg0) {
			CanvasView.paintBlack.setColor(0xFF000000);
			CanvasView.CR=0;
		}
	};
	private OnClickListener onClickListenerRed = new View.OnClickListener() {
		public void onClick(View arg0) {
			CanvasView.paintRed.setColor(0xFFFF0000);
			CanvasView.CR=1;
		}
	};
	private OnClickListener onClickListenerGreen = new View.OnClickListener() {
		public void onClick(View arg0) {
			CanvasView.paintGreen.setColor(0xFF00FF00);
			CanvasView.CR=2;
		}
	};
	private OnClickListener onClickListenerBlue = new View.OnClickListener() {
		public void onClick(View arg0) {
			CanvasView.paintBlue.setColor(0xFF0000FF);
			CanvasView.CR=3;
		}
	};

	// onCreateメソッド(画面初期表示イベント)
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// スーパークラスのonCreateメソッド呼び出し
		super.onCreate(savedInstanceState);
		// 描画領域を広げるためにタイトル非表示設定
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// レイアウト設定ファイルを設定
		setContentView(R.layout.canvassample);

		// キャンバスクリアボタンオブジェクト生成
		Button btnClear = (Button) findViewById(R.id.btn_clear);
		btnClear.setOnClickListener(onClickListener);
		
		Button btnBlack = (Button) findViewById(R.id.btn_black);
		btnBlack.setOnClickListener(onClickListenerBlack);
		Button btnRed = (Button) findViewById(R.id.btn_red);
		btnRed.setOnClickListener(onClickListenerRed);
		Button btnGreen = (Button) findViewById(R.id.btn_green);
		btnGreen.setOnClickListener(onClickListenerGreen);
		Button btnBlue= (Button) findViewById(R.id.btn_blue);
		btnBlue.setOnClickListener(onClickListenerBlue);
	}
}
