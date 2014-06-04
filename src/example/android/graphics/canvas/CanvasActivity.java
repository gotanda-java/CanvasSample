package example.android.graphics.canvas;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

// �L�����o�X��ʃA�N�e�B�r�e�B
public class CanvasActivity extends Activity {
	
//	static int CR =0;
	// �L�����o�X�N���A�{�^���̃N���b�N���X�i�[��`
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

	// onCreate���\�b�h(��ʏ����\���C�x���g)
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// �X�[�p�[�N���X��onCreate���\�b�h�Ăяo��
		super.onCreate(savedInstanceState);
		// �`��̈���L���邽�߂Ƀ^�C�g����\���ݒ�
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// ���C�A�E�g�ݒ�t�@�C����ݒ�
		setContentView(R.layout.canvassample);

		// �L�����o�X�N���A�{�^���I�u�W�F�N�g����
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
