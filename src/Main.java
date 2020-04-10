import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.jna.platform.win32.WinDef.HWND;

public class Main {
	public static void main(String[] args) {
		new SwingWindow();
	}

	static class SwingWindow extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingWindow() {
			this.setSize(new Dimension(500, 300));
			this.setLocationRelativeTo(null);
			this.setTitle("��������");
			JLabel jl = new JLabel("��������������");
			this.add(jl, BorderLayout.NORTH);
			JButton jb = new JButton("����");
			jb.setSize(100, 50);
			this.add(jb, BorderLayout.SOUTH);
			setVisible(true);
			final HWND hwnd = User32.INSTANCE.FindWindowA(null, "��������");// �ҵ����ڶ���,
			jb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					toBack();// ��Ҫ��ҳ��ʧȥ���㣬��ȡ����������Զ���ʧ��
//					
					User32.INSTANCE.FlashWindow(hwnd, true);
				}
			});

		}
	}
}
