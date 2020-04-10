# JAVASwingFlashWindow
# 1:获取user32实体对象
 User32 INSTANCE = (User32) Native.loadLibrary((Platform.isWindows() ? "user32" : "c"), User32.class);

# 2:找到窗口推向（根据标题名字查找）
 final HWND hwnd = User32.INSTANCE.FindWindowA(null, "Title"); 

# 3:调用任务栏高亮方法
 User32.INSTANCE.FlashWindow(hwnd, true);
