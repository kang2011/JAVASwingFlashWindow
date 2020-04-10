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
			this.setTitle("高亮布局");
			JLabel jl = new JLabel("测试任务栏高亮");
			this.add(jl, BorderLayout.NORTH);
			JButton jb = new JButton("高亮");
			jb.setSize(100, 50);
			this.add(jb, BorderLayout.SOUTH);
			setVisible(true);
			final HWND hwnd = User32.INSTANCE.FindWindowA(null, "高亮布局");// 找到窗口对象,
			jb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					toBack();// 需要让页面失去焦点，获取焦点高亮会自动消失。
//					
					User32.INSTANCE.FlashWindow(hwnd, true);
				}
			});

		}
	}
}
