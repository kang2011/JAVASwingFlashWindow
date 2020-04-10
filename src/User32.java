

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.platform.win32.WinDef.HWND;

public interface User32 extends Library {
	@SuppressWarnings("deprecation")
	User32 INSTANCE = (User32) Native.loadLibrary((Platform.isWindows() ? "user32" : "c"), User32.class);

	boolean FlashWindow(int hwnd, boolean bInvert);

	int SendMessageA(int hwnd, int msg, int wparam, int lparam);

//	int FindWindowA(String arg0, String arg1);

	void BlockInput(boolean isBlock);

	int MessageBoxA(int hWnd, String lpText, int lpCaption, int uType);

	//
	HWND FindWindowExA(HWND hwndParent, HWND childAfter, String className, String windowName);

	HWND FindWindowA(String className, String windowName);

	boolean FlashWindow(HWND hWnd, boolean bInvert);

	HWND FindWindow(int winClass, String title);

}
